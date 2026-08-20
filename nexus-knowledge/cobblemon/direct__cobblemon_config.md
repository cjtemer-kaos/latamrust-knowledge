# Direct: cobblemon_config

Category: Cobblemon
Tags: direct-learned
Created: 2026-08-20T13:59:15.405305

---

Config de Cobblemon (config/cobblemon/main.json): categoria Pokemon -> maxPokemonLevel (default 100), maxPokemonFriendship (255), experienceMultiplier (2), captureCalculator (cobblemon), shinyNoticeParticlesDistance (24, radio de aviso de shiny), playerDamagePokemon (true), maxDynamaxLevel (10). Categoria Storage -> defaultBoxCount (30 cajas de PC), pokemonSaveIntervalSeconds (30, guardado de party/PC), storageFormat (nbt|json|mongodb), mongoDBConnectionString + mongoDBDatabaseName para guardar datos de Pokemon en MongoDB. Categoria Spawning -> maxVerticalCorrectionBlocks (64, correccion vertical al elegir area de spawn). El destino de los drops al derrotar Pokemon lo controla defaultDropItemMethod (on-entity|on-player|to-inventory).
