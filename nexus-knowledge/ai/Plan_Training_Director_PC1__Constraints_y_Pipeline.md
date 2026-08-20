# Plan Training Director PC1 — Constraints y Pipeline

# PLAN: Training Director en PC1

2. Convertir learned_knowledge → SFT format (task=prompt, best_response=response)

## Temas
- RTX 3080 6GB VRAM
- GB RAM (max 8GB para training)
- OLLAMA_MAX_LOADED_MODELS=1
- PC2 (RX 570) = solo inference PeerChat, NO fine-tuning
- B params × 4bit = ~0.75GB base
- QLoRA adapters: ~100MB
- Optimizer states: ~500MB RAM
- Total estimado: ~2GB VRAM + ~3GB RAM = CABE

## Codigo

