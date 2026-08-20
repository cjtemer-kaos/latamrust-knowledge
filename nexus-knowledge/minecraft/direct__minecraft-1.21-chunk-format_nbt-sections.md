# Direct: minecraft-1.21-chunk-format/nbt-sections

Category: Minecraft
Tags: minecraft, chunk-format, anvil, nbt, sections, 1.21
Created: 2026-08-20T13:34:56.540284

---

LOGICA INTERNA Minecraft 1.21 - Formato de chunk (Anvil): un chunk cubre 16x384x16 bloques en Overworld (16x256x16 en nether/end, desde 1.18), guardado como NBT dentro de r.x.z.mca. Desde 21w43a (1.18) ya NO hay clave Level: las entidades viven en entities (archivos de region separados desde 1.17), block_entities (tile entities), block_ticks, fluid_ticks, structures, heightmaps (37 longs de 9 bits, valores 0-384) y sections. Cada seccion cubre 16x16x16 y tiene byte Y (indice 0-15, secciones vacias NO se guardan), block_states.palette (lista de IDs de block state) y block_states.data (long array compactado donde cada entry empaqueta varios IDs en orden YZX para compresion); tambien biomes.palette/biomes.data. Chunks guardan lighting precomputado en secciones extra arriba/abajo del mundo. bits por entry = ceil(log2(tamano de palette)). Chunk format 1.21 con data version 3955, compatible con Amulet y NBTExplorer.
