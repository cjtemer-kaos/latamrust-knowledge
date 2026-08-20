# Direct: minecraft/fabric/1.21.1/claims-flan-cobblemon

Category: Config
Tags: cobblemon, fabric, 1.21.1, flan, claims, places, cobblemon-flan, proteccion
Created: 2026-08-20T13:36:59.475849

---

Claims/places para servers Cobblemon Fabric 1.21.1 = Flan + Cobblemon Flan Integration (repo Cobblemon-Eclipse/cobblemon-flan, verificado). Requisitos: Fabric Loader 0.16.5+, Fabric API, Cobblemon 1.7.3+, Flan 1.12.0+. Flan es el sistema de claims (pala dorada, /flan menu, /trust, subclaims via /flan switchmode). cobblemon-flan anade permisos de Cobblemon al claim: cobblemon-flan:pokemon_spawn (global, allowed por defecto), pokemon_catch (allowed), pokemon_battle (DENIED por defecto), pokemon_sendout (allowed), pokemon_ride (DENIED), display_case (DENIED). Config en config/cobblemon-flan/config.json con bloque protections { preventWildSpawns, preventCatching, preventBattles, preventSendOut, preventRiding, preventDisplayCaseInteraction, ownerBypass } y bloque messages personalizables (prefix y mensajes de bloqueo en formato MiniMessage <yellow>...</yellow>). Permisos editables por claim (GUI de Flan), por jugador/grupo o globalmente via config. Alternativa ligera: Secure Plots (1.21.1) con config secure_plots.json (enableProtection, maxPlotsPerPlayer, rankPerks).
