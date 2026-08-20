# Direct: Launcher update generico TARGET_MAP

Category: Launcher
Tags: launcher, update, respack, datapacks, obsoleto
Created: 2026-08-20T15:11:07.553504

---

LAUNCHER v5 SISTEMA DE UPDATE GENERICO (2026-08-20): main.js de D:/share/launcher-electron-v5 extendido para manejar CUALQUIER archivo hacia el cliente. TARGET_MAP: prefijo de tag GitHub->carpeta GAME_DIR (mods-*->mods, respack-*->resourcepacks, datapacks-*->datapacks, configs-*->config). Cada release con esos prefijos descarga sus assets (.jar/.zip) por nombre+tamano (patron downloadModAsset). OBSOLETE: lista de rutas relativas a BORRAR del GAME_DIR en cada update (ahora: datapacks/COBBLEVERSE - No Hunger.zip). El resource pack LATAMRUST_ES (traducciones+armas 3D) NO va por el launcher: el server lo entrega via server.properties require-resource-pack=true (ya actualizado SHA1 b414eba6). Para probar: subir release respack-* o datapacks-* a GitHub + recompilar exe. Los jugadores NO necesitan instalar resource pack manualmente (el server lo fuerza).
