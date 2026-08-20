# vision/generar-imagen

SuperNEXUS Vision es un generador de imagenes basado en SDXL (Juggernaut XL). Endpoint: POST /api/vision/generate con body: {prompt: string (requerido), negative: string, width: int (default 1024), height: int (default 1024), steps: int (default 25), cfg: float (default 7.0), seed: int|null}. Retorna: {path: string, seed: int, time: float, gallery: {...}}. La imagen se auto-sube a la galeria. Servidor Vision: localhost:7866. Primera inferencia ~60s, siguientes ~18s. VRAM: ~8GB en RTX 3060.
