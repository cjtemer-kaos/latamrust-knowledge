# Direct: Fabric: componentes del toolchain (Loader, API, Loom)

Category: Fabric
Tags: direct-learned
Created: 2026-08-20T17:18:34.928244

---

Fabric se compone de 3 piezas: (1) Fabric Loader = loader flexible e independiente de plataforma que carga mods en Minecraft Java; (2) Fabric API = conjunto de APIs/hooks para mods; (3) Fabric Loom = plugin de Gradle para desarrollar y debugar mods (build con ./gradlew build; runClient/runServer para pruebas locales). fabric.mod.json es el descriptor del mod: id, version, entrypoints (main/client/server), mixins, depends. Mixins inyectan codigo en bytecode vanilla; Access Wideners (accessWidener) amplian acceso a campos/metodos privados; Interface Injection agrega interfaces a clases existentes. Docs: docs.fabricmc.net/develop (secciones 1.21.1 disponibles). Fuente: docs.fabricmc.net/develop
