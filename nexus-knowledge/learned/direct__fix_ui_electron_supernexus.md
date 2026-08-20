# Direct: fix_ui_electron_supernexus

Category: Learned
Tags: direct-learned
Created: 2026-08-16T10:51:23.576300

---

Fix UI Electron SuperNEXUS (16-ago): desktop/main.js usaba D:/Miniconda3/python.exe (ENOENT) y .venv-py313 inexistente. Cambiado a path.join(__dirname,..,.venv,Scripts,python.exe). Rebuild: npm run build (portable) o build:dir (win-unpacked). Pitfall: app-builder.exe ERR_ELECTRON_BUILDER_CANNOT_EXECUTE si win-unpacked esta abierto (Acceso denegado d3dcompiler_47.dll) — matar procesos electron antes. UI apunta a localhost:9000.
