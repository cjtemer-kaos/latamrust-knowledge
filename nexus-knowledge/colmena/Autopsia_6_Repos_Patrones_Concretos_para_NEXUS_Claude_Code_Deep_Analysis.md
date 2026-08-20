# Autopsia 6 Repos: Patrones Concretos para NEXUS (Claude Code Deep Analysis)

# AUTOPSIA PROFUNDA — Patrones Extraídos de 6 Repos

| Priority | Source | Pattern | Files to create |

## Temas
- AgentLoop: state machine 7 estados (RESTORE→COMPACT→COMMAND→BUILD→RUN→SAVE→RESPOND→DONE) con transition table (state,event)→next
- AgentRunner: tool loop reutilizable. Solo necesita LLMProvider + ToolRegistry. Handles: tool exec, injection draining, empty recovery, length recovery
- AgentRunSpec: initial_messages, tools, model, max_iterations, max_tool_result_chars, hook, injection_callback, llm_timeout_s
- FallbackProvider: circuit breaker (3 failures→trip→cooldown 60s→half-open probe). Error classification: FALLBACK_KINDS={timeout,connection,server_erro
- ProviderSnapshot(frozen): provider, model, context_window_tokens, signature
- make_provider(config): resolves preset→provider_name→backend→instantiate→wrap with FallbackProvider
- Injection system: mid-turn user messages via callback. Max 3/turn, 5 cycles. Enables "interrupt and redirect"
- Consolidator + Dream: 2-stage memory compaction. Dream = async background summarization

## Codigo

