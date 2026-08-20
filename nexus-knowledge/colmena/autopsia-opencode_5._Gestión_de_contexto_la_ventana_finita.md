# autopsia-opencode: 5. Gestión de contexto (la ventana finita)

# 5. Gestión de contexto (la ventana finita)

5. Gestión de contexto (la ventana finita)

## Temas
- El **system prompt** (identidad, reglas, skills, AGENTS.md) — siempre.
- El **historial de la conversación** (mensajes del usuario + respuestas + resultados de tools).
- Contexto inyectado** por el harness: archivos relevantes, skills cargados, fecha, entorno.
- Skills** cargados on-demand cuando la tarea los matchea.
- Mensajes del usuario** — el prompt original y aclaraciones posteriores.
- Respuestas del agente** — texto generado + tool calls.
- Resultados de tools** — archivos leídos, salidas de comandos, logs.
- Dejo de re-leer** lo que ya está en contexto.

## Codigo

