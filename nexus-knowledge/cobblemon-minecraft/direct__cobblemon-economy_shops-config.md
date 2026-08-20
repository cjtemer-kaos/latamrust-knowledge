# Direct: cobblemon-economy/shops-config

Category: Cobblemon-minecraft
Tags: fabric, cobblemon, economy, shops, config, 1.21.1
Created: 2026-08-20T13:54:56.558570

---

Cobblemon Economy (Ryvexam) mod Fabric 1.21.1 (cobblemon-economy-0.0.17.jar). Requiere Fabric API + Cobblemon 1.7.1. Config por mundo: world/config/cobblemon-economy/ (config.json, shops.json, quests.json, quest_npcs.json, milestone.json, economy.db). Clave principal: "main_currency": "cobeco" | "cobbledollars" | "impactor" (cobeco por defecto, con bridge de sync a CobbleDollars/Impactor). Keys de rewards: battleVictoryReward, raidDenVictoryReward, captureReward, newDiscoveryReward + multiplicadores shinyMultiplier/radiantMultiplier/legendaryMultiplier/paradoxMultiplier. Shop JSON: {"id":"cobblemon:poke_ball","name":"Poke Ball","price":200}, currency POKE|PCO, isSellShop true/false, type "item" o "command" (command solo admite placeholder %player%). Comandos: /bal, /pay, /eco reload, /eco shop get <id>. Hot reload JSON con /eco reload (restart tras cambios mayores). Fuentes: modrinth.com/mod/cobblemon-economy, github.com/Ryvexam/CobblemonEconomyMod.
