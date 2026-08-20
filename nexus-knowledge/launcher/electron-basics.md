# electron-basics

Electron architecture: 1) Main process: Node.js, manages windows. 2) Renderer process: Chromium, UI. 3) IPC: main ↔ renderer communication. 4) preload.js: secure bridge. 5) contextIsolation: true. 6) nodeIntegration: false. Security: never enable nodeIntegration in renderer.
