# supernexus-v2-model-registry

MODEL REGISTRY: src/core/model_registry.py (singleton YAML). ProviderConfig(name,provider_type,api_key,base_url,models[],enabled). Flujo: user selecciona modelo en UI → POST /api/models/active → se guarda en YAML → siguiente chat usa ese modelo. Cadena: request.selected_model > _user_selected_model > default_model. Auto-detect Ollama: GET /api/models/detect escanea localhost:11434. Providers soportados: ollama(local), openai, anthropic, opencode, custom.
