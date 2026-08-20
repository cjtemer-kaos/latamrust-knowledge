# Direct: minecraft-1.21.1-world-structure/anvil-region-format

Category: Minecraft
Tags: minecraft, 1.21.1, anvil, world-structure, mca, level.dat
Created: 2026-08-20T13:34:23.642742

---

LOGICA INTERNA Minecraft Server 1.21.1 - Estructura del mundo (formato Anvil): un mundo es una carpeta con level.dat (NBT gzip con metadata: seed, Time, SpawnX/Y/Z, gamerules, version=19133 para Anvil), region/r.x.z.mca (chunks del Overworld), DIM-1/region/r.x.z.mca (Nether) y DIM1/region/r.x.z.mca (End). playerdata/<UUID>.dat guarda el estado de cada jugador (inventario, posicion, XP); ademas data/ (scoreboards, command storage, raids, worldgen settings), advancements/, stats/, session.lock (detecta doble acceso) y datapacks/. Un archivo .mca cubre una region de 32x32 chunks: header de 8KB (1024 offsets de 4 bytes + 1024 timestamps), luego sectores de 4096 bytes; el offset usa 3 bytes + 1 byte de sectores; compression type (1=gzip, 2=zlib, 4=lz4). En Paper/Spigot cada dimension es carpeta separada en la raiz: world, world_nether, world_the_end. Coordenadas de region = chunk X/Z dividido por 32 (floor para negativos). Formato introducido en 1.2.1 (12w07a); data version 3955 y protocol 767 en 1.21.1.
