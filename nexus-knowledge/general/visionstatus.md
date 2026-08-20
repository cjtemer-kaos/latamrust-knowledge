# vision/status

Para verificar estado del generador: GET /api/vision/status retorna {connected: bool, state: string, last_generation, total_generated}. Para info del modelo: GET /api/vision/model. Para liberar VRAM: POST /api/vision/unload. Si Vision no esta disponible (connected: false), informar al usuario que debe iniciar el servidor Vision con: python api/server.py
