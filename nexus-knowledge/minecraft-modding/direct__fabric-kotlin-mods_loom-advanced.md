# Direct: fabric-kotlin-mods/loom-advanced

Category: Minecraft-modding
Tags: fabric, 1.21.1, gradle, loom, multiproject
Created: 2026-08-20T13:55:16.781240

---

FABRIC 1.21.1 LOOM ADVANCED SETUP: (1) Split client/common code: loom { splitEnvironmentSourceSets(); mods { modid { sourceSet sourceSets.main; sourceSet sourceSets.client } } } prevents accidental server crashes from client-only imports (compile-time). (2) Multi-project: depend with implementation project(path:':sub', configuration:'namedElements') (namedElements = unremapped outputs); for split source sets add clientImplementation project(':sub').sourceSets.client.output. (3) Dep configs: modImplementation/modApi/modCompileOnly/modRuntimeOnly/modLocalRuntime are remapped variants; include 'dep:ver' adds jar-in-jar (nested JAR, non-transitive, auto-generated fabric.mod.json for non-mods); fabricApi.module('fabric-api-base','ver') depends on a single Fabric API module avoiding the full API. (4) fabric.loom.multiProjectOptimisation=true in gradle.properties for many subprojects same MC version. (5) Cache fixes: ./gradlew build --refresh-dependencies. (6) Kotlin DSL: id('fabric-loom') + kotlin('jvm'). Option parchment(...) for Mojmap supplemental mappings.
