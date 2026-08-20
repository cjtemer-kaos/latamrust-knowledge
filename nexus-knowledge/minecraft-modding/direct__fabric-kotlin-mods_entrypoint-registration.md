# Direct: fabric-kotlin-mods/entrypoint-registration

Category: Minecraft-modding
Tags: fabric, 1.21.1, modinitializer, entrypoints, registry
Created: 2026-08-20T13:53:19.785765

---

FABRIC 1.21.1 ENTRYPOINT/REGISTRATION PATTERN: Mods bootstrap via entrypoint system in fabric.mod.json. Prototypes main (ModInitializer.onInitialize), client (ClientModInitializer.onInitializeClient), server (DedicatedServerModInitializer), preLaunch (PreLaunchEntryPoint, not recommended). main entrypoints run before all client/server entrypoints on both sides; load order is otherwise undefined and cannot be influenced. Best practice: use SEPARATE classes for main/client/server entrypoints to avoid class-loading crashes on dedicated servers loading client classes. For content registration, Fabric API pattern is static Registry.register(Registries.ITEM, Identifier.of(MOD_ID, 'name'), item) called inside onInitialize; centralize registrations (items, blocks, entities) in one ModRegistries.register() entry. Cross-mod integration: FabricLoader.getInstance().getEntrypoints('name', Interface.class) loads other mods entrypoints lazily.
