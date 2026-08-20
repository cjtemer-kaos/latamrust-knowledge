# PC1 Brain Backup

Copia completa del cerebro compartido de PC1 (`C:\Users\cjtr\.nexus\brain\`).

## Archivos Principales

| Archivo | Tamaño | Descripción |
|---------|--------|-------------|
| `cerebro.db` | 7.7 MB | Base de datos principal del cerebro (conocimientos, sesiones) |
| `nexus_memory.db` | 933 KB | Memoria FTS5 (búsqueda full-text) |
| `knowledge_graph.db` | 6.1 MB | Grafo de conocimiento |
| `sessions.db` | 2.6 MB | Historial de sesiones |
| `message_board.db` | 2.4 MB | Tablero de mensajes entre agentes |
| `hybrid_memory.db` | 1.8 MB | Memoria híbrida |
| `findings.md` | 91 KB | Hallazgos importantes |
| `decisions.md` | 9.6 KB | Decisiones tomadas |
| `learning.json` | 914 B | Estado de aprendizaje |
| `router_state.json` | 580 B | Estado del router Thompson Sampling |

## Bases de Datos SQLite

- `auth.db` — Autenticación
- `checkpoints.db` — Checkpoints de sesiones
- `codebase_index.db` — Índice de código
- `compose.db` — Composición
- `credentials.db` — Credenciales
- `curator.db` — Curador de conocimiento
- `cursor.db` — Cursor de sesiones
- `dream.db` — Modo dream
- `episodes.db` — Episodios
- `event_store.db` — Almacén de eventos
- `learning.db` — Aprendizaje
- `learning_graph.db` — Grafo de aprendizaje
- `learning_loop.db` — Loop de aprendizaje
- `message_bus.db` — Bus de mensajes
- `search.db` — Búsqueda
- `self_improving.db` — Auto-mejora
- `skills_creator.db` — Creador de skills
- `skill_lifecycle.db` — Ciclo de vida de skills
- `task_executor.db` — Ejecutor de tareas

## Archivos de Configuración

- `cloud.md` — Configuración cloud
- `router_state.json` — Estado del router
- `token_secret.key` — Clave secreta (NO compartir)
- `recovered_context.json` — Contexto recuperado

## Uso

1. Copiar esta carpeta a `C:\Users\cjtr\.nexus\brain\` en PC2
2. Asegurarse de que la variable de entorno `NEXUS_BRAIN` apunte a esta carpeta
3. Reiniciar servicios de SuperNEXUS

## Nota

Estos archivos están en **timestamp** del 13/08/2026. Para una copia más reciente, ejecutar el backup nuevamente.
