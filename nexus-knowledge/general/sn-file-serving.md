# sn-file-serving

File serving in aiohttp: from aiohttp import web; app.router.add_static('/static', '/path/to/static'). For dynamic files: async def serve(request): return web.FileResponse('/path/to/file'). For JSON: web.json_response({'key': 'value'}). For HTML: web.Response(text='<html>', content_type='text/html').
