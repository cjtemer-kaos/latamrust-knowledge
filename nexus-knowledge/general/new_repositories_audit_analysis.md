# new_repositories_audit_analysis

# INFORME DE AUTOPSIA Y VEREDICTO DE ADOPCIÓN DE NUEVOS REPOSITORIOS (AMPLIADO CON MEDUSA SECTOR) - AN

INFORME DE AUTOPSIA Y VEREDICTO DE ADOPCIÓN DE NUEVOS REPOSITORIOS (AMPLIADO CON MEDUSA SECTOR) - ANTIGRAVITY (2026-05-20)

## Temas
- learn-claude-code: Pipeline de Permisos de 3 Puertas y Motor de Hooks. Destino: src/core/hooks_engine.py.
- factor-agents: Control de Flujo Determinista y Reductor de Estado. Destino: src/core/agent_loop.py (controles de takeover y Ralph loop).
- LLMLingua: Compresión de Contexto por Perplejidad y Seguridad. Destino: src/core/context_compactor.py (compresión rápida por Ollama/qwen2.5:0.5b).
- mem0: Algoritmo Mem0 V3 (Abril 2026). Destino: src/core/memory_consolidator.py (ADD-only, enlazado de entidades, búsqueda híbrida SQLite FTS5 RRF).
- medusa: Escáner de Seguridad AI-First / DevSecOps. Destino: src/core/hooks_engine.py (Gate 1 y Gate 2) y gema security. 9,600+ patrones YAML regex de 
- Adversarial Variable Naming (Steering): Variables sospechosas insertadas para forzar al LLM a omitir sanitizaciones (ej. skip_auth = True, unsafe_inpu
- Double Backdoor Trigger Comments: Comentarios de código diseñados como disparadores durmientes de malware/reverse-shell.
- Universal Prompt Injections: Inyecciones de prompts ocultas en READMEs o comentarios para secuestrar el contexto de los agentes de codificación.

## Codigo

