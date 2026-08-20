# electron-ipc

Electron IPC: main.js: ipcMain.on('channel', (event, data) => { event.reply('response', result) }). renderer.js: ipcRenderer.send('channel', data). ipcRenderer.on('response', (e, data) => { }). Context bridge: contextBridge.exposeInMainWorld('api', { send: ipcRenderer.send }).
