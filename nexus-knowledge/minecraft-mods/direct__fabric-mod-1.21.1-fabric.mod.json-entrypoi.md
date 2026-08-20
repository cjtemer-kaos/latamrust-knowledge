# Direct: fabric-mod-1.21.1-fabric.mod.json-entrypoints

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:25:39.043049

---

fabric.mod.json (metadata en src/main/resources del jar del mod) declara id, version, name, entrypoints y environment. Entrypoints en Fabric 1.21.1: 'main' (tipo net.fabricmc.api.ModInitializer, llama onInitialize) corre en ambos lados; 'client' (ClientModInitializer, onInitializeClient) solo en el lado fisico cliente; 'server' (DedicatedServerModInitializer, onInitializeServer) solo en server dedicado. Los valores son FQN de clases, cargadas por el language adapter 'default'. El campo 'environment' controla el lado de carga: '*' (todos, default), 'client' o 'server'. No existe anotacion @Mod en Fabric (eso es Forge/NeoForge); el punto de entrada se declara exclusivamente via entrypoints en el JSON. Se recomienda clases separadas para main/client/server para evitar problemas de class loading en server dedicado (aunque el entrypoint client no se corra, la clase puede cargarse).
