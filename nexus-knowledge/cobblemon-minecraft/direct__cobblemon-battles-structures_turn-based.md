# Direct: cobblemon-battles-structures/turn-based

Category: Cobblemon-minecraft
Tags: cobblemon, battles, showdown, structures, battleTheme, flee, spectate
Created: 2026-08-20T13:25:07.121978

---

OBTAINABLE|Cobblemon estructuras/estadios y batallas (sistema de combate): las batallas son por turnos estilo Showdown (autoUpdateShowdown=true descarga/usa la version incluida). Reglas de distancia: battleWildMaxDistance 12 (iniciar batalla con salvaje), battlePvPMaxDistance 32, defaultFleeDistance 32 bloques para huir de batalla no-PvP (=1 - huyen sin poder). Se puede espectar (allowSpectating). Themes de batalla: se puede asignar battle theme especifico por especie/form via campo 'battleTheme' en el species config (SoundEvent), y themes por jugador en PlayerData. Evento dock: BattleStartedPreEvent expone el PokemonBattle; HeldItemManager.shouldConsumeItem decide consumo de held items por tipo de batalla (tags consumed_in_npc_battle / consumed_in_pvp_battle / consumed_in_wild_battle). Estructuras con entrenadores: 'Trainer Structures' y datapacks anaden mapas; para localizar statios se recomienda Explorer's Compass. Generacion de estructuras custom por datapack usa el sistema vanilla (structure evolution condition puede revisar estructura actual).
