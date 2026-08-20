# supernexus-preload-critical

CRÍTICO - Preload path en Electron: main.js usa `path.join(__dirname, "preload.js")` (no `"../preload/preload.js"`). El preload.js está en la raíz del proyecto (D:\ias\proyectos\supernexus-v2\preload.js). Si el path está mal, nexusAPI no se carga y los botones de zoom/voz no funcionan. Siempre verificar: ls preload.js && grep preload main.js
