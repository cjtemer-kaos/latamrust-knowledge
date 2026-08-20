# openhands-architecture

OpenHands v1.7.0 deep analysis completed. 3-layer architecture: SDK (composable Python library) → Agent Server (REST in Docker sandbox) → App Server (FastAPI orchestrator). Top reusable patterns for SuperNEXUS: (1) EventCallbackProcessor with webhook architecture, (2) SandboxService ABC with session_api_key auth, (3) 4-level keyword-triggered skills, (4) 6 condenser types for context management, (5) MCP namespace proxy pattern. Key differentiator: SDK is a standalone library, each conversation gets its own agent-server in Docker. Full report in obs #83.
