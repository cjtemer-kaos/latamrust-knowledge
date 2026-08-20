# Direct: supernexus_v2_cableado_completo

Category: Learned
Tags: direct-learned
Created: 2026-08-16T11:29:03.273026

---

ESTUDIO CABLEADO SuperNEXUS v2 (2026-08-16): FLUJO chat: handle_chat->process_message->director.execute (director.py:738)->classify->heuristica action/conv/factual->fallbacks (scholar->agent_runner->gema->determinista)->human_layer->memory_extractor->judge->self_model. MEMORIA: src/brain/ CANONICO (~/.nexus/brain/: cerebro.db, knowledge_graph.db, episodes.db, nexus_memory.db + 30 DBs); src/memory/ LEGACY (data/). brain_remember/recall = MCP SQL directo cerebro.db. GEMAS: 24 plugins/gemas/*.py MANIFEST, handlers NO se invocan (solo metadatos). CABLES ROTOS: (1) import re faltante director.py:834 mata brain recall; (2) quick_response sin model_override -> selector modelo MUERTO; (3) SageGem.save_to_library inexistente; (4) codigo muerto _research_and_persist; (5) JudgePipeline.evaluate mal invocado; (6) initialize_async sin hasattr; (7) GemaHost refiere src.agents.code_gem inexistentes; (8) oma/research/routing services semi-muertos.
