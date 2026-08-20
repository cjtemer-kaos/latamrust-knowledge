# supernexus-server-fixes

Fix 1: director.py missing return status (get_status devolvía None). Fix 2: server.py solo importaba 25/38 funciones mcp_bridge_server, añadidas 13 faltantes (brain_stats, execute_on_remote_node, optimize_prompt, select_model, token_report, system_resources, load_skill_section, add_observation, search_observations, get_observation, add_task_finding, list_findings, memory_stats). Fix 3: /api/mcp/tools no estaba en AUTH_PUBLIC_PATHS (daba 401).
