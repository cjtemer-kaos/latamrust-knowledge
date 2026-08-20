# Direct: Flujo launcher Electron v5 completado

Category: Launcher
Tags: launcher, electron, appdata, flujo, icono
Created: 2026-08-20T18:24:07.048913

---

FLUJO COMPLETO LAUNCHER LATAMRUST FUNCIONANDO (2026-08-20): Electron v5 canónico = D:/share/launcher-electron-v5 (UI 'ESTADO DEL JUEGO'). El launcher VA en %APPDATA%\LatamRust\launcher\ y desde ahí lanza el juego; los datos (mods, config, saves, portablemc) en %APPDATA%\LatamRust\. userData de Electron DEBE ser %APPDATA%\LatamRust\launcher y NUNCA la raíz GAME_DIR (causa crash 0x80000003 por colision con datos del juego). NUNCA usar execSync/PowerShell en main.js del Electron (provoca crash al arrancar) — para el acceso directo del escritorio usar shell.writeShortcutLink de Electron. El setup NSIS de electron-builder NO puede forzar installDir a %APPDATA% (falla con NSIS custom script) — solución: copiar el portable/win-unpacked compilado a la carpeta %APPDATA%\LatamRust\launcher. Update: TARGET_MAP (mods-*→mods, respack-*→resourcepacks, datapacks-*→datapacks, configs-*→config) + OBSOLETE borra datapacks/COBBLEVERSE - No Hunger.zip. Verificado: launcher instala todo, borra No Hunger, resource pack LATAMRUST_ES descargado. Backup pre-flujo en D:/autopsias/latamrust_backup_pre_flujo (3.3GB).
