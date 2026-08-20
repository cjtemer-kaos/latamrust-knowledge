# Direct: minecraft-server-1.21.1-dimensions-folders

Category: Minecraft
Tags: minecraft, 1.21.1, dimensions, overworld, nether, end, DIM-1, DIM1
Created: 2026-08-20T13:44:23.195044

---

Dimensiones del server vanilla Java en 1.21.1: Overworld = carpeta raiz del mundo (region/, entities/, poi/); Nether = carpeta DIM-1 (region/, entities/, poi/, data/raids_nether.dat); End = carpeta DIM1 (region/, entities/, poi/, data/raids_end.dat). Desde 1.16 el End guarda el estado de la pelea del dragon (ender_dragon_fight.dat / DragonKilled) en data/raids_end.dat de DIM1. Las dimensiones custom (definidas por datapack en dimension_type/dimension) se guardan en dimensions/<namespace>/<path>/ con sus propias region/entities/poi. Un mundo es una instancia de las 3 dimensiones vanilla. Nota: la reestructuracion a dimensions/minecraft/{overworld,the_nether,the_end} es FUTURA (26.1), NO aplica a 1.21.1. Fuente: minecraft.wiki + fandom World (verificado).
