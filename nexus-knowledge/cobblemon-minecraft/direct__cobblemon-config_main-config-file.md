# Direct: cobblemon-config/main-config-file

Category: Cobblemon-minecraft
Tags: cobblemon, config, toml, spawning, battles, storage, 1.21.1
Created: 2026-08-20T13:24:39.983174

---

OBTAINABLE|Cobblemon config principal (cobblemon-common.toml / Config wiki): Pokemon > maxPokemonLevel (default 100, hasta 1000), maxPokemonFriendship 255, shinyRate (default 8192 = chance 1/8192; 0 = sin shinies), teraTypeRate 20, experienceMultiplier 2, captureCalculator (id extensible por otro mod), maxDynamaxLevel 10, announceDropItems, defaultDropItemMethod (on-entity/on-player/to-inventory). Storage: storageFormat nbt/json/mongodb, defaultBoxCount 30, pokemonSaveIntervalSeconds 30, mongoDBConnectionString. Spawning: enableSpawning, minimumLevelRangeMax 10 (nivel=guia cuando party vacia), savePokemonToWorld, pokemonPerChunk 1, ticksBetweenSpawnAttempts 20, worldSliceDiameter 8 / worldSliceHeight 16 (segments de spawn), minimumSliceDistanceFromPlayer 16, maximumSliceDistanceFromPlayer 64, maxVerticalCorrectionBlocks 64, exportSpawnConfig (genera config detallado de spawn en disco al activarlo). Starter: exportStarterConfig para editar lista de starters. Battles: autoUpdateShowdown, defaultFleeDistance 32 (=-1 no se puede huir), allowExperienceFromPvP, experienceShareMultiplier 0.5, luckyEggMultiplier 1.5, allowSpectating, battleWildMaxDistance 12, battlePvPMaxDistance 32, walkingInBattleAnimations. Healing: infiniteHealerCharge, maxHealerCharge 6, chargeGainedPerTick, defaultFaintTimer 300 seg, faintAwakenHealthPercent 0.2. World: tradeMaxDistance 12, maxRootsInArea, pasture settings.
