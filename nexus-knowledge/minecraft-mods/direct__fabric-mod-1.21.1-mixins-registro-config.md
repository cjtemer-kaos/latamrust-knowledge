# Direct: fabric-mod-1.21.1-mixins-registro-config

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:25:55.350370

---

Mixins en Fabric 1.21.1: se registran en fabric.mod.json con el array 'mixins': ["modid.mixins.json"] apuntando al archivo de config en resources. El mixins.json define: 'package' (paquete dedicado donde viven las clases @Mixin), arrays 'mixins' (ambos lados fisicos), 'client' (solo client fisico; un server dedicado nunca las carga), 'server', 'compatibilityLevel' (JAVA_21 para 1.21.x), 'minVersion' (0.8), 'required' (crash si falla), 'injectors.defaultRequire' (default 1: crash si un @Inject no encuentra su target). Toda clase con @Mixin debe estar registrada en su mixins.json.
