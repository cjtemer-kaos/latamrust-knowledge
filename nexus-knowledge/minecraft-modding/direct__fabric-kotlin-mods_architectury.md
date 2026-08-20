# Direct: fabric-kotlin-mods/architectury

Category: Minecraft-modding
Tags: fabric, 1.21.1, architectury, multiloader, neoforge
Created: 2026-08-20T13:55:56.910368

---

ARCHITECTURY API (multi-loader): API multiplataforma que abstrae diferencias entre Fabric y NeoForge (antes Forge) para escribir la logica UNA vez en un modulo common/ y compilar a ambos loaders. Estructura: common + fabric/ + neoforge/ (platform-specific). Herramientas: Architectury Loom (fork de fabric-loom con soporte multiplataforma), Architectury Plugin (Gradle plugin), y Template Generator en generate.architectury.dev (recomendado para arrancar). Caracteristicas: 90+ event hooks (PlayerEvent.PLAYER_JOIN.register(...)), registries/creative tabs/networking/fluids cross-platform via una sola API, FluidStack abstraction, injected interfaces arch$ methods sobre clases vanilla. Licencia LGPL-3.0. Para multi-VERSION ademas de multi-loader se combina con Stonecutter (preprocesado //? if fabric). NOTA: solo aplica si el mod se publica en multiples loaders; para Fabric-only no hace falta.
