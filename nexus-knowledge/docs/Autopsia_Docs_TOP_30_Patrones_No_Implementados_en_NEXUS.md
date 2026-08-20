# Autopsia Docs: TOP 30 Patrones No Implementados en NEXUS

# Extraido de docs tecnicos de 67 repos en D:\ias\autopsia\ (2026-05-25). Patrones que NEXUS no tiene:

Extraido de docs tecnicos de 67 repos en D:\ias\autopsia\ (2026-05-25). Patrones que NEXUS no tiene:

## Temas
- Progressive Tool Disclosure (OpenAkita): 3 niveles — L1 nombre+desc en prompt, L2 schema completo on-demand via get_tool_info(), L3 ejecucion. Ahorra 
- LLMLingua-2 (Microsoft): Compresion de prompts 3-20x con BERT en CPU. Tags <llmlingua, rate=0.4> por seccion. CRITICO para inter-agent comms con Ollam
- Two-Layer Skill Loading (learn-claude-code s05): Nombres en system prompt (barato), body completo via tool_result on-demand.
- Triangulated Verification (aden-hive): Rules → LLM Judge → Human escalation
- Layer Prompt Onion (aden-hive): Identity (static) + Narrative (dynamic) + Focus (task)
- SafeSplitPoint (byo-coding-agent): Nunca orphan tool_use sin tool_result al compactar
- PREFLIGHT_PROTOCOL (nexus-ia): Backup + resource check + checkpoint antes de ops pesadas
- Skill Curator Auto-Archive (hermes): Track usage, archive stale skills automaticamente

## Codigo

