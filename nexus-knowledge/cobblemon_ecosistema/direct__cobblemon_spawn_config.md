# Direct: cobblemon_spawn_config

Category: Cobblemon_ecosistema
Tags: direct-learned
Created: 2026-08-20T16:05:36.166237

---

Cobblemon: spawn data de un Pokemon vive en /data/cobblemon/spawn_pool_world/<nombre>.json. Campos: "enabled": true, "neededInstalledMods"/"neededUninstalledMods" (mods requeridos, ej. para biomes de otros mods), y "spawns": []. Cada spawn: "id" (convencion <pokemon>-<n>), "pokemon", "presets" (colecciones de bloques candidatos: natural, treetop, river, underwater, village, urban, mansion, pillager_outpost, underground), "type": "pokemon", "context": "grounded" (en superficie) o "submerged" (bajo agua), "bucket": common/uncommon/rare/ultra-rare (rareza), "level": "18-60" (rango de niveles), "weight" (probabilidad relativa; weight 1.0 es 10x menos comun que 10.0; convencion: evolucion ~1/10 del pre-evolucion). "condition": {"canSeeSky": bool (para spawns bajo techo/underground), "biomes": ["#cobblemon:is_lush", "#minecraft:is_beach"]} (tags de biome). Para spawnear manualmente: /pokespawn <nombre> o /pokespawnat <x> <y> <z> <especie>.
