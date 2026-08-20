# director-v3-training-status-2026-05-27

# Director v3 QLoRA SFT — Estado Final (2026-05-27 16:30)

2. Re-entrenar con: epochs=1, lora_r=8, lora_alpha=16 (menos agresivo)

## Temas
- QLoRA SFT: Qwen2.5-1.5B-Instruct, 192 train + 21 eval, 3 epochs, loss 3.28→1.14, 8.8 min RTX 3060
- Modelo merged: ~/.nexus/training_runs/director-v3-sft/merged_model/ (fp16, funciona con transformers)
- GGUF Q8_0: ~/.nexus/training_runs/director-v3-sft/gguf/nexus-director-v3-q8.gguf (1.64GB, llama.cpp convert)
- Ollama: nexus-director-v3:latest creado con Modelfile (temp=0.4, repeat_penalty=1.3, num_ctx=2048)
- llama.cpp clonado en D:\ias\tools\llama.cpp (para futuras conversiones)
- El modelo merged responde BIEN con transformers (fp16 directo en GPU)
- En Ollama (GGUF Q8_0) genera output degradado/incoherente — NO sirve como Director
- Causa: 192 ejemplos SFT = catastrophic forgetting. Modelo olvida habilidades base Qwen sin ganar suficiente NEXUS

## Codigo

