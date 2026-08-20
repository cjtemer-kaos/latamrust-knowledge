# Direct: cobblemon-forms-evolutions/data-driven

Category: Cobblemon-minecraft
Tags: cobblemon, forms, evolutions, aspects, resolvers, datapack, evolution-requirements
Created: 2026-08-20T13:24:47.597750

---

OBTAINABLE|Cobblemon formas/evoluciones configurables via datapack: las especies se definen en data/cobblemon/species/custom/<pokemon>.json con campos primaryType/baseStats/drops/forms. La lista forms diferencia formas REALES (cada una con sus propios stats/moves/typechart) de variantes visuales: las visuales se manejan con resolvers en assets/cobblemon/bedrock/pokemon/resolvers/0_<pokemon>_base.json usando 'aspects' (array de traits, p.ej. shiny, o aspects custom tipo mischief) que apuntan a texture/model alternativos. Las evoluciones se declaran como 'evolutions' en el species json con array de requisitos por form (level, useItem, biome, estructura, holding item a cierta hora, daño recibido, pokemon derrotados, hits). Requisito nuevo 'structure' revisa si el pokemon esta dentro de una estructura. Los items de batalla consumibles se controlan con tags: cobblemon:held/consumed_in_npc_battle, cobblemon:held/consumed_in_pvp_battle, cobblemon:held/consumed_in_wild_battle (config consumeHeldItems fue removido). Ejemplos reales: Goomy->Sliggoo Hisui a lv40 en dripstone/lush caves; Rockruff->Lycanroc Midday/Midnight segun hora del dia; Gligar->Gliscor subiendo nivel con Razor Fang de noche; Exeggcute->Exeggutor Alola usando item de evolucion en bioma beach.
