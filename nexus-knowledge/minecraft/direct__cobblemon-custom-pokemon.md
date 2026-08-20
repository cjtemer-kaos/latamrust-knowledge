# Direct: cobblemon-custom-pokemon

Category: Minecraft
Tags: cobblemon, datapack, custom-pokemon, species, spawn-pool, 1.21.1
Created: 2026-08-20T13:21:30.186057

---

Crear una especie Pokemon custom en Cobblemon es 100% data-driven (datapack, sin compilar codigo). Archivo de especie: data/cobblemon/species/custom/<pokemon>.json con campos: implemented (bool), name, labels (lista: 'custom', 'legendary', 'mythical', 'ultra_beast', 'pseudo_legendary', 'baby', 'mega', 'gmax', 'regional', 'gen1'...), pokedex (claves de lenguaje cobblemon.species.<pokemon>.desc1 / .desc2), height (decimetros), weight (hectogramos, /10 = kg), preEvolution (opcional) y features (aspectos custom asignados). Archivo de spawn: data/cobblemon/spawn_pool_world/<pokemon>.json con entries: presets ('underwater', 'underground'), type 'pokemon', context ('submerged'), bucket ('rare', 'common'...), level (rango '18-60'), weight y condition (canSeeSky bool + biomes usando tags de biome tipo ':is_lush', ':is_beach').
