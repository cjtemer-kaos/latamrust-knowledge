# vision/gallery-integration

Las imagenes generadas se guardan automaticamente en la galeria de SuperNEXUS. Para ver imagenes: GET /api/gallery/library. Para subir imagen manualmente: POST /api/gallery/upload. Para transformar: POST /api/gallery/transform con {img_id, operation}. Para mejorar rostro: POST /api/gallery/enhance-face. Para upscale: POST /api/gallery/upscale con {img_id, scale: 2|4}.
