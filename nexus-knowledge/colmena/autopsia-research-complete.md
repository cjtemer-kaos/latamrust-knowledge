# autopsia-research-complete

# INVESTIGACION COMPLETA DE 67 REPOS EN AUTOPSIA (corregido: 67, no 62). Priorizados por valor de inte

INVESTIGACION COMPLETA DE 67 REPOS EN AUTOPSIA (corregido: 67, no 62). Priorizados por valor de integracion:

## Temas
- open-multi-agent: Goal->DAG->Parallel execution. DirectorNexus necesita Coordinator.decomposeGoal() para descomponer metas en grafos de tareas y ejecu
- byo-coding-agent (~600 lines Go): Provider interface generico, PermissionPolicy (AlwaysAllow/AlwaysAsk/AllowList), compaction strategies pluggables. A
- awesome-harness-engineering (2.7K stars): Meta-guia de patrones harness. NEXUS necesita: eval framework, failure taxonomy, HARNESS.md, A2A protocol, M
- Crear HARNESS.md con inventario completo de componentes NEXUS
- Extraer Provider interface + PermissionPolicy (patron byo-coding-agent)
- Implementar DirectorNexus.planner con goal->DAG->parallel execution (patron open-multi-agent)

## Codigo

