# Direct: Loom namedElements y source sets cliente/servidor

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:37:45.249824

---

En builds multi-proyecto con Loom, al depender de otro proyecto Loom se debe usar la configuracion namedElements, que contiene los outputs del proyecto SIN remapear (por defecto los outputs se remapean a nombres intermediary). Si se usan source sets divididos (split client/common), tambien hay que anadir el source set client del otro proyecto, ej. clientImplementation project(':name').sourceSets.client.output. Fuente: docs.fabricmc.net/develop/loom.
