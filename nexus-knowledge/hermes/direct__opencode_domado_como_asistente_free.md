# Direct: Opencode domado como asistente free

Category: Hermes
Tags: opencode, delegacion, free, asistente
Created: 2026-08-20T13:17:39.867558

---

OPENCODE DOMADO como asistente de Hermes (2026-08-20): el proxy opencode_proxy.py :8770 (endpoint OpenAI-compatible /v1/chat/completions + /v1/models) FUNCIONA: responde con modelos free (deepseek-v4-flash-free, mimo-v2.5-free, etc.). Verificado end-to-end (respuesta 'OK' y 'Listo para trabajar como asistente'). CONFIGURADO Hermes delegation para usar opencode free: delegation.base_url=http://127.0.0.1:8770/v1, model=opencode/deepseek-v4-flash-free, api_mode=chat_completions, provider=''. Ahora las subagentes delegate_task de Hermes usan opencode con sus LLM free (LOCAL FIRST, pago solo si requiere). Opencode ya tiene AGENTS.md de NEXUS, 6 MCPs (nexus-sovereign, chrome-devtools, playwright, context7, agent-browser, github) y mismo cerebro latamrust-nexus 9001. El 'hijo rebelde' ahora es asistente util.
