# Direct: cobblemon_fakemon_species_json

Category: Cobblemon_ecosistema
Tags: direct-learned
Created: 2026-08-20T16:05:25.052225

---

Cobblemon: crear un Pokemon custom (fakemon) = resource pack (assets/) + data pack (data/), ambos en un solo pack con pack.mcmeta. La definicion de la especie vive en /data/cobblemon/species/custom/<nombre>.json. Campos basicos: "implemented": true (aparece en /spawnallpokemon), "name", "labels" (custom, legendary, mythical, ultra_beast, pseudo_legendary, baby, mega, gmax, regional, gen1..gen9), "pokedex": [claves de idioma], "height"/"weight" (decimetros y hectogramos; dividir por 10 para metros/kg), "preEvolution": "<especie>" (opcional), "features": [aspectos custom]. Stats: "primaryType"/"secondaryType", "baseStats" {hp,attack,defence,special_attack,special_defence,speed}, "catchRate" (mas alto = mas facil), "maleRatio" (1=100% macho, 0=100% hembra, -1=sin genero), "baseExperienceYield", "experienceGroup" (erratic/fast/medium_fast/medium_slow/slow/fluctuating), "eggCycles", "eggGroups" (max 2: monster, bug, flying, field, fairy, grass, human_like, mineral, amorphous, water_1/2/3, ditto, dragon, undiscovered), "baseFriendship" (max 255), "evYield". Moves: "moves": ["egg:disable", "20:crushclaw", "tm:rest", "tutor:honeclaws"] con prefijos egg:/nivel:tm:/tutor:. Abilities: max 3 (2 normales + 1 hidden con prefijo "h:"). Evolucion: "evolutions": [] si no evoluciona.
