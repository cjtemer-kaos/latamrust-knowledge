# Direct: Provider NEXUS memory creado y activado

Category: Hermes
Tags: provider, nexus, memoria, plugin
Created: 2026-08-20T13:12:00.885749

---

MEMORIA NEXUS COMO PROVIDER DE HERMES (2026-08-20): cree plugin de memoria NEXUS en hermes-agent/plugins/memory/nexus/ (plugin.yaml + __init__.py con NexusMemoryProvider: guardar via POST /api/learn/direct, recuperar via POST /api/memory/search). Se descubrio automaticamente por el scanner de providers de Hermes (available=True). Activado con 'hermes config set memory.provider nexus' (verificado). Config: NEXUS_URL env (default http://127.0.0.1:9001), nexus.json para topic_prefix/category. TAMBIEN se subio memory.memory_char_limit de 2200 a 10000 y user_char_limit de 1375 a 5000 (evita bloqueos). Ahora Hermes usa la memoria infinita de NEXUS como backend, mejorando el trabajo.
