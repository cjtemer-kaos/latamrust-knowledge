# Direct: politica_local_primero_latamrust

Category: Learned
Tags: latamrust-nexus, local-primero, politica-llm
Created: 2026-08-18T11:50:21.958090

---

Politica LOCAL PRIMERO portada a latamrust-nexus (agent_service.py). GEMA_MODEL_MAP (24 gemas->LLM ideal, orden [local_ideal,local_alt,cloud_ideal,cloud_alt]) + LOCAL_MODELS (11 locales) + _resolve_gema_model(gema,manifest,available): 1) manifest si existe, 2) mapa GEMA_MODEL_MAP, 3) cualquier local, 4) cualquiera. _detect_available_models ahora incluye modelos cloud de opencode-go desde ~/.nexus/cloud_providers.json (kimi, glm, mimo, minimax, deepseek-v4-flash/pro, qwen3.7-max). Regla: si la tarea se puede hacer con LLM local (Ollama gratis) se hace local; cloud de pago solo cuando requiere.
