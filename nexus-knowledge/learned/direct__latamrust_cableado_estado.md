# Direct: latamrust_cableado_estado

Category: Learned
Tags: latamrust-nexus, conectividad, aprendizaje
Created: 2026-08-18T11:32:15.842652

---

Mapa de conectividad latamrust-nexus (2026-08-18): Cerebro.aprender_interaccion CONECTADO (7 llamadas en server.py); DeepResearch A+B + WebResearcher CONECTADOS; SelfLearningLoop DEGRADADO (2 instancias: director.py:231 con hooks nunca recibe 'learn', mcp_bridge_server solo-status; server usa ActiveLearningLoop); LearningLoop en flujo pero INERTE (register_searcher 0 call sites, nunca aprende); GraphEvolution HUERFANO (solo get_stats, nunca add_node/record_failure); SelfImprovement y MuonTrainer API-only (bug NameError corregido); NexusTrainer huerfano duplicado en src/brain/nexus_trainer.py; SelfImprovingLoop y LearningGraph NO existen en el fork. Cabos sueltos: register_searchers en LearningLoop, alimentar SelfLearningLoop del director, driver a GraphEvolution.
