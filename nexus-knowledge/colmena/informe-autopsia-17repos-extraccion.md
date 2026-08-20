# informe-autopsia-17repos-extraccion

# INFORME AUTOPSIA 17 REPOS — PARTE 2: QUÉ EXTRAER (2026-05-18)

INFORME AUTOPSIA 17 REPOS — PARTE 2: QUÉ EXTRAER (2026-05-18)

## Temas
- tools/delegate_tool.py (2796 líneas) → sub-agent spawning, ThreadPool, depth MAX=3, approval callbacks → core/dag_coordinator.py
- tools/registry.py (25KB) → AST-based autodiscovery, ToolEntry schema → tools/builtin.py
- agent/background_review.py (29KB) → forked agents, tool whitelist, conversation replay → core/background_review.py
- agent/curator.py (77KB) → skill lifecycle active→stale→archived → core/skill_curator.py
- hermes_state.py → SQLite FTS5, WAL, NFS fallback, parent sessions → core/session_manager.py
- cron/scheduler.py (330+) → file locking, injection scanning, toolset scoping → NUEVO core/scheduler.py
- tools/mcp_tool.py (3564 líneas) → MCP lifecycle, OAuth, streaming → bridges/mcp_bridge_server.py
- tools/mixture_of_agents_tool.py (542 líneas) → multi-model parallel, aggregator → NUEVO core/mixture_of_agents.py

## Codigo

