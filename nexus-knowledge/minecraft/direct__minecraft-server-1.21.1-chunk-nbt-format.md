# Direct: minecraft-server-1.21.1-chunk-nbt-format

Category: Minecraft
Tags: minecraft, 1.21.1, chunk, nbt, sections, heightmap
Created: 2026-08-20T13:41:14.116264

---

Chunk format (NBT dentro de .mca) en 1.21.1: un chunk cubre 16x384x16 en overworld (16x256 nether/end por defecto). Root NBT: DataVersion, xPos/zPos/yPos (posicion de chunk absoluta, yPos es la seccion Y mas baja, -4 en 1.18+), Status (estado de generacion: full, noise, features, etc), Sections[] (cada section es 16x16x16 con block_states = palette + data como long array bitpacked, y biomes), Heightmaps (MOTION_BLOCKING, OCEAN_FLOOR, WORLD_SURFACE), block_ticks y fluid_ticks (tile ticks con i/p/t/x/y/z), InhabitedTime (para dificultad regional), Entities, PostProcessing, blending_data. Desde 1.17 las entidades de chunks completos se guardan en carpetas entities/ como region files separados; desde 1.14 los POI (camas, estaciones, campanas) en poi/. Fuente: minecraft.wiki/w/Chunk_format (verificado).
