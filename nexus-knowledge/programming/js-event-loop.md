# js-event-loop

Event Loop en JS: 1) Call stack: ejecuta síncrono. 2) Web APIs: setTimeout, fetch. 3) Callback queue: callbacks de APIs. 4) Microtask queue: Promises, queueMicrotask (prioridad). 5) Rendering: requestAnimationFrame. Flujo: sync → microtasks → macrotasks → render. async/await = Promise + sugar syntax.
