# supernexus-electron-issues

SuperNEXUS UI vs Electron: El browser (localhost:9000/ui/) puede funcionar diferente a Electron porque Electron carga desde 127.0.0.1:9000/ui/. Si Electron muestra pantalla negra, puede haber múltiples instancias de Electron corriendo (una es Hermes Agent). Cerrar TODAS con taskkill //F //IM electron.exe y reabrir solo SuperNEXUS. Hard reload: Ctrl+Shift+R.
