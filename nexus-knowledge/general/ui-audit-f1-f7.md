# ui-audit-f1-f7

# UI AUDIT: F1-F7 Endpoints vs Components

| /api/chat | ChatView, AvatarWindow, appStore |

## Temas
- BudgetView existe pero conecta a viejos /api/budget/*, no al nuevo TokenMonitor
- SkillsView existe pero solo muestra /api/ai/tools, no el marketplace
- No hay views nuevas para Memory Triage, Protocol Stack, Code Absorption, Health
- Todas las views necesitan: agregar llamadas a authFetch + pestañas o secciones nuevas

## Codigo

