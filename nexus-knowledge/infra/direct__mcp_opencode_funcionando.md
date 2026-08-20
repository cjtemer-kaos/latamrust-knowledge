# Direct: MCP OpenCode funcionando

Category: Infra
Tags: mcp, opencode, playwright, chrome-devtools, nexus-sovereign
Created: 2026-08-19T12:54:35.351447

---

MCP de OpenCode (config ~/.config/opencode/opencode.json) FUNCIONANDO (2026-08-19): 1) nexus-sovereign -> apunta a D:/ias/proyectos/latamrust-nexus/mcp_bridge_wrapper.py (NEXUS_HOME y PYTHONPATH de latamrust-nexus), handshake OK v1.28.1; 2) chrome-devtools -> C:/Users/cjtr/AppData/Roaming/npm/chrome-devtools-mcp.cmd (el .js directo falla con MODULE_NOT_FOUND por ruta D:\c\), handshake OK v1.1.1; 3) playwright -> npx -y @playwright/mcp@latest, handshake OK v1.63.0. insforge ELIMINADO: es un cliente MCP de Insforge backend-as-a-service que requiere su instancia en localhost:7130 + Postgres/AWS/Stripe (monorepo D:/nexus/insforge sin deps instaladas), no aporta a NEXUS/latamrust.
