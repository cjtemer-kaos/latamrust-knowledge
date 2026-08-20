# Autopsia: Analisis Exhaustivo 6 Repos

# ANALISIS EXHAUSTIVO: 6 Repos Clonados en Autopsia (2026-05-25)

Lenguaje: Python 3.11+, MIT. 554 files, 37.5MB. v0.2.0 (Mayo 2026).

## Temas
- Facade: Nanobot -> AgentLoop (state machine 7 estados) -> AgentRunner (tool loop)
- Provider trait: LLMProvider ABC con 14 implementaciones (anthropic, openai, azure, bedrock, github_copilot, codex, openai_compat, fallback)
- AgentLoop estados: RESTORE -> COMPACT -> COMMAND -> BUILD -> RUN -> SAVE -> RESPOND -> DONE
- AgentRunner: context governance (snip, microcompact, budget), streaming, retry, tool execution paralelo, injection draining, empty response recovery, 
- ToolRegistry: plugin loader, MCP, file state tracking
- Memory: Consolidator (token-based) + Dream (2-stage) + AutoCompact
- Channels: Telegram, Discord, Slack, Feishu, WeChat, CLI, WebSocket, WebUI, WhatsApp, DingTalk
- Hooks: AgentHook lifecycle (before_iteration, after_iteration, on_stream, emit_reasoning)

## Codigo

