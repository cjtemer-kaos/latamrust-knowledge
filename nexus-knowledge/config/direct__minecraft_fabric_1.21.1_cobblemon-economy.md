# Direct: minecraft/fabric/1.21.1/cobblemon-economy

Category: Config
Tags: cobblemon, fabric, 1.21.1, cobblemon-economy, shops, economia, server
Created: 2026-08-20T13:35:56.461569

---

CobblemonEconomyMod de Ryvexam (repo github.com/Ryvexam/CobblemonEconomyMod): economia y shops para servidores Cobblemon Fabric 1.21.1. Rutas de config (verificado, todo dentro del mundo para portabilidad del save): world/config/cobblemon-economy/config.json (global), shops.json, milestone.json, quests.json, quest_npcs.json; economia en economy.db y transacciones en transactions.log. Claves globales reales: main_currency (cobeco|cobbledollars|impactor), startingBalance, battleVictoryReward, battleVictoryPcoReward, capture_event_base_reward, capture_multi_reward, multiplicadores de captura especial (capture_shiny_multiplier, capture_radiant_multiplier, capture_legendary_multiplier, capture_paradox_multiplier), battleTowerCompletionPcoBonus, enableProfiling/profilingThresholdMs. Definicion de shops: title, currency (POKE|PCO), skin (PNG en world/config/cobblemon-economy/skins/), isSellShop, items con type "item" o "command" (comando con placeholder %player%), price, buyLimit/buyCooldownMinutes (0=lifetime, >0=reseteo cada N min), sellLimit/sellCooldownMinutes, nbt o components. NPCs: usar /eco shop get <shop_id> con el Shop Setter (Nether Star) para asignar vendedor.
