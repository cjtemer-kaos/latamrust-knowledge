# Direct: Fabric fabric.mod.json estructura

Category: Fabric-mod-dev
Tags: direct-learned
Created: 2026-08-20T16:40:13.219714

---

fabric.mod.json (mod Fabric): el objeto entrypoints define clases de carga — main para ModInitializer, client para ClientModInitializer (corre después de main en el cliente), server para DedicatedServerModInitializer (corre después de main en servidor dedicado). El campo mixins es una lista de archivos de configuración de mixin (ruta directa u objeto {config, environment}). Secciones depends (dependencias obligatorias con rangos de versión), breaks, suggests. Ej: depends fabricloader, fabric-api, minecraft.
