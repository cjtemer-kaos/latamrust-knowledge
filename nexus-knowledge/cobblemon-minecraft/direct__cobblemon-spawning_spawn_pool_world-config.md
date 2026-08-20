# Direct: cobblemon-spawning/spawn_pool_world-config

Category: Cobblemon-minecraft
Tags: cobblemon, spawns, config, datapack, 1.21.1, buckets, weight
Created: 2026-08-20T13:24:36.333510

---

OBTAINABLE|Cobblemon 1.21.1 spawn system (spawn_pool_world): cada Pokemon tiene archivos JSON en data/cobblemon/spawn_pool_world/ que controlan spawn natural. Campos clave: context (grounded=tierra, submerged=bajo agua, surface=superficie de agua/lava), bucket (common/uncommon/rare/ultra-rare = pool de rareza, primer rollo), weight (0.1-10, compite SOLO dentro del bucket ya elegido), level (min-max), presets (fragmentos reutilizables: natural, wild, water, urban, underground, structure... desde spawn_detail_presets), condition (OR: basta que UNA cumpla) vs anticondition (cualquiera que cumpla BLOQUEA), biomes (ids o biome tags), weightMultiplier/weightMultipliers (boost contextual, p.ej. Pikachu forest 0.712 x5 si hay tormenta). El pipeline (BestSpawner) es: 1) elige bucket, 2) filtra por spawnablePositionType y biome local, 3) evalua condiciones, 4) elige tipo (grounded/surface/submerged/seafloor/fishing segun peso config), 5) elige entrada por peso efectivo. El mod base tiene ~824 archivos / ~2900 entradas. Comando /checkspawn <bucket> diagnostica % actual en la zona local. /reload NO recarga addons de Cobblemon: hay que salir al menu y recargar mundo.
