# Work History - Last Months

## LatamRust Project

### Launcher Development
- **CobbleVerse Launcher v5 Electron**: Built with custom Pokeball/LR icon, NSIS installer
- **SrJenko Launcher**: NSIS installer built with Charizard icon
- Both launchers synced to `\\PC2-NEXUS\share\`
- **Launcher game install dir**: `%AppDATA%\LatamRust` (never move)

### Server Knowledge (latamrust-knowledge repo)
- Cloned to `C:\Users\cjtr\Desktop\latamrust-knowledge\`
- 20 LATAMRUST + 5 launcher memories saved to brain
- Comprehensive server docs learned

### Audio Configuration (Veyra Sounds)
- Installed Veyra Sounds v1.2.0 (unsigned portable build)
- Audio Bridge: CABLE Input → Auriculares (BT-163) — Status: Live
- VoiceMeeter VAIO driver installed but problematic
- VB-CABLE installed for virtual audio
- User is musician with complex multi-device audio setup
- USB Microphone: `3- Usb Microphone` (VID_1B3F&PID_2008)

### Veyra Source Code Modifications
- Cloned Veyra repo to `D:\autopsia\veyra`
- Added VoiceMeeter detection functions to AudioDevices.cpp
- Added VoiceMeeter warning to DevicesScreen.cpp
- Successfully compiled (130/130 targets)
- Problem: Mic Bridge and Audio Bridge couldn't use same VoiceMeeter device

### Networking
- PC1: localhost (SuperNEXUS v2, port 9000)
- PC2: 192.168.1.50 (legacy nexus.py, port 9000)
- Agent Zero: localhost:50080 (Docker)
- Hermes Dashboard: localhost:9119
- MCP Bridge: stdio via opencode.json

## SuperNEXUS Development

### New Modules (Autopsia Absorption)
- `src/core/event_store.py` — Event sourcing with SQLite
- `src/core/provider_base.py` — Async LLM provider base with streaming
- `src/core/sandbox_service.py` — Secure command execution
- `src/core/wait_for_helper.py` — Async polling with backoff
- `src/core/response_builder.py` — Structured response formatting
- `src/tools/cdp_browser.py` — Chrome DevTools Protocol
- `src/core/agent_teams.py` — Multi-agent team coordination
- `src/core/codebase_context.py` — Compressed codebase for AI context
- `src/core/local_tool_calling.py` — Local function calling
- `src/core/mcp_connection_manager.py` — MCP client manager
- `src/core/midelware_pipeline.py` — Middleware pipeline
- `src/core/rag_engine.py` — RAG with embeddings
- `src/core/vram_router.py` — VRAM-based model routing
- `src/core/adaptive_router.py` — Thompson Sampling routing
- `src/core/self_learning_loop.py` — Continuous improvement loop
- `src/core/hierarchical_memory.py` — 3 tiers with forgetting curves
- `src/core/multi_signal_retrieval.py` — Hybrid search vector+keyword+entities

### Refactoring Done
- director.py (1020 lines, init groups)
- server.py (3360 lines, sanitized routes)

## Hermes Agent
- Workspace: `D:\ias\autopsia\hermes-workspace` v2.3.0
- Dev server on :3000
- Dashboard on :9119
- CLI: `hermes -z "prompt"` or `hermes` (interactive)

## Docker Services
- Agent Zero (agent0ai/agent-zero) on port 50080
- Redis (redis:alpine) on port 6379
- n8n (n8nio/n8n) on port 5678

## Streaming Setup
- StreamElements Account: "kaosmcs" (cjtemer@gmail.com)
- Overlay: "Alertas Kick + YouTube"
- OBS: Browser source "SE Alertas Kick+YT" added to Main scene
