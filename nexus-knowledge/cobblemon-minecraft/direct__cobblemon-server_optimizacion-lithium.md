# Direct: cobblemon-server/optimizacion-lithium

Category: Cobblemon-minecraft
Tags: lithium, optimizacion, performance, fabric, 1.21.1, lithium.properties, mixin-config
Created: 2026-08-20T13:44:56.453591

---

Lithium (CaffeineMC) para optimizacion de server Fabric 1.21.1: archivo lithium-fabric-mc1.21.1-0.13.0.jar (tambien hay para NeoForge/Quilt). Optimiza logica del juego (colisiones, AI de mobs, block ticking, pathfinding, POI de aldeanos 16-22x, redstone, hoppers) SIN cambiar mecanicas vanilla. Instalar en server Y cliente (funciona sin que el cliente lo tenga instalado, pero beneficia ambos). NO requiere config: con un config vacio usa todas las optimizaciones estables por defecto. Config opcional en config/lithium.properties para desactivar mixins con problemas de compatibilidad, ej: mixin.entity.collisions.suffocation=false (compat Origins), mixin.minimal_nonvanilla=true (habilita opt de rana/ataque que se desvia levemente de vanilla). La lista completa de opciones esta en lithium-mixin-config.md del repo. Ejemplo real de uso: desactivar sufocation mixin para compat con mods de formas. Fuentes: CurseForge changelog 0.13.0, GitHub CaffeineMC/lithium README + issue #336, Modrinth.
