# py-async-generators

Async generators en Python: async def + yield permite generar valores de forma asíncrona. Útil para: 1) Streaming de datos desde APIs. 2) Procesamiento de archivos grandes. 3) Chat en tiempo real. Ejemplo: async def fetch_pages(url): async with aiohttp.ClientSession() as s: for page in range(10): yield await s.get(f'{url}?page={page}')
