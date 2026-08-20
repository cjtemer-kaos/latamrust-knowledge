# distro_update_rules

REGLA ACTUALIZACIÓN DISTRO: NO solo copiar archivos nuevos. La distro debe ser un snapshot FUNCIONAL completo de la versión maestra. Pasos obligatorios:
1. Comparar estructura completa master vs distro
2. Identificar archivos faltantes, desactualizados o huérfanos
3. Verificar imports y referencias cruzadas entre archivos
4. Probar que el código arranca sin errores de importación
5. Actualizar documentación (DISTRO_DIRECTIVES.md, AVAILABLE_TOOLS.md)
6. Verificar que .env.example esté actualizado con todas las variables necesarias
7. Asegurar que start_server.py y scripts de inicio funcionen
La distro debe ser INSTALABLE y FUNCIONAL desde cero sin depender de archivos externos.
