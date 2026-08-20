# Direct: mods-fabric-testing-unit-gametest

Category: Mods-fabric
Tags: fabric, minecraft, testing, junit, gametest, ci
Created: 2026-08-20T13:50:32.631052

---

Minecraft Fabric 1.21.1: testing de mods (verificado docs.fabricmc.net/develop/automatic-testing + loom docs). Hay DOS metodos complementarios: (A) Unit tests con Fabric Loader JUnit: agregar testImplementation net.fabricmc:fabric-loader-junit:${loader_version} + test { useJUnitPlatform() } en build.gradle; necesario porque Mixin aplica bytecode en runtime y JUnit plano no funcionaria. Tests van en src/test/java y se corren con ./gradlew test. Si el test toca clases basadas en registries o quiere bootstrapear mundos headless: SharedConstants.tryDetectVersion(); Bootstrap.bootStrap(); HolderLookup.Provider registries = VanillaRegistries.createLookup(); (sin lanzar el juego). (B) Game Tests (framework de Minecraft) para testear features/gameplay: levantan servidor real. Con Loom: fabricApi { configureTests { createSourceSet = true; modId = ...; eula = true } } para crear source set gametest con su propio fabric.mod.json, definir entrypoint fabric-gametest (server) y fabric-client-gametest (cliente, lanza cliente real, requiere aceptar EULA); correr con task runGametest. Nota 1.21: las carpetas de estructuras gametest se renombraron a singular: gametest/structure (antes structures). CI: ./gradlew build ejecuta los tests; en caso de failure subir build/reports como artifact.
