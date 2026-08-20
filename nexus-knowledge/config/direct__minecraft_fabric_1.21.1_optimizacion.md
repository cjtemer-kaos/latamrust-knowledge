# Direct: minecraft/fabric/1.21.1/optimizacion

Category: Config
Tags: cobblemon, fabric, 1.21.1, lithium, ferritecore, optimizacion, starlight, c2me
Created: 2026-08-20T13:36:40.811374

---

Optimizacion de servidores Cobblemon Fabric 1.21.1 (verificado en CaffeineMC/lithium GitHub, Modrinth FerriteCore y guias reales): Lithium se instala solo en /mods, no requiere config minima (un archivo de properties vacio = usar todos los optimizations estables). Si hay incompatibilidad, se generan config/... .properties en formato Java properties con claves por mixin, ej. mixin.ai.pathing=false, mixin.gen.biome_noise_cache=false (listado completo en lithium-mixin-config.md del repo); los cambios requieren reinicio del server. FerriteCore reduce uso de RAM (hasta ~45% heap en benchmarks) y sirve tanto server como client; NO lleva archivo de config. Se recomienda combo Lithium + FerriteCore + Starlight (motor de luz) + opcionalmente C2ME (C2ME-no-fabric para 1.21.1) para mas TPS con muchos entitys de pokemon. Cobblemon requiere >=6GB RAM y Java 21 en 1.21.x. Otros tweaks de config de Cobblemon: pokemonPerChunk (default 6, bajar a 3 para menos lag) y maxNearbyBlocksHorizontalRange/maxNearbyBlocksVerticalRange.
