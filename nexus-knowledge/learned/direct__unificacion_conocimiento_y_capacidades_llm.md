# Direct: unificacion_conocimiento_y_capacidades_llm

Category: Learned
Tags: direct-learned
Created: 2026-08-16T18:03:46.241429

---

SUPERNEXUS v2 gran ronda (2026-08-16): (1) UI: revisados 24 endpoints clave -> 22 responden 200, memory/search POST 200, voice/speak 503 honesto, hive 200. (2) CONOCIMIENTO UNIFICADO latamrust<->supernexus: ambos usaban DBs de cerebro DISTINTAS (latamrust=<root>/brain, supernexus=~/.nexus/brain). Merge SQL por tema/label: latamrust->supernexus +41 conoc +78 nodos; ambos ahora 64 conocimientos + 114 nodos. (3) CAPACIDADES LLM opencode-go: 20 modelos (kimi-k3, glm-5.2, mimo-v2.5-pro, minimax-m3, deepseek-v4-flash/pro, qwen3.7-max...) inyectados al cerebro como conocimientos + nodos de grafo con sus capacidades (ambos proyectos: 84 conoc, 134 nodos). (4) CONSOLIDACION->GRAFO: cerebro.consolidar_memorias AHORA alimenta knowledge_graph (temas de interes -> nodos concept, conocimientos consolidados -> nodos knowledge) en knowledge_graph.db. (5) COMPRESION->CEREBRO: /api/token/compress ahora registra la compresion en cerebro (aprender_interaccion) en vez de descartar tokens. (6) APRENDIZAJE verificado: aprender_interaccion guarda conversaciones, add_node persiste, consolidar_memorias genera nodos de grafo. Política LLM: LOCAL PRIMERO (cuidar tokens cloud), cloud solo si la tarea lo requiere.
