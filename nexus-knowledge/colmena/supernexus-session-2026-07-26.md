# supernexus-session-2026-07-26

SuperNEXUS v2 - Arreglo del Director (sesión 2026-07-26/27):
- Director buscaba en web para "funcionas?" → fix: agregar keywords conversacionales
- Model selector: solo uno en input bar, dropdown hacia arriba (bottom-full mb-2), eliminado duplicado del header
- Slash commands: /api/slash POST con autocomplete dropdown, ↑↓ navigate, Tab complete, Enter execute
- Chat input: onKeyDown SOLO en textarea (no en div padre), onChange usa handleInputChange
- Font 18px base, sidebar 260px, right panel 280px para 1080p
- Preload path: path.join(__dirname, "preload.js") — si está mal, nexusAPI no carga
- Zoom: Electron IPC (webContents.setZoomFactor), NUNCA CSS zoom
- React testing pitfall: browser_press no dispara onKeyDown
