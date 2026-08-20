# Direct: fabric-kotlin-mods/testing

Category: Minecraft-modding
Tags: fabric, 1.21.1, testing, junit, gametest
Created: 2026-08-20T13:56:42.579684

---

FABRIC 1.21.1 TESTING DE MODS (2 vias): (A) UNIT TESTS con Fabric Loader JUnit: build.gradle -> testImplementation net.fabricmc:fabric-loader-junit:{loader_version} + test { useJUnitPlatform() }. Tests en src/test/java con JUnit normal; en @BeforeAll llamar SharedConstants.createGameVersion(); Bootstrap.initialize(); para que registries (ItemStack) funcionen. (B) GAME TESTS (Gametest framework de Minecraft, E2E server-side): fabricApi { configureTests { createSourceSet=true; modId=''; enableGameTests=true; enableClientGameTests=true; eula=true } } crea source set gametest/ con su propio fabric.mod.json y entrypoint fabric-gametest (clases @GameTest + CustomTestMethodInvoker con GameTestHelper: assertBlockPresent, succeed) y fabric-client-gametest (FabricClientGameTest con ClientGameTestContext, worldBuilder().create(), takeScreenshot). Los server game tests corren automaticamente con la task build; los client game tests con runClientGameTest. CI: en GitHub Actions subir **/build/reports y **/build/test-results como artifact si failure(). El framework GameTest vive en net.minecraft.gametest.framework (Mojmap).
