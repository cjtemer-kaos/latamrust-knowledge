# Direct: cobblemon-server/eco-shops-cobblemon-economy

Category: Cobblemon-minecraft
Tags: cobblemon-economy, economia, tiendas, shops, pokedollars, pokecoins, fabric, 1.21.1, json-config
Created: 2026-08-20T13:41:27.134584

---

Cobblemon Economy (CobblemonEconomyMod, Ryvexam, modrinth zfVCrbFk / curseforge cobblemoneconomy): mod de economia + tiendas + quests para servers Cobblemon en Fabric (version 0.0.17, MC 1.21.1). Requiere Cobblemon 1.7.1 y Fabric API. Config por mundo en world/config/cobblemon-economy/: config.json (comportamiento global, NO lleva shops), shops.json (definiciones de tiendas: title, currency, items, limites), quests.json, quest_npcs.json, milestone.json + SQLite economy.db y quests.db + skins/*.png. Doble moneda: PokeDollars (POKE) y PokeCoins (PCO); main_currency configurable por mundo (cobeco / cobbledollars / impactor) con bridge de compatibilidad para CobbleDollars e Impactor. Comandos jugador: /bal o /balance, /pco, /pay <jugador> <cantidad>. Admin: /eco reload (hot reload de config), /eco shop list|get <id>, /eco questnpc get <id>, /eco skin <name>, /eco item; balance con /balance <jug> add|remove|set <cant> y /pco igual. Crear tienda = editar shops.json + spamear NPC setter con /eco shop get. Fuentes: Modrinth, CurseForge y GitHub Ryvexam/CobblemonEconomyMod (guia admin detallada).
