# Direct: Fabric Loom y mappings

Category: Fabric-mod-dev
Tags: direct-learned
Created: 2026-08-20T16:40:24.277067

---

Fabric Loom (plugin Gradle): al configurar el workspace descarga y mergea los jars client+server de Minecraft, descarga y aplica mappings (intermediary + Yarn), opcionalmente descompila y añade dependencias. Mappings disponibles: yarn (net.fabricmc:yarn:<ver>), oficiales de Mojang (loom.officialMojangMappings()), y layered (loom.layered() combinando officialMojangMappings + Parchment para parámetros/javadocs). minecraft { splitEnvironment = true } separa source sets client/common (requiere MC 1.18+, Loader 0.14+, Loom 1.0+).
