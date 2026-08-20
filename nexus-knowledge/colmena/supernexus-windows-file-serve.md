# supernexus-windows-file-serve

FIX CRÍTICO: aiohttp.web.FileResponse NO sirve archivos en Windows — devuelve 200 pero 0 bytes. Solución: leer archivo con Path.read_bytes() y retornar web.Response(body=content, content_type=ct). Aplica a server.py línea 5653 (handle_gallery_image). También aplica a cualquier otro endpoint que sirva archivos estáticos. La gallery funciona con GET /api/gallery/image/{filename} desde ~/.nexus/gallery/. Las imágenes de la UI deben usar ${API}/api/gallery/image/${encodeURIComponent(img.name)} NO rutas de Windows.
