# sn-graceful-shutdown

Graceful shutdown: async def cleanup(app): await db.close(); await cache.disconnect(); await task_queue.join(). app.on_cleanup.append(cleanup). Signal handling: loop.add_signal_handler(signal.SIGTERM, lambda: asyncio.ensure_future(app.shutdown())). Resources: close DBs, cancel tasks, finish in-flight requests.
