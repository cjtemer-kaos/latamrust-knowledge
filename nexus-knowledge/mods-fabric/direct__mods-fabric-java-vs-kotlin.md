# Direct: mods-fabric-java-vs-kotlin

Category: Mods-fabric
Tags: f, a, b, r, i, c, ,, m, i, n, e, c, r, a, f, t, ,, k, o, t, l, i, n, ,, j, a, v, a, ,, f, l, a, n, ,, l, a, n, g, u, a, g, e, -, a, d, a, p, t, e, r
Created: 2026-08-20T13:45:38.837315

---

Minecraft Fabric mods: Java vs Kotlin (verificado fabric-language-kotlin README + wiki.fabricmc.net/tutorial:kotlin). Para programar mods en Kotlin se usa fabric-language-kotlin (proyecto oficial FabricMC): dependencia modImplementation net.fabricmc:fabric-language-kotlin (asi gradle, ej 1.13.x+kotlin.2.x) y en fabric.mod.json declarar entrypoint con adapter: {adapter: kotlin, value: paquete.Clase} y dependencia fabric-language-kotlin. El language adapter de Kotlin soporta tambien top-level functions, reference a campo o metodo como entrada. Ventaja: bundlea kotlin-stdlib+reflect y librerias kotlinx (coroutines, serialization json/cbor, datetime, io) listas para usar sin shadow. Pitfall: Kotlin compila a bytecode Java 8 por defecto -> subir jvmToolchain (21 para 1.21.x) para evitar errores de compilacion. Java sigue siendo el estandar (no requiere adapter extra), Kotlin reduce boilerplate y da null-safety/coroutines, totalmente interop en un mismo proyecto (pueden mezclarse en la misma codebase).
