# autopsia-opencode: 12. Manejo de errores

# 12. Manejo de errores

2. **Diagnóstico:** ¿es error de sintaxis? ¿de lógica? ¿de entorno? ¿de permisos?

## Temas
- Leo el mensaje de error** — contiene la causa raíz.
- Diagnóstico:** ¿es error de sintaxis? ¿de lógica? ¿de entorno? ¿de permisos?
- Corrijo:** cambio el enfoque, no repito lo mismo.
- Tool call malformado** → el harness lo rechaza, reintenta.
- Texto en vez de tool call** → el harness puede parsearlo por regex (si tiene esa
- Respuesta vacía** → no se trata como éxito. Se reintenta o se reporta.
- Alucinación** → el harness no puede detectarla directamente, pero la verificación
- Si algo no funciona, lo digo temprano.

## Codigo

