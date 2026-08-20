# Direct: FIX director imports latamrust

Category: Infra
Tags: director, imports, fix, rust, servidores
Created: 2026-08-19T14:57:41.585620

---

FIX cableado director latamrust (2026-08-19): DirectorLatamRustFinal (src/core/director_latamrust.py) no arrancaba por ImportError: from ..gemas import (RconCommanderGema, CombatlogAnalyst, PluginConfigurator, AdvancedPluginEditor, MapEditor, TebexSync, ServerMonitor, DiscordManager, DiscordCommands, AyudaGem, ScholarGem, SageGem, BibliotecaGem, LLMRoleGema, build_all_gemas, list_all_gema_ids) — src/gemas NO tiene esas clases. CORREGIDO: imports apuntan a src/gemas_client_overrides/* (la mayoria), src/agents/* (AyudaGem/ScholarGem/SageGem/BibliotecaGem), src/gemas_core/llm_role_gema (LLMRoleGema). build_all_gemas->build_standard_gemas(gemas_dir=Path) y list_all_gema_ids->list_all_standard_ids() de src/gemas_core/builders.py; GEMAS_DATA_DIR inexistente -> data/gemas del proyecto. RESULTADO: /api/rust/servers paso de 503 a datos reales (lan-main 47/100 online, uptime 72h). Vista Servidores de la UI funcional.
