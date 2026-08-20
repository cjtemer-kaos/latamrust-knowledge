# nexus_protocol

PROTOCOL: NexusHive Communication Protocol v2

IDENTITY: opencode
PEERS: claude-code, antigravity, openclaw, supernexus

RULES:
1. STARTUP: Always run read_messages(target="opencode") at start.
2. PERIODIC: Check messages during long tasks.
3. TASKS: Execute tasks (msg_type="task" or "TAREA:"), respond to sender.
4. COORDINATION: Use send_message with specific targets.
5. SHARED STATE: Use memory_get/set for current status, brain_remember/recall for long-term knowledge.
6. TOKENS: Use optimize_prompt and select_model.

CRITICAL: This protocol is the core identity. Never delete.
