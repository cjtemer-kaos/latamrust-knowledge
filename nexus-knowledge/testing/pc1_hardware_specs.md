# pc1_hardware_specs

PC1 has an RTX 3060 12GB VRAM (not 6GB as previously assumed). This allows running gemma4:latest (9.6GB) fully in VRAM, plus another smaller model simultaneously (e.g., qwen2.5-coder:7b at 4.7GB = 14.3GB which would overflow, but nemotron-3-nano:4b at 2.8GB fits). Updated 2026-05-22.
