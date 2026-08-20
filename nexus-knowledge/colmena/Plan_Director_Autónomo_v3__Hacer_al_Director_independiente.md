# Plan: Director Autónomo v3 — Hacer al Director independiente

# PLAN: Director Autónomo v3

| **G1: Solo responde, no inicia** | El Director solo procesa tasks que le llegan. Nunca inicia trabajo por su cuenta. | No puede identificar problemas y resolverlos proactivamente |

## Temas
- gemas con routing semántico (keyword + self-model + O1 index)
- execute() pipeline completo: classify → route → execute → judge → learn
- Background workers (15 en total, training cada 15min, peer_learning cada 30min)
- PeerChat PC1↔PC2 con LLM-as-Judge multi-criterio
- AgentRunner con tool calling local
- Session management con auto-compact
- Token budget enforcement
- Graceful degradation con fallbacks

## Codigo
```
AGENDA = [
  (P0) Training cycle — cada 15min, nunca skip
  (P1) Tasks del hive — procesar inmediatamente
  (P2) Health checks — verificar componentes cada 5min
  (P3) Knowledge consolidation — cada 1h, consolidar learned_knowledge en brain
  (P4) Proactive analysis — cuando idle, analizar código, g
```
