"""
NexusHive Autonomous Loop - El agente que nunca duerme

Un chatbot espera. Un agente se activa solo.
Este loop revisa el message_board.db cada N segundos,
detecta tareas pendientes, y las despacha al agente correcto.

Basado en el BLAST Framework:
- Blueprint: Ejecutar tareas asincronas sin intervencion humana
- Links: SQLite message_board + MCP tools
- Architecture: Loop -> Detect -> Decide -> Execute -> Report
- Style: Silencioso, eficiente, autonomo
- Trigger: Tareas con msg_type="task" sin respuesta

Uso:
  python nexus_autonomous_loop.py [--interval 10] [--agent claude-code]
"""

import sqlite3
import json
import time
import argparse
import subprocess
import os
from pathlib import Path
from datetime import datetime, timedelta

# ============================================================
# Config
# ============================================================
BRAIN_DIR = Path.home() / ".nexus" / "brain"
BOARD_DB = BRAIN_DIR / "message_board.db"
FINDINGS_FILE = BRAIN_DIR / "findings.md"
DECISIONS_FILE = BRAIN_DIR / "decisions.md"
CLOUD_FILE = BRAIN_DIR / "cloud.md"
LOOP_LOG = BRAIN_DIR / "loop_activity.log"

# Permisos por agente (Suprawall basico)
AGENT_PERMISSIONS = {
    "claude-code": {
        "can_execute": True,
        "can_read_all": True,
        "can_write_memory": True,
        "can_delegate": True,
        "max_tasks_per_cycle": 5,
        "allowed_channels": ["*"],
    },
    "opencode": {
        "can_execute": True,
        "can_read_all": True,
        "can_write_memory": True,
        "can_delegate": False,
        "max_tasks_per_cycle": 3,
        "allowed_channels": ["general", "tasks", "code"],
    },
    "antigravity": {
        "can_execute": True,
        "can_read_all": True,
        "can_write_memory": True,
        "can_delegate": True,
        "max_tasks_per_cycle": 5,
        "allowed_channels": ["*"],
    },
    "openclaw": {
        "can_execute": True,
        "can_read_all": False,  # Solo sus mensajes
        "can_write_memory": False,
        "can_delegate": False,
        "max_tasks_per_cycle": 2,
        "allowed_channels": ["general", "tasks"],
    },
}


def log(msg: str):
    """Log con timestamp"""
    ts = datetime.now().strftime("%H:%M:%S")
    line = f"[{ts}] {msg}"
    print(line)
    with open(LOOP_LOG, "a", encoding="utf-8") as f:
        f.write(line + "\n")


def get_pending_tasks(agent: str, since_minutes: int = 60) -> list:
    """Busca tareas pendientes dirigidas a un agente"""
    if not BOARD_DB.exists():
        return []

    conn = sqlite3.connect(str(BOARD_DB))
    cutoff = (datetime.now() - timedelta(minutes=since_minutes)).isoformat()

    # Tareas dirigidas a este agente que no tienen respuesta
    tasks = conn.execute("""
        SELECT id, timestamp, sender, content, channel
        FROM messages
        WHERE (target = ? OR target = '*')
        AND msg_type = 'task'
        AND timestamp > ?
        AND id NOT IN (
            SELECT CAST(json_extract(metadata, '$.reply_to') AS INTEGER)
            FROM messages
            WHERE sender = ? AND metadata LIKE '%reply_to%'
        )
        ORDER BY id ASC
    """, (agent, cutoff, agent)).fetchall()

    conn.close()
    return [{"id": r[0], "timestamp": r[1], "sender": r[2], "content": r[3], "channel": r[4]} for r in tasks]


def get_unresponded_tasks(agent: str, since_minutes: int = 60) -> list:
    """Busca tareas que nadie ha respondido (mas simple, sin json_extract)"""
    if not BOARD_DB.exists():
        return []

    conn = sqlite3.connect(str(BOARD_DB))
    cutoff = (datetime.now() - timedelta(minutes=since_minutes)).isoformat()

    # Todas las tareas dirigidas a este agente
    tasks = conn.execute("""
        SELECT id, timestamp, sender, content, channel
        FROM messages
        WHERE (target = ? OR target = '*')
        AND msg_type = 'task'
        AND sender != ?
        AND timestamp > ?
        ORDER BY id ASC
    """, (agent, agent, cutoff)).fetchall()

    # Respuestas que ya dio este agente
    responses = conn.execute("""
        SELECT content FROM messages
        WHERE sender = ?
        AND channel = 'tasks'
        AND timestamp > ?
    """, (agent, cutoff)).fetchall()

    conn.close()

    # Filtrar tareas ya respondidas (heuristico: si el contenido aparece en alguna respuesta)
    responded_ids = set()
    response_texts = " ".join(r[0] for r in responses).lower()

    pending = []
    for t in tasks:
        # Si ya respondimos algo que menciona el ID o contenido parcial, skip
        task_key = t[3][:30].lower()
        if task_key in response_texts:
            continue
        pending.append({"id": t[0], "timestamp": t[1], "sender": t[2], "content": t[3], "channel": t[4]})

    return pending


def check_permissions(agent: str, action: str) -> bool:
    """Verifica si un agente tiene permiso para una accion"""
    perms = AGENT_PERMISSIONS.get(agent, {})
    return perms.get(action, False)


def record_finding(agent: str, finding: str):
    """Registra un hallazgo en findings.md"""
    FINDINGS_FILE.parent.mkdir(parents=True, exist_ok=True)
    ts = datetime.now().strftime("%Y-%m-%d %H:%M")
    entry = f"\n## [{ts}] {agent}\n{finding}\n"
    with open(FINDINGS_FILE, "a", encoding="utf-8") as f:
        f.write(entry)


def record_decision(agent: str, decision: str, reason: str):
    """Registra una decision en decisions.md"""
    DECISIONS_FILE.parent.mkdir(parents=True, exist_ok=True)
    ts = datetime.now().strftime("%Y-%m-%d %H:%M")
    entry = f"\n## [{ts}] {agent}\n**Decision:** {decision}\n**Razon:** {reason}\n"
    with open(DECISIONS_FILE, "a", encoding="utf-8") as f:
        f.write(entry)


def mark_task_seen(task_id: int, agent: str):
    """Marca una tarea como vista/procesada"""
    conn = sqlite3.connect(str(BOARD_DB))
    conn.execute("""
        INSERT INTO messages (timestamp, sender, target, channel, content, msg_type, metadata)
        VALUES (?, ?, ?, 'tasks', ?, 'ack', ?)
    """, (
        datetime.now().isoformat(),
        agent,
        "system",
        f"ACK task #{task_id}",
        json.dumps({"reply_to": task_id})
    ))
    conn.commit()
    conn.close()


def dispatch_task(task: dict, agent: str) -> str:
    """
    Despacha una tarea. Por ahora solo la loguea.
    En el futuro puede:
    - Llamar a un LLM local via Ollama
    - Ejecutar un script
    - Enviar via MCP a otro agente
    """
    content = task["content"]
    sender = task["sender"]

    log(f"  TASK #{task['id']} from {sender}: {content[:80]}")

    # Decision: que hacer con esta tarea
    if content.startswith("TAREA:") or content.startswith("ANALIZAR:") or content.startswith("VERIFICAR:"):
        # Tarea ejecutable - registrar que la vimos
        mark_task_seen(task["id"], agent)
        record_finding(agent, f"Tarea recibida de {sender}: {content[:100]}")
        return "acknowledged"

    elif content.startswith("NUEVA:"):
        mark_task_seen(task["id"], agent)
        return "queued"

    else:
        # Tarea generica
        mark_task_seen(task["id"], agent)
        return "seen"


def run_loop(agent: str, interval: int = 10, max_cycles: int = 0):
    """
    Loop principal autonomo.

    Loop -> Detect -> Decide -> Execute -> Report -> Sleep -> Repeat
    """
    log(f"=== NexusHive Autonomous Loop ===")
    log(f"Agent: {agent}")
    log(f"Interval: {interval}s")
    log(f"DB: {BOARD_DB}")
    log(f"Permisos: {json.dumps(AGENT_PERMISSIONS.get(agent, {}), indent=2)}")
    log("")

    if not check_permissions(agent, "can_execute"):
        log(f"ERROR: Agent '{agent}' no tiene permiso can_execute")
        return

    cycle = 0
    while True:
        cycle += 1
        if max_cycles > 0 and cycle > max_cycles:
            log(f"Max cycles ({max_cycles}) reached. Stopping.")
            break

        try:
            # 1. DETECT - buscar tareas pendientes
            tasks = get_unresponded_tasks(agent, since_minutes=120)

            if tasks:
                log(f"Cycle {cycle}: {len(tasks)} tarea(s) pendiente(s)")

                # 2. DECIDE - cuantas procesar este ciclo
                max_tasks = AGENT_PERMISSIONS.get(agent, {}).get("max_tasks_per_cycle", 3)
                to_process = tasks[:max_tasks]

                # 3. EXECUTE - despachar
                for task in to_process:
                    result = dispatch_task(task, agent)
                    log(f"    -> {result}")

                # 4. REPORT
                record_decision(agent,
                    f"Procesadas {len(to_process)} tareas en cycle {cycle}",
                    f"Habia {len(tasks)} pendientes, max por ciclo: {max_tasks}")

            else:
                if cycle % 6 == 0:  # Log cada ~60s si interval=10
                    log(f"Cycle {cycle}: Sin tareas pendientes")

        except Exception as e:
            log(f"ERROR cycle {cycle}: {e}")

        # 5. SLEEP
        time.sleep(interval)


# ============================================================
# Inicializar archivos de memoria si no existen
# ============================================================
def init_memory_files():
    """Crea los archivos de memoria del BLAST framework"""

    if not FINDINGS_FILE.exists():
        FINDINGS_FILE.write_text(
            "# Findings - NexusHive\n\n"
            "Datos recolectados por los agentes durante su operacion.\n"
            "Cada entrada tiene timestamp, agente, y hallazgo.\n\n",
            encoding="utf-8"
        )

    if not DECISIONS_FILE.exists():
        DECISIONS_FILE.write_text(
            "# Decisions - NexusHive\n\n"
            "Decisiones tomadas por los agentes y su razonamiento.\n"
            "Sirve como historial de aprendizaje del sistema.\n\n",
            encoding="utf-8"
        )

    if not CLOUD_FILE.exists():
        CLOUD_FILE.write_text(
            "# Cloud - NexusHive Master Instructions\n\n"
            "## Identity\n"
            "NexusHive es una colmena de agentes IA que colaboran autonomamente.\n\n"
            "## Agents\n"
            "- claude-code: Coding, analysis, architecture (Anthropic Claude)\n"
            "- opencode: Coding, local execution (OpenCode + Nexus/Qwen)\n"
            "- antigravity: Research, web, creative (Gemini)\n"
            "- openclaw: GPU tasks, PC2 operations (OpenClaw)\n"
            "- supernexus: Director, orchestrator (SuperNEXUS)\n\n"
            "## Rules\n"
            "1. Cada agente revisa tareas al iniciar sesion\n"
            "2. Las tareas se procesan en orden de prioridad\n"
            "3. Siempre reportar resultado al sender\n"
            "4. No ejecutar tareas fuera de tus permisos\n"
            "5. Registrar findings y decisions para aprendizaje\n\n"
            "## BLAST Framework\n"
            "- Blueprint: Definir resultado final, no pasos\n"
            "- Links: SQLite message_board + MCP tools\n"
            "- Architecture: Loop -> Detect -> Decide -> Execute -> Report\n"
            "- Style: Autonomo, silencioso, eficiente\n"
            "- Trigger: msg_type='task' en message_board.db\n\n"
            "## Security (Suprawall)\n"
            "Cada agente tiene permisos definidos en AGENT_PERMISSIONS.\n"
            "No se pueden escalar permisos sin aprobacion humana.\n",
            encoding="utf-8"
        )


# ============================================================
# Entry point
# ============================================================
if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="NexusHive Autonomous Loop")
    parser.add_argument("--agent", default="claude-code", help="Agent identity")
    parser.add_argument("--interval", type=int, default=10, help="Check interval in seconds")
    parser.add_argument("--cycles", type=int, default=0, help="Max cycles (0=infinite)")
    args = parser.parse_args()

    init_memory_files()
    run_loop(agent=args.agent, interval=args.interval, max_cycles=args.cycles)
