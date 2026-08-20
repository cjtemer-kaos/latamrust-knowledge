# Direct: cableado_agentes_externos_skills

Category: Learned
Tags: direct-learned
Created: 2026-08-16T14:08:12.193155

---

CABLEADO RONDA 2026-08-16 (2): (1) SEARCH_SKILLS del LearningLoop corregido: apuntaba a skill_registry.get_relevant_skills (inexistente) -> ahora usa director.skill_loader.match_skills (ProgressiveSkillLoader, 1872 SKILL.md). (2) Import roto get_skill_lifecycle -> get_lifecycle_manager, montado en modules. (3) AutoSkillCreator.after_task_hook conectado (>3 tool calls o >5min -> crea skill auto-extracted). (4) ExternalAgentRegistry.best_for() conectado: tras fallback de gemas delega al mejor agente externo registrado en command_dispatcher (hermes/aider/agent-zero/openclaw/oma). (5) Hallazgos: 19 agentes externos, solo hermes+aider funcionales; agent-zero doble bug (nombre contenedor + volumen no montado); 6 autonomous loops; 88 MCP tools nexus-bridge (41 HTTP); ComputerControl+PCController+agent_cu controlan PC; Discord gateway funcional.
