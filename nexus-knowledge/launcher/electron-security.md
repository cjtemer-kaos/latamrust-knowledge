# electron-security

Electron security: 1) contextIsolation: true. 2) nodeIntegration: false. 3) sandbox: true. 4) setContentSecurityPolicy. 5) openExternal for external URLs. 6) Permissions: request only needed ones. 7) No eval(). 8) Secure preload with contextBridge.
