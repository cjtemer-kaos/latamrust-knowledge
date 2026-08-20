# Direct: mods-fabric-fabric-api-modulos

Category: Mods-fabric
Tags: f, a, b, r, i, c, ,, m, i, n, e, c, r, a, f, t, ,, f, a, b, r, i, c, -, a, p, i, ,, a, p, i, ,, m, o, d, u, l, o, s, ,, e, v, e, n, t, o, s
Created: 2026-08-20T13:47:33.592885

---

Minecraft Fabric 1.21.1: Fabric API (verificado fabricmc.net + blog oficial 1.21). Fabric API es una libreria modular (multiples modulos, ej fabric-api-base, fabric-events-interaction, fabric-registry-sync) que provee hooks/callbacks donde el motor base no los da y convenciones de interoperabilidad entre mods (eventos, rendering, networking, conventional tags). NO es estrictamente necesaria para desarrollar mods, pero es MUY recomendada (docs oficiales). Se declara como modImplementation y se puede depender de modulos sueltos con fabricApi.module('fabric-api-base', version) para no arrastrar todo. En 1.21.1 la version estable es 0.116.x+1.21.1 (estable desde ago 2025). Cambios de 1.21 relevantes: Conventional Tags requieren traduccion recomendada bajo clave tag.item.<namespace>.<tag>; el mod id de Fabric API es fabric-api desde 1.19.2 (usar fabric solo al backportear pre-1.19.2). Convencion de codigo: registrar callbacks como XxxCallback.EVENT.register(...) dentro del entrypoint main. Eventos tipicos: ServerLifecycleEvents, AttackBlockCallback, CommandRegistrationCallback; usar Identifier.of(MOD_ID, nombre) para IDs.
