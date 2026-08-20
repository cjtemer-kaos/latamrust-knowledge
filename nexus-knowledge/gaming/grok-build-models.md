# grok-build-models

GROK MODELS: Compile-time JSON embedding (include_str! default_models.json). LazyLock singleton. Priority cascade: CLI flag > ENV var > config.toml > remote settings > baked defaults. Specialized model slots: default, web_search, image_description, session_summary with fallback. Rich metadata: context window, API backend, reasoning effort, auto-compaction thresholds, fingerprint display. PATRONES PARA NEXUS: priority cascade de resolucion de modelos, slots especializados por tarea, metadata rica en YAML.
