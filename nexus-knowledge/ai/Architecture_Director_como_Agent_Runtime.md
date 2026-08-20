# Architecture: Director como Agent Runtime

# Diagnostico: Nexus no es independiente del motor LLM

Nexus delega el control al LLM. El Director solo clasifica tareas y las pasa a gemas, que llaman al LLM directamente. El LLM es dueno del control, no Nexus.

## Temas
- Loop ownership**: Goose tiene `Agent` struct con state machine. OpenClaw tiene `agentCommand` -> `runEmbeddedPiAgent`. Nexus: Director delega a gema -
- Provider abstraction**: Goose tiene `Provider` trait con 25+ implementaciones (Anthropic, OpenAI, Ollama, etc.). OpenClaw tiene agent runtimes (pi emb
- Tool inspection pipeline**: Goose tiene `ToolInspectionManager` con 5 inspectors (Security, Egress, Adversary, Permission, Repetition) que corren ANTE
- Recibir tarea/input
- Build context (prompts + skills + memory + observations)
- Call provider via abstract Provider trait (ollama, openai, anthropic, etc.)
- complete(system, messages, tools) -> stream<ProviderMessage>
- list_models() -> list<ModelInfo>

## Codigo
```
Director Agent Runtime:
  1. Recibir tarea/input
  2. Build context (prompts + skills + memory + observations)
  3. Call provider via abstract Provider trait (ollama, openai, anthropic, etc.)
  4. Parse response (text + tool_calls)
  5. ToolInspection pipeline (security sandbox)
  6. Execute approve
```
