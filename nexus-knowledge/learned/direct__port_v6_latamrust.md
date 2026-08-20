# Direct: port_v6_latamrust

Category: Learned
Tags: latamrust-nexus, v6, port, llm-flow
Created: 2026-08-18T11:31:16.648641

---

2026-08-18: se portaron los 4 fixes del flujo LLM v6 de supernexus-v2 (maestro) a latamrust-nexus. Fix1: restore de default model persistido en ai_tools.py __init__ (helpers _load/_save_persisted_default_model en provider_service.py, default_model.json en ~/.nexus). Fix2: quick_response acepta model_override. Fix3: execute() seleccion dinamica local/cloud (model_to_use y ollama.list_models, prefijos locales deepseek-r1/qwen2.5-coder/qwen3.5/gemma3/nexus-director/nomic; NO incluir 'nemotron' porque nemotron-3-ultra-free es cloud). Fix4: perfil gema-con-fallback INVERTIDO a local-primero (model=deepseek-r1:8b, provider_type=ollama, fallbacks local->cloud); ollama-gema corregido de nexus-coder (no existe) a qwen2.5-coder:7b. Ademas se porto el parser XML Formato 5 en agent_runner.py (_detect_text_tool_call con 5 formatos). Modelos reales de Ollama: nexus-director-v5, qwen3.5:2b, nemotron-mini, gemma3:4b, deepseek-r1:8b, qwen2.5-coder:7b, nemotron-3-nano:4b, nomic-embed. Backup en backups/port-v6-20260818-1119. Verificado: AIToolsRegistry instancia con default_model=deepseek-r1:8b (restaurado), parser XML OK, backend relanzado en 9001.
