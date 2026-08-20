# pipeline_aprendizaje_supernexus_portado

# PORT pipeline de aprendizaje a supernexus (2026-08-16): supernexus es la base y latamrust-nexus desc

PORT pipeline de aprendizaje a supernexus (2026-08-16): supernexus es la base y latamrust-nexus desciende de el (solo agrega servidores Rust/Minecraft). Se porto handle_learn_direct + ruta POST /api/learn/direct desde latamrust (src/api/server.py:2458) a supernexus, adaptando el step 4 a KnowledgeGr

## Temas


## Codigo


---

PORT pipeline de aprendizaje a supernexus (2026-08-16): supernexus es la base y latamrust-nexus desciende de el (solo agrega servidores Rust/Minecraft). Se porto handle_learn_direct + ruta POST /api/learn/direct desde latamrust (src/api/server.py:2458) a supernexus, adaptando el step 4 a KnowledgeGraph.add_node (supernexus no tiene add_knowledge). VERIFICADO: supernexus /api/learn/direct responde los 4 steps OK en 0.25s (sage_persist, biblioteca_organize, rag_index, knowledge_graph). AHORA AMBOS SISTEMAS APRENDEN POR IGUAL: cada conocimiento se persigue por sage -> biblioteca -> RAG -> grafo. Ambos comparten DB de cerebro por merge SQL por tema/label (latamrust usa /brain/cerebro.db, supernexus ~/.nexus/brain/cerebro.db).
