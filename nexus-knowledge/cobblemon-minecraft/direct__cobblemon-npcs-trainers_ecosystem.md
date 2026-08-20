# Direct: cobblemon-npcs-trainers/ecosystem

Category: Cobblemon-minecraft
Tags: cobblemon, trainers, npc, structures, datapack, yaml, battle-rewards
Created: 2026-08-20T13:24:55.198392

---

OBTAINABLE|Cobblemon NPCs/trainers (ecosistema 1.21.1): el mod base Cobblemon tiene sistema de NPC + batallas interno (entityType cobblemon:npc) usado por addons tipo 'Cobblemon Trainer Structures'. CobblemonOps/Trainer Structures (Fabric/NeoForge, MC 1.21.1, Cobblemon 1.7.0+): anade estructuras con trainers y premios (Pokemon Stadiums con trainers EV-trained, Sun Temple, Storm Temple); es esencialmente un datapack, añade trofeos y battle music; requiere Explorer's Compass para encontrar los estadios. Mod CobblemonNPCs (Fabric 1.21.1, Cobblemon 1.7.0+): sistema de NPCs configurable por YAML en config/cobblemonnpcs/trainers.yml - definen trainer_id, nombre, dialogo, equipo (species + level + nature/moves/EVs/IVs/shiny/form), rewards (items + comandos con placeholders {player} {trainer}) y cooldowns por trainer/player. Comandos: /spawntrainer <id>, /trainerskin <id> <skin>, /trainerconfig reload (recarga YAML sin reiniciar). Formato datapack de trainers tipo Radical Cobblemon Trainers (mod rct 1.21.1): trainer_definitions en trainers/<trainer_id>.json con campos name, identity (persona), ai config, gimmicks, bag items, battle rules y equipos referenceados en trainer_team/. Los premios por derrota de NPC se configuran en data/cobblemon/behaviours (battle_reward_pokedollars.json con add_variables toggle + amount min/max) y el flujo data/cobblemon/flows/battle_victory/npc_battle_end.json (entrega moneda, p.ej. impactor:pokedollars). El datapack '201 Trainers' usa parties dinamicas que escalan con el nivel del jugador.
