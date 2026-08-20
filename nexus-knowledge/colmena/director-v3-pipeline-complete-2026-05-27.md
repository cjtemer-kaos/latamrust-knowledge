# director-v3-pipeline-complete-2026-05-27

## Director v3 Pipeline — 7 Scripts Implemented (2026-05-27 19:00)

### New Scripts
- scripts/generate_synthetic_sft.py — genera 1000+ SFT con gemma4 teacher (10 categorías × 100)
- scripts/eval_director_v3.py — benchmark 25 tasks, LLM-as-Judge (relevance/conciseness/nexus 0-10)
- scripts/pipeline_director_v3.py — orquestador end-to-end (compile→train→merge→gguf→deploy→eval)

### Modified
- scripts/compile_training_data.py — source 5: synthetic_teacher
- scripts/deploy_director_v3.py — fp16 merge path, llama.cpp D:\ias\tools\llama.cpp, Q8_0, repeat_penalty 1.3
- scripts/train_director_qlora.py — hyperparams conservadores (r=8, alpha=16, epochs=1, lr=1e-4)
- src/core/director.py — Phase 0: _llm_classify() usa nexus-director-v3 (5s timeout) antes de keyword routing

### Ejecutar pipeline
```powershell
$env:PYTHONUTF8 = "1"
python scripts/generate_synthetic_sft.py --count 100  # ~1h
python scripts/compile_training_data.py
# Parar Ollama para liberar VRAM
python scripts/train_director_qlora.py  # ~10min
python scripts/deploy_director_v3.py
python scripts/eval_director_v3.py --tasks 10
```

### Fix crítico recordar
merge_and_unload() SIEMPRE sobre fp16 base, NUNCA sobre 4-bit. Ver brain_recall("director-v3-fix-merge-fp16")
