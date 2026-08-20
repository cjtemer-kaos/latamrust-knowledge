# Direct: Regla memoria infinita NEXUS

Category: Sistema
Tags: memoria, nexus, regla, grafo, infinito
Created: 2026-08-19T11:44:21.968748

---

REGLA DE MEMORIA (directiva del usuario): la memoria de Hermes (~/memories) tiene limite fijo de chars; pero la memoria/grafo de NEXUS es INFINITA (SQLite + grafo, no un archivo con tope). Cuando la memoria de Hermes llegue al limite, NO borrar conocimiento: migrar/encadenar el excedente a NEXUS via /api/learn/direct (fact nuevo o nodo del grafo). Si un archivo llega al limite, se crea OTRO encadenado a ese para seguir guardando. El grafo de NEXUS 2026-08-19 tenia 158 nodos (136 knowledge, 20 concept) + 180 conocimientos en brain, expandibles sin tope.
