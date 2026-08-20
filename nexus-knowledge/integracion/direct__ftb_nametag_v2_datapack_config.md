# Direct: FTB Nametag v2 datapack config

Category: Integracion
Tags: ftb-teams, nametag, datapack, config, reload
Created: 2026-08-19T22:17:39.679755

---

FTB Teams Nametag v2 (datapack config) — 2026-08-20 madrugada. MOD corregido (D:/ias/proyectos/ftb-teams-nametag, BUILD SUCCESSFUL): (1) CONFIG DESDE DATAPACK: lee data/ftb_nametag/config.json del server ResourceManager (cualquier datapack activo) con fallback a config/ftbteams_nametag.json; al hacer /reload recarga sin reiniciar. (2) FIX EN CALIENTE: re-aplica el prefix cada 2s (ServerTickEvents END_SERVER_TICK) para capturar creacion/cambio de equipos sin reconectar (antes no marcaba el team creado en caliente, ej. POKEGIRLS creado por las chicas). (3) config fields: format.prefixColor, prefixFormat[{team}], bold, italic; enabled.nametag/tablist/chat/showAlone(false=no mostrar team al solitario). DATAPACK: build/ftb-nametag-config-datapack.zip (pack.mcmeta + data/ftb_nametag/config.json). INSTALAR cuando el usuario de permiso: reemplazar jar en mods/ + copiar el zip a world/datapacks/ (o extraer data/ al datapack existente). Server LATAMRUST equipos FTB: admin, JNK, chaskini, POKEGIRLS. REGLA: SOLO usuario inicia/para el server.
