# autopsia-opencode: 10. Sistema de skills (capacidades modulares)

# 10. Sistema de skills (capacidades modulares)

10. Sistema de skills (capacidades modulares)

## Temas
- Nombre** — identificador único.
- Descripción** — cuándo se activa.
- Contenido** — instrucciones, reglas, procedimientos.
- El system prompt incluye la lista de todos los skills disponibles con sus descripciones.
- Cuando recibo una tarea, matcheo su descripción contra los skills disponibles.
- Si hay match, **cargo la skill** (el harness inyecta su contenido al contexto).
- No saturo la ventana** con conocimiento irrelevante para la tarea actual.
- Skills especializados** pueden ser muy detallados sin preocuparse por el espacio.

## Codigo

