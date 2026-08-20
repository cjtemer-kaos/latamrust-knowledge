# Direct: OpenCode free proxy colmena PC2

Category: Infra
Tags: opencode, free, proxy, colmena, latamrust-nexus, redis
Created: 2026-08-19T11:40:17.595039

---

Flujo opencode free en PC2 (latamrust-nexus): los modelos free de OpenCode (opencode/mimo-v2.5-free, opencode/deepseek-v4-flash-free) FUNCIONAN rapido (~7s) PERO su respuesta NO sale por el stdout de `opencode run` - se guarda en la DB de opencode (~/.local/share/opencode/opencode.db, tabla part, tipo text). El mecanismo correcto es `scripts/opencode_proxy.py` (puerto 8770): expone /v1/chat/completions OpenAI-compatible, ejecuta `opencode run --format json -m <modelo> <msg>` y extrae la respuesta leyendo la ultima part text de la DB. Verificado: MIMO_OK (mimo-v2.5-free) y EVIDENCIA_OK (deepseek-v4-flash-free) en 7s. Para usar opencode como ayudante free del director (Hermes): colmena+worker+proxy. El OpenCode Desktop usa DeepSeek V4 Flash Free + conocimiento de D:/share/latamrust-knowledge correctamente.
