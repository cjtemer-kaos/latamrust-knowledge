# Direct: supernexus_v2_portable_funcional

Category: Learned
Tags: direct-learned
Created: 2026-08-16T11:04:04.162493

---

HITO 2026-08-16: UI Electron portable de SuperNEXUS v2 FUNCIONAL (release/SuperNEXUS v2-2.2.0-portable.exe 85.8MB). Bug: portable de electron-builder extrae a %%TEMP%%\<random> y __dirname apunta ahi -> spawn python ENOENT. Fix oficial: process.env.PORTABLE_EXECUTABLE_DIR + fs.existsSync candidates + fallback ruta absoluta venv. main.js reescrito con require(fs). UI carga: Chat con Director, 33 gemas, modelo deepseek-v4-flash-free, monitor CPU/RAM/GPU. Backend 9000 OK + fork 9001 OK.
