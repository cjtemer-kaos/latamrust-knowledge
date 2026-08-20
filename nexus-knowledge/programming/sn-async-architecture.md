# sn-async-architecture

Async architecture for servers: 1) asyncio event loop. 2) aiohttp for HTTP. 3) async handlers for non-blocking. 4) Connection pools (aioredis, aiosqlite). 5) Task queues (asyncio.Queue). 6) Background tasks (asyncio.create_task). 7) Graceful shutdown (app.on_cleanup).
