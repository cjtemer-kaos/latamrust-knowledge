# Direct: cobblemon-optimizacion

Category: Minecraft
Tags: cobblemon, optimizacion, tps, cobbleoptimizer, server, 1.21.1
Created: 2026-08-20T13:21:40.266621

---

Optimizacion de servidores Cobblemon 1.21.1: el mod CobbleOptimizer (server-side, Fabric y NeoForge para MC 1.21.1, MIT, comando /cobbleoptimizer con config TOML) reduce lag de entidades Pokemon basado en TPS con 4 mecanicas: (1) Tick Throttle - reduce el tick rate de Pokemon lejanos/no importantes cuando baja el TPS; (2) AI Freeze - congela el pathfinding/IA de Pokemon lejos de jugadores; (3) Adaptive Spawn - ajusta dinamico de tasas de spawn segun TPS; (4) Batch Despawn - elimina en lote Pokemon excedentes priorizando borrar los no importantes (protege shinies, legendarys, los de propiedad y los en batalla). Infraestructura compartida: TPS Monitor y Player Tracker con cache de distancias. Config nativa de Cobblemon: el cap de spawns por chunk se controla con la opcion 'pokemonPerChunk'; la chance de semilla de apricorn por defecto es 10%; los cambios de config exigen borrar/reinstalar ./config/cobblemon/main.json para regenerar valores nuevos.
