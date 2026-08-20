# Direct: minecraft-server-1.21.1-tick-load-system

Category: Minecraft
Tags: minecraft, 1.21.1, tick, simulation-distance, ticket, forceload, spawn chunks
Created: 2026-08-20T13:45:28.081968

---

Sistema de ticks y carga de chunks en server vanilla Java 1.21.1: simulation-distance en server.properties define el cuadrado de chunks alrededor del jugador donde se tickean entidades; una franja extra (1 chunk de grosor) hace correr redstone/fluidos/cultivos; mas alla los chunks estan cargados pero congelados (solo visibles segun view-distance). Load levels/tickets: un jugador genera ticket de nivel 31; /forceload add crea tickets de nivel 31 persistentes (max 256 chunks por dimension, se guardan en data/chunks.dat - chunk_tickets); spawn chunks estan siempre cargados. Mobs hostiles solo spawnean a ~8 chunks del jugador. Random ticks de bloques en vanilla 1.21.1 solo ocurren en los ~8 chunks alrededor de jugadores (se amplio a todo chunk cargado recien en 1.21.5/25w06a). Fuente: minecraft.wiki/w/Simulation_distance + Commands/forceload (verificado).
