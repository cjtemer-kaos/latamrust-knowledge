# Direct: cableado_aprendizaje_latamrust

Category: Learned
Tags: latamrust-nexus, cableado, aprendizaje
Created: 2026-08-18T11:49:56.719997

---

2026-08-18 se cablearon los sistemas de aprendizaje en latamrust-nexus segun directivas de supernexus-v2. (1) LearningLoop (src/core/learning_loop.py): se anadieron register_searcher en director_service.py tras register_known — SEARCH_BRAIN->Cerebro.obtener_conocimientos (palabras >4 chars vs temas), SEARCH_WEB->director.web_researcher.search, SEARCH_SKILLS->director.skill_loader.match_skills (ojo: el skill registry real es skill_loader/ProgressiveSkillLoader, NO skill_registry.get_relevant_skills). Antes learn() siempre devolvia found=False. (2) SelfLearningLoop: metodo nuevo record(task,model,outcome,quality) que llena _records directamente; director.py en execute() tras record_outcome llama _self_learning.record con datos reales. (3) GraphEvolution: director.execute() anade graph_evolution.add_node(node_id,task) siempre y record_failure si no success (add_node ANTES que record_failure porque sus rewrite rules acceden a graph.nodes). Todos los feeds en try/except con logger.debug (un fallo NUNCA rompe la respuesta). Verificado con AST + imports + logica real (learn=True, records=1, grafo con evolucion).
