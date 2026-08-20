# gstack pattern implementado: DevLoop 7-fases + Conductor worktrees

Implementados 2 modulos nuevos basados en gstack (Garry Tan/YC, marzo 2026):

1. src/core/dev_loop.py — 7-Phase Development Loop:
   THINK→PLAN→BUILD→REVIEW→TEST→SHIP→REFLECT
   - Gates de entrada/salida por fase (auto_pass para BUILD, verdict check para REVIEW, ready check para SHIP)
   - Prompts LLM por fase, contexto acumulado entre fases
   - Resume de runs bloqueados
   - Endpoints: POST /api/devloop/run, GET /api/devloop/status

2. src/core/conductor.py — Parallel Worktree Coordinator:
   - spawn(name, goal) → crea git worktree + branch conductor/{name}
   - merge(name, squash=True) → squash merge a main
   - cleanup(name) → elimina worktree y branch
   - max_parallel=4 streams simultaneos
   - ConductorDevLoop: integra ambos (DevLoop por worktree en paralelo)
   - Endpoints: POST /api/conductor/spawn|merge|cleanup, GET /api/conductor/status

Ambos importan OK. 6 nuevos endpoints registrados en server.py.
