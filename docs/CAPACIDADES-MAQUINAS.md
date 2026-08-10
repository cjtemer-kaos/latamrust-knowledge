# CAPACIDADES DE MÁQUINAS — PC1 ↔ PC2 (2026-08-10)

> Documento de capacidades compartido para el enrutamiento eficiente de tareas.
> Fuente: consulta directa Ollama (PC1 + PC2) + config Hermes (OpenCode Zen/Go).

---

## 🖥️ PC1 — "SuperNEXUS" (mejor hardware, broker de comunicación)

### Hardware
- **Mejor hardware** del equipo (según usuario)
- Corre el **broker de comunicación** (comm_server.py, puertos 9400/9401)
- Director LLM: **nexus-director-v6** (Ollama local)

### Ollama local (12 modelos)
| Modelo | Uso |
|--------|-----|
| `nexus-director-v6` | ⭐ **DIRECTOR** — router agéntico (5.1s latencia) |
| `nexus-director-v5` | Director anterior (respaldo) |
| `qwen2.5:0.5b` | Clasificador rápido de intents (~0.1ms cache) |
| `qwen3.5:9b` | Tareas generales medianas |
| `gemma4:12b` / `gemma4:latest` | Tareas generales grandes |
| `qwen2.5vl:7b` | ⭐ **VISIÓN** (imágenes) — PC1 tiene visión local |
| `qwen2.5-coder:7b` | Código |
| `omnicoder-2-9b` | Código (carstenuhlig) |
| `deepseek-r1:8b` | Razonamiento/reflexión |
| `nemotron-3-nano:4b` | Tareas livianas |
| `nomic-embed-text` | Embeddings |

### Cloud
- **OpenCode Go** (pago) ✅ — main=deepseek-v4-flash, deleg=deepseek-v4-pro, glm-5.2, kimi-k3, qwen3.7-max, gpt-5.6-luna
- **OpenCode Zen** (free) ✅ — deepseek-v4-flash-free, mimo-v2.5-free (visión)
- **Ollama**: 127.0.0.1:11434

---

## 🖥️ PC2 — "LatamRust Nexus" (mantiene el server MC)

### Hardware
- Mantiene el **server Minecraft** (Fabric 1.21.1, 204 mods)
- Acceso **RCON directo** al server (25575)
- Acceso a **archivos del server** (D:/SERVIDOR/servers/LATAMRUST COBBLEMON)
- Repo conocimiento: `cjtemer-kaos/latamrust-knowledge`
- GitHub CLI autenticado (cjtemer-kaos)

### Ollama local (8 modelos)
| Modelo | Uso |
|--------|-----|
| `nexus-director-v5` | Director (v5, no v6) |
| `qwen3.5:2b` | Tareas livianas |
| `deepseek-r1:8b` | Razonamiento |
| `qwen2.5-coder:7b` | Código |
| `gemma3:4b` | General |
| `nemotron-mini` / `nemotron-3-nano:4b` | Livianas |
| `nomic-embed-text` | Embeddings |
| ❌ NO tiene visión local | (usar qwen2.5vl de PC1 o mimo-v2.5-free cloud) |

### Cloud
- **OpenCode Go** (pago) ✅ — main=deepseek-v4-flash, deleg=deepseek-v4-pro, glm-5.2, kimi-k3, qwen3.7-max, gpt-5.6-luna
- **OpenCode Zen** (free) ✅ — deepseek-v4-flash-free (aux), **mimo-v2.5-free (visión)**
- **Ollama**: 127.0.0.1:11434
- Modelo activo en este chat: **mimo-v2.5** (opencode-zen) / deepseek-v4-flash (opencode-go)

---

## 🔀 Matriz de enrutamiento eficiente

| Tarea | Mejor recurso | Por qué |
|-------|--------------|---------|
| **Enrutar mensajes** | PC1 nexus-director-v6 | Es el director |
| **Clasificar intent rápido** | PC1 qwen2.5:0.5b | 0.1ms, gratis |
| **Razonamiento complejo** | deepseek-v4-pro (Go pago) o r1:8b local | Pago = mejor calidad |
| **Código** | qwen2.5-coder:7b local (cualquiera) u omnicoder PC1 | Local = gratis |
| **Visión (imágenes)** | PC1 qwen2.5vl:7b (local) o mimo-v2.5-free (cloud) | PC2 no tiene visión local |
| **Tareas livianas** | qwen3.5:2b / nemotron | Casi gratis |
| **Embeddings** | nomic-embed-text (ambas) | Vectorizar historial |
| **RCON / server MC** | PC2 SIEMPRE | PC2 tiene el server |
| **Edición de archivos** | Cualquiera con acceso | Ambos tienen file access |
| **Conocimiento del server** | PC2 → repo latamrust-knowledge | PC2 lo mantiene |

## ⚙️ Regla de recursos
1. **Local primero** (Ollama = 0 costo), **cloud free segundo** (Zen), **cloud pago último** (Go)
2. **Visión**: PC1 local (qwen2.5vl) o Zen mimo — nunca gastar Go en visión
3. **RCON/server**: solo PC2 ejecuta comandos del server MC
4. **Director**: solo PC1 (nexus-director-v6)
5. **Historial**: ambas escriben al brain compartido (cerebro.db)

---

*Documento generado por PC2 — 2026-08-10. Para actualizar: consultar `ollama list` en cada máquina.*
