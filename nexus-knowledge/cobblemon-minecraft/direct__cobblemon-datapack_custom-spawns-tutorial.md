# Direct: cobblemon-datapack/custom-spawns-tutorial

Category: Cobblemon-minecraft
Tags: cobblemon, custom-spawns, tutorial, datapack, pack.mcmeta, spawn_pool_world
Created: 2026-08-20T13:25:14.163442

---

OBTAINABLE|Cobblemon custom spawns paso a paso (wiki Tutorials/Creating Custom Spawns): 1) crea datapack con pack.mcmeta pack_format 15 (1.20.1+), 2) para REEMPLAZAR spawns base usa filter.block en pack.mcmeta con namespace cobblemon path spawn_pool_world (o coloca exacto mismo nombre de archivo para overrides), 3) archivos en data/<tu-namespace>/cobblemon/spawn_pool_world/<nombre>.json con estructura: enabled, neededInstalledMods/neededUninstalledMods (para biomes de otros mods), spawns[] donde cada entrada tiene id (convencion 'pokemon-1'), pokemon, presets (river/underwater/underground/natural/water/trees...), type 'pokemon', bucket, level min/max, weight, condition/anticondition con biomes y mas condiciones (org/time/moonphase/weather/sky/light/Y/structures/blocks/fluids/slimechunk/roddata/bait/lure). Regla clave de balance: una entrada sola en un bucket ultra-rare con la misma context saldra el 100% de las veces de ese pool (economia de spawns locales). Para verificacion en juego: /checkspawn <bucket> + /locate biome + teleport. /reload no aplica cambios de spawn de addons: reentrar al mundo. Highway de pesos (0.1-10) mantiene balance con otros archivos.
