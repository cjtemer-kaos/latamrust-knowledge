# JavaScript Closures & Event Loop

Closures: each function remembers its lexical scope. Event Loop: call stack -> microtasks (Promise.then, queueMicrotask) -> macrotasks (setTimeout, setInterval, I/O). async/await sugar over promises. Promise.all races, Promise.allSettled never rejects. Event loop phases: timers, pending callbacks, idle/prepare, poll, check (setImmediate), close callbacks. process.nextTick runs before next event loop iteration.
