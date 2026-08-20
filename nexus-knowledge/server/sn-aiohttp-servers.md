# sn-aiohttp-servers

aiohttp server patterns: app = web.Application(); app.router.add_get('/path', handler); app.router.add_post('/path', handler); web.run_app(app, port=8080). Middleware: @web.middleware async def middleware(request, handler): response = await handler(request); return response. CORS: aiohttp_cors setup.
