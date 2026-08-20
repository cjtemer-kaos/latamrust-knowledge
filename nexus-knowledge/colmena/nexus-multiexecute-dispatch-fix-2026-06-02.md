# nexus-multiexecute-dispatch-fix-2026-06-02

# Fix multi-agente execute flow NEXUS 2026-06-02: `nexus_execute` (en `src/core/director.py:2241`) lla

Fix multi-agente execute flow NEXUS 2026-06-02: `nexus_execute` (en `src/core/director.py:2241`) llamaba `decision_engine.decompose()` que producía Commands con `target="gema-X"`, pero `command_dispatcher` SOLO tenía handlers para `sub-director-X`/`hermes`/`openclaw`/`agent-zero`. Tres fixes aplicad

## Temas


## Codigo

