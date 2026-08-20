# Direct: mods-fabric-loom-gradle-avanzado

Category: Mods-fabric
Tags: f, a, b, r, i, c, ,, m, i, n, e, c, r, a, f, t, ,, l, o, o, m, ,, g, r, a, d, l, e, ,, b, u, i, l, d, ,, j, a, v, a
Created: 2026-08-20T13:39:50.893904

---

Minecraft Fabric 1.21.1: Gradle Loom setup avanzado (verificado docs.fabricmc.net/develop/loom). 1) Configuraciones de dependencias: minecraft (version MC), mappings (yarn v2 o loom.officialMojangMappings() o loom.layered() para mojang+parchment), modImplementation/modApi/modRuntime (variantes remapeadas de implementation/api/runtime para dependencias mod, eliminan nested jars), include (jar-in-jar NO transitivo, se agrega a remapJar; para libs no-mod Loom genera fabric.mod.json dummy). 2) splitEnvironmentSourceSets() separa codigo cliente en su propio source set (src/client/java) para evitar crashes de servidor por codigo client-only, compilando en un solo jar final; requiere MC 1.18+/Loom 1.0+. 3) Multi-proyecto: usar implementation project(path: ':name', configuration: 'namedElements') y opt-in abric.loom.multiProjectOptimisation=true (Loom 1.1+). 4) Tasks utiles: remapJar (jar remapeado final), genSources (decompila MC con CFR), runClient/runServer, migrateMappings, downloadAssets, vscode/ideaSyncTask. 5) Caches: {GRADLE_HOME}/caches/fabric-loom (usuario) y .gradle/loom-cache (proyecto); si hay cache corrupta: ./gradlew build --refresh-dependencies o cleanloom. Para 1.21.1 usar JDK 21+, Loom 1.7+, Loader 0.16.x, Fabric API 0.116.x (ver fabricmc.net/develop).
