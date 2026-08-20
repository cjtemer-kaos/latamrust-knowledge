# Director Agent Runtime: Diseño Concreto v1 (Claude Code Analysis)

# ANÁLISIS PROFUNDO: Director como Agent Runtime — Diseño Concreto

RESTORE → COMPACT → COMMAND → BUILD → RUN → SAVE → RESPOND → DONE

## Temas
- + subsistemas instanciados en __init__ (SessionManager, TokenBudget, GoalDetector, DAGCoordinator, CheckpointStore, RecipeEngine, LoopGuard, GraphEvol
- classify_task() = keyword matching dict (65 keywords → 22 gemas)
- execute() = classify → GemaHost.execute_gema() → si falla → ai_tools.quick_response()
- gemas hardcodeadas con modelo asignado fijo
- NO tiene loop propio (una sola llamada LLM por request)
- NO itera sobre tool_calls (pasa la pelota al LLM y espera respuesta completa)
- NO tiene fallback de modelo (si el modelo falla → crash)
- NO inspecciona tool calls antes de ejecutarlos

## Codigo
```
AgentLoop (state machine):
  RESTORE → COMPACT → COMMAND → BUILD → RUN → SAVE → RESPOND → DONE
  
AgentRunner (tool execution loop):
  while iterations < max:
    response = provider.chat(messages, tools)
    if response.has_tool_calls:
      results = execute_tools(response.tool_calls)
      messag
```

```
QueryContext:
  api_client, tool_registry, permission_checker, cwd, model, system_prompt
  max_tokens, context_window_tokens, auto_compact_threshold, max_turns=200

Query Loop:
  while turns < max_turns:
    try:
      response = api_client.stream(messages)
    except PromptTooLong:
      messages =
```

```
RalphLoop:
  while not task.is_complete and iteration < max_iterations:
    1. Load state from MEMORY.md
    2. Execute one iteration
    3. Check result
    4. If failed → analyze → adjust strategy
    5. Save progress
    6. StopHook.intercept() prevents premature exit

Handler Registry (modular t
```
