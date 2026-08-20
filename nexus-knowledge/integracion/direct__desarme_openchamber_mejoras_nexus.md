# Direct: Desarme OpenChamber mejoras NEXUS

Category: Integracion
Tags: openchamber, opencode, mejoras, session-goals, fusion
Created: 2026-08-19T14:16:47.381955

---

DESARME OpenChamber (github.com/openchamber/openchamber) clonado en D:/autopsias/openchamber. Es un workspace open-source (monorepo v1.19.0, usa @opencode-ai/sdk) para dirigir/supervisar/revisar agentes de IA. Se conecta al backend de opencode (mismos providers del opencode.json global, puede usar Ollama local de esta PC via provider 'ollama'). 4 features copiables: 1) Session Goals - meta con tokenBudget/turnsUsed/blockedStreak + auditor por turno que sigue hasta completar/bloquear/limite; 2) Multi-Run - misma tarea a hasta 5 modelos en worktrees git aislados; 3) Fusion - fusiona ultimas respuestas con delimitadores ---RESULT N---; 4) 26 magic prompts del flujo plan-revision-handoff (plan, implementation, review, reviewFeedback, handoff, fusion). Mejoras copiadas a latamrust-nexus.
