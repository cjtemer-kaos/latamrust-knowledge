# Python Async Generators & Context Mgrs

Async generators: async def stream(): for i in range(10): await asyncio.sleep(0.1); yield i. Used with async for. Async context managers: class AsyncResource: async def __aenter__(self): self.conn = await connect(); return self.conn; async def __aexit__(self,*exc): await self.conn.close(). asyncio.TaskGroup (3.11+) handles cancellation better than gather(). List comp: [x async for x in gen()].
