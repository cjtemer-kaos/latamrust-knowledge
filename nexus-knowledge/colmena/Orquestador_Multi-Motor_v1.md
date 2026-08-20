# Orquestador Multi-Motor v1

Implementación completa del Orquestador Multi-Motor para DirectorNexus. Commit e70e1e5.

provider_base.py: LLMProvider ABC (chat/chat_stream/chat_with_retry), OllamaProvider, OpenAIProvider, AnthropicProvider, FallbackProvider circuit breaker, ProviderProfile dataclass, create_provider_from_profile factory, ProviderRegistry (register/get/configure/health_check).
agent_runner.py (NUEVO): AgentRunner con tool-calling loop agnóstico, tool_executor externo, streaming on_stream callback, checkpoints.
orchestrator.py (NUEVO): NexusOrchestrator con pipeline decompose (LLM coordinator→TaskDAG) → execute (TaskQueue+AgentRunner) → synthesize (LLM coordinator), status().
director.py: execute() usa AgentRunner como primary, orchestrate() público, multi_motor_status().
server.py: POST /api/orchestrate, GET /api/orchestrate/status.

Validado: syntax, imports, unit tests, E2E con Ollama real (descomposición, ejecución, síntesis, streaming), 176 routes.
