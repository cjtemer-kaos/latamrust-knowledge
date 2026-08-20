# Direct: minecraft-server-1.21.1-world-structure

Category: Minecraft
Tags: minecraft, 1.21.1, server, world, level.dat, playerdata
Created: 2026-08-20T13:40:47.712428

---

Estructura de carpeta de un mundo (server vanilla Java 1.21.1): level.dat (NBT gzip con info global: seed, Time, DataVersion, GameRules, DataPacks[Enabled/Disabled], spawn, version, LastPlayed), level.dat_new y level.dat_old (backup automatico), session.lock (contiene el caracter unicode U+2603 snowman desde 1.16; antes era timestamp big-endian de 8 bytes). Carpeta raiz region/ = overworld; DIM-1/ = nether; DIM1/ = end; cada dimension tiene sus propias carpetas region/, entities/, poi/, data/ (raids.dat, etc). playerdata/<UUID>.dat = estado individual de cada jugador (inventario, salud, XP, posicion, abilidades); stats/<UUID>.json = estadisticas; advancements/<UUID>.json = logros. data/ a nivel raiz = datos compartidos entre dimensiones: scoreboard.dat, random_sequences.dat, map_<n>.dat, idcounts.dat, raids_end.dat, villages.dat. dimensions/ = solo dimensiones custom (datapack/mods). datapacks/ = datapacks del mundo. Fuente: minecraft.wiki/w/Java_Edition_level_format (verificado).
