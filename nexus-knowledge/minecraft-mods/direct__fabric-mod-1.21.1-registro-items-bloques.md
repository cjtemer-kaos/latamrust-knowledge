# Direct: fabric-mod-1.21.1-registro-items-bloques

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:26:03.373096

---

Registro de items/bloques en Fabric 1.21.1: Registry.register(BuiltInRegistries.ITEM, id, item) con id = ResourceLocation.fromNamespaceAndPath(MOD_ID, name), o Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, id), item). Bloques: Registry.register(BuiltInRegistries.BLOCK, id, block) y, si se quiere item, crear BlockItem y registrarlo en ITEM. CLave: Block e Item usan intrusive holders: instanciar new Item/Block sin registrarlo crashea con 'Some intrusive holders were not added to registry'; la instanciacion debe ser tan condicional como el registro. Grupos creativos: ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.XXX).register(g -> g.add(item)) (Fabric API), o grupo propio con FabricItemGroup.builder().displayName(Text.translatable(...)).icon(...).entries(...) registrado en Registries.ITEM_GROUP.
