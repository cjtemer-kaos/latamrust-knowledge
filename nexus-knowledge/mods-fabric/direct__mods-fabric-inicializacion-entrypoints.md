# Direct: mods-fabric-inicializacion-entrypoints

Category: Mods-fabric
Tags: f, a, b, r, i, c, ,, m, i, n, e, c, r, a, f, t, ,, e, n, t, r, y, p, o, i, n, t, s, ,, i, n, i, t, ,, j, a, v, a
Created: 2026-08-20T13:39:37.250999

---

Minecraft Fabric 1.21.1: patron de inicializacion/registro. Hay 4 prototypes de entrypoint en fabric.mod.json: main (ModInitializer.onInitialize, comun/cliente+servidor), client (ClientModInitializer.onInitializeClient), server (DedicatedServerModInitializer.onInitializeServer) y preLaunch (no recomendado, riesgo de interferir boot). REGLA CLAVE: usar clases SEPARADAS por entrypoint (main/client/server) para evitar problemas de carga de clases: una clase usada como main tambien carga codigo de cliente en un servidor dedicado aunque ese codigo nunca se ejecute. Entrypoints se cargan LAZY (bajo demanda) y sirven para integraciones opcionales entre mods via getEntrypoints. El orden de llamada entre mods NO esta definido y no se puede alterar; solo se respeta el orden declarado dentro del mismo fabric.mod.json. Verificado: docs.fabricmc.net/develop + wiki.fabricmc.net/documentation:entrypoint.
