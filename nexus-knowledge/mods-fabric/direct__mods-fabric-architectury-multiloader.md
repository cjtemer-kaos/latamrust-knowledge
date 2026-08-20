# Direct: mods-fabric-architectury-multiloader

Category: Mods-fabric
Tags: fabric, minecraft, architectury, multiloader, neoforge, platform
Created: 2026-08-20T13:48:59.222536

---

Minecraft Fabric 1.21.1: Architectury para multi-loader (verificado github architectury/architectury-api + docs.architectury.dev). Architectury API es una capa de abstraccion entre Fabric y NeoForge: permite escribir logica UNA vez en codebase common y publicar en ambos loaders, sin codigo loader-especifico. Contiene 90+ hooks de eventos (server/client/world), registro de items/blocks/entidades, networking y fluidos abstraction, y la anotacion @ExpectPlatform (SOLO en metodos static) para delegar implementacion a modulos por loader. Componentes: Architectury Plugin (plugin Gradle multiplatform), Architectury Loom (fork de Fabric Loom con capacidades multiplatform) y la API en si (API opcional; se puede usar solo el plugin). Estructura del proyecto tipica: modulos common + fabric + neoforge (con su fabric.mod.json / neoforge.mods.toml). Ecosistema recomienda generar template en generate.architectury.dev. Para 1.21.1 la version es v13.0.8 (fabric+neoforge, oct 2024). En loom layered se combina officialMojangMappings + parchment para nombre de parametros. Verificado tambien: architectury-loom soporta Quilt, y el plugin requiere Gradle 8.11+ para las versiones modernas (1.7-SNAPSHOT falla con Gradle <8.11 en 1.21.x).
