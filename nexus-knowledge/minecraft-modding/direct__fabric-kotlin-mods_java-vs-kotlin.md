# Direct: fabric-kotlin-mods/java-vs-kotlin

Category: Minecraft-modding
Tags: fabric, 1.21.1, kotlin, fabric-language-kotlin, java
Created: 2026-08-20T13:55:36.437939

---

FABRIC JAVA vs KOTLIN EN MODDING: fabric-language-kotlin es un mod language-adapter (independiente de la version de MC, solo requiere Fabric Loader; para 1.21.1 usar 1.13.x+kotlin.2.x, ej 1.13.4+kotlin.2.2.0). Ventajas Kotlin: null-safety (Int vs Int?), extension functions sobre clases vanilla (Block, ItemStack), coroutines para tareas async sin bloquear el game thread, data classes, menos boilerplate, type inference, string templates. LIMITACION CRITICA: los MIXINS NO se pueden escribir en Kotlin (deben ser .java); workaround: mixin Java que invoca un metodo @JvmStatic de un object/companion object Kotlin. En fabric.mod.json los entrypoints Kotlin se declaran con {adapter:kotlin, value:pkg.Class} o clase MainKt generada; required depends fabric-language-kotlin >= version. Gradle: subir jvmToolchain (Kotlin compila a bytecode Java 8 por defecto, incompatible con MC 1.21 que pide Java 21). 109M+ downloads en Modrinth.
