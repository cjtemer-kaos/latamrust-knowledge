# Informe sesión 27-May-2026 tarde — Estado completo

# INFORME SESIÓN 27-May-2026 14:00-14:20

2. **Fase 2 Training** — QLoRA SFT en PC1 (parar Ollama, entrenar, deploy)

## Temas
- bugs fixeados correctos (workers, process_scheduled, consolidate, import peer_chat)
- SFT datasets generados, training pipeline funcionando
- PERO: 0 commits hoy, todo uncommitted
- GPU training BLOQUEADO en PC2: RX 570 (GCN4) incompatible con ROCm+PEFT
- Training paró a las 13:42 — workers murieron silenciosamente
- Causa: timeout 240s insuficiente para model swapping con 6GB VRAM
- Causa: tasks hardcoded (4 repetidas 15-25 veces c/u)
- PC1 y PC2 ambos online, Ollama respondiendo

## Codigo

