# Direct: fix_launcher_skins_updates

Category: Learned
Tags: direct-learned
Created: 2026-08-15T21:14:44.894961

---

Bug CRITICO launcher v5+SrJenko: doUpdate y syncSkins usaban TEMP_DIR (%TEMP%\CobbleVerse_Temp) sin crearlo cuando el pack ya estaba actualizado (TEMP_DIR solo se creaba dentro del bloque del pack en linea 565). Resultado: curl -o TEMP/skins.down fallaba silenciosamente, skinsUpdated=false, la UI decia "Ya tienes todo actualizado" y NUNCA instalaba skins ni mods nuevos. Fix: fs.mkdirSync(TEMP_DIR,{recursive:true}) al inicio de doUpdate y de syncSkins. Reconstruidos ambos exes (5.0.0) y verificado en asar. Tambien verificado: releases GitHub OK (skins-v1 con cobbleverse-skins.zip 180KB, mods-update-immersive-paintings), zip skins estructura skin/<mob>/*.png.
