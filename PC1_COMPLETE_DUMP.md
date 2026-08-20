# PC1 Complete Knowledge Dump

## System Information
- **Platform**: Windows 10/11
- **User**: cjtr
- **Python**: C:\Users\cjtr\AppData\Local\Programs\Python\Python313\python.exe
- **Node.js**: v25.9.0, npm v11.19.0
- **Git**: installed
- **GitHub**: cjtemer-kaos (gh CLI authenticated)

## Directory Structure
```
D:\
├── ias\
│   ├── proyectos\
│   │   ├── supernexus-v2\     # SuperNEXUS v2 server (port 9000)
│   │   │   ├── brain\         # Shared brain (cerebro.db + nexus_memory.db)
│   │   │   ├── src\           # Source code
│   │   │   └── start_server.py
│   │   └── hermes-agent\      # Hermes Agent (CLI + dashboard)
│   │       ├── hermes.bat
│   │       └── workspace\     # v2.3.0, dev on :3000
│   └── autopsia\
│       └── hermes-workspace\  # Hermes workspace
├── autopsia\
│   ├── veyra\                 # (deleted) Veyra source
│   └── veyramix\              # (deleted) VeyraMix
```

## Key Files
- `C:\Users\cjtr\.config\opencode\opencode.json` — OpenCode configuration
- `C:\Users\cjtr\.config\opencode\AGENTS.md` — My instructions
- `D:\ias\proyectos\supernexus-v2\brain\cerebro.db` — Main brain database
- `C:\Users\cjtr\.nexus\brain\` — latamrust-nexus brain (386 knowledge items)

## Running Services
| Service | Port | Location |
|---------|------|----------|
| SuperNEXUS v2 | 9000 | D:\ias\proyectos\supernexus-v2\ |
| Agent Zero | 50080 | Docker (localhost) |
| Redis | 6379 | Docker |
| n8n | 5678 | Docker |
| Hermes Dashboard | 9119 | D:\ias\proyectos\hermes-agent\ |
| Hermes Dev | 3000 | D:\ias\proyectos\hermes-agent\ |

## Audio Devices (Current State)
- **VB-CABLE**: Installed (CABLE Input / CABLE Output)
- **VoiceMeeter**: Uninstalled
- **Veyra Sounds**: Installed but processes may linger
- **USB Microphone**: `3- Usb Microphone` (VID_1B3F&PID_2008)
- **Bluetooth**: OPPO, BT-163
- **Sound Blaster**: X-Fi Xtreme Audio

## MCP Tools Available
### DirectorNexus Core
- `classify_task`, `execute_with_gema`, `run_agent_loop`, `run_harness`
- `get_director_status`, `change_project`, `get_relevant_skills`

### Multi-Agent
- `spawn_sub_agent`, `mixture_of_agents`

### Quality & Analysis
- `evaluate_quality`, `doctor_diagnose`, `codegraph_analyze`

### NexusHive Communication
- `send_message`, `read_messages`, `memory_set`, `memory_get`
- `brain_remember`, `brain_recall`

### Memory & Knowledge
- `add_observation`, `search_observations`, `get_observation`
- `add_task_finding`, `list_findings`, `memory_stats`

### Node Control
- `execute_on_pc2`, `list_nodes`, `get_system_info`

### Skills
- `list_skills`, `load_skill`, `load_skill_section`

### RAG & Codebase
- `rag_index`, `rag_search`, `rag_stats`
- `codebase_context`, `codebase_query`

### System
- `nexus_status`, `system_resources`
- `optimize_prompt`, `select_model`, `token_report`

## Startup Rule
At the START of every conversation, use `read_messages` to check for pending messages directed to me (target="opencode"). This is mandatory.

## Protocol
1. On session start: call `read_messages` automatically
2. If pending tasks from other agents: acknowledge and execute
3. When completing tasks: send response via `send_message`
4. For cross-agent coordination: use `send_message` with specific targets
5. Use `execute_with_gema` or `run_harness` for complex tasks

## Brains Fusion Protocol
- My brain and SuperNEXUS are fused into one
- RAG automatic: brain_recall + rag_search before responding
- After learning: add_observation + brain_remember
- Each session: brain_recall("general") on start
- Complex messages: rag_search + search_observations before responding
- Important tasks: brain_remember("lesson: ...", content) on finish
