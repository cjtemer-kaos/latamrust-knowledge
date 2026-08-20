# supernexus-zoom-system

Zoom en SuperNEXUS: Usa IPC de Electron (nexusAPI.zoomIn/zoomOut/zoomGet/zoomReset) que llama a webContents.setZoomFactor(). NUNCA usar CSS zoom o transform scale — no mantienen centrado. El preload.js expone: zoomGet, zoomIn, zoomOut, zoomReset. El main.js tiene handlers: nexus:zoom:get, nexus:zoom:in, nexus:zoom:out, nexus:zoom:reset. Si zoom no funciona = preload no se cargó (path mal).
