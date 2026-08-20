# Direct: Launcher v5 recompilado update generico

Category: Launcher
Tags: launcher, recompilado, update, exe
Created: 2026-08-20T15:19:22.299171

---

LAUNCHER v5 RECOMPILADO con update generico (2026-08-20, 19:18): exe portable nuevo en Escritorio/LatamRust_Cobbleverso_V5_NUEVO.exe (74.5MB). Verificado en asar de win-unpacked: contiene TARGET_MAP, OBSOLETE, 'No Hunger', resourcepacks, datapacks. Arreglado electron-builder.yml artifactName '-.' -> '${productName}-${version}.${ext}' (causaba ENOENT dist\-.). El exe anterior del escritorio (LatamRust_Cobbleverso.exe, 24MB) NO se borro, queda intacto. El nuevo launcher: borra No Hunger en cada update + detecta releases respack-*/datapacks-*/configs-*/mods-* y las instala en GAME_DIR correcto.
