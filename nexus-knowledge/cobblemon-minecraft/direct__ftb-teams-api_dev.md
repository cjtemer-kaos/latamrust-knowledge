# Direct: ftb-teams-api/dev

Category: Cobblemon-minecraft
Tags: fabric, ftb-teams, api, dev, config
Created: 2026-08-20T13:54:16.522566

---

FTB Teams es principalmente una API/libreria para mods con progresion por equipo (FTB Chunks, FTB Quests). Version 1.21.1: rama 2101.1.x en Fabric, requiere Fabric API + Architectury API + FTB Library (FTB GUI). Se declara dependencia de ftbteams en fabric.mod.json. Para desarrolladores: TeamManager API para crear/obtener equipos; propiedades de equipo con defaults definibles via config (lazy init via supplier, ej. FTB Chunks team properties); override del comportamiento de creacion de equipos via API (ej. FTB Team Bases en Oceanblock 2 controla creacion de equipos y su base). CustomPartyCreationHandler esta deprecated. Fuentes: github.com/FTBTeam/FTB-Teams releases, docs.feed-the-beast.com/mod-docs/mods/suite/Teams.
