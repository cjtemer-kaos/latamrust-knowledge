# sn-websockets

aiohttp WebSocket: async def websocket_handler(request): ws = web.WebSocketResponse(); await ws.prepare(request); async for msg in ws: if msg.type == WSMsgType.TEXT: await ws.send_str(f'echo: {msg.data}'). Real-time chat, notifications.
