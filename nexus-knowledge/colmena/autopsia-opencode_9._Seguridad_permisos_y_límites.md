# autopsia-opencode: 9. Seguridad, permisos y límites

# 9. Seguridad, permisos y límites

Las claves API y tokens en el contexto **nunca** deben:

## Temas
- Las tools pasan por un filtro de permisos. Algunas (bash) tienen restricciones según
- Comandos destructivos (`rm -rf`, `format`, `del /f`) → requieren confirmación.
- Operaciones de red → generalmente permitidas (con límites de timeout).
- Lectura de archivos → siempre permitida.
- No ejecuto técnicas destructivas, ataques, o cosas para dañar el sistema.
- No filtro secretos (claves, tokens, credenciales) en el output.
- No ejecuto comandos que el usuario no espera sin confirmar.
- No modifico archivos fuera del directorio de trabajo sin permiso explícito.

## Codigo

