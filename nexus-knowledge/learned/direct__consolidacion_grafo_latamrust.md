# Direct: consolidacion_grafo_latamrust

Category: Learned
Tags: latamrust-nexus, consolidacion, knowledge-graph
Created: 2026-08-18T11:50:46.613856

---

Cerebro.consolidar_memorias de latamrust-nexus ahora alimenta el knowledge graph (portado v6). El knowledge_graph.db se crea junto al cerebro (self.db_path.parent/knowledge_graph.db). Temas de interes frecuencia>=3 -> nodos concept; conocimientos consolidados (consolidado=1) -> nodos knowledge. OJO: la firma de KnowledgeGraph.add_node en latamrust es add_node(label,node_type,content,tags,source,metadata) — NO acepta node_id/epistemic_status ni description (difiere del maestro supernexus). Backups en backups/port-v6-20260818-1119. NEXUS relanzado en 9001 OK.
