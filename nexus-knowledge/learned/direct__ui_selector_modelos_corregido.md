# Direct: ui_selector_modelos_corregido

Category: Learned
Tags: direct-learned
Created: 2026-08-16T15:31:19.356493

---

FIX UI SELECTOR MODELOS SuperNEXUS (2026-08-16): el selector mostraba deepseek-v4-flash-free (Zen fake). 3 fuentes corregidas: (1) config/nexus_models.yaml: opencode-zen enabled=false + models=[]; active=ollama-local::deepseek-r1:8b. (2) ui/dist/assets/providers-fix.js: ya NO inyecta modelos fake de Zen ni fuerza opencode-zen como default; default=Ollama local. (3) src/api/server.py handle_providers: ya NO lista modelos fake de Zen; online=False + models=[]. RESULTADO: selector muestra SOLO los 8 modelos reales de Ollama y el chat responde. ADEMAS: matados 3 backends zombie (5428, 7228, 24212) + portable embebido (18592) que ocupaban 9000 con codigo viejo.
