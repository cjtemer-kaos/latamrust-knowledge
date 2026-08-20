# Direct: fabric-modding

Category: Programacion
Tags: minecraft, fabric, registro, registry, datagen, patterns, 1.21.1
Created: 2026-08-20T13:36:23.274470

---

PATRONES DE CODIGO Y REGISTRO con datos verificados para Fabric 1.21.1: (a) El registro de Items usa Registry.register(Registries.ITEM, Identifier.of("modid", "nombre"), new Item(new Item.Settings())); los bloques se registran antes que sus items y luego se crea BlockItem para relacionarlos (object-builder-api-v1 simplifica con FabricItemSettings/FabricBlockSettings). (b) Los callbacks deben registrarse en onInitialize (main) o onInitializeClient (client), NUNCA en constructores/statics del mod ya que Loader no garantiza momento de carga de clases. (c) Para que un bloque tenga item en el mundo: Registry.register(Registries.BLOCK,...) + Registry.register(Registries.ITEM, ...) con BlockItem; en 1.21.1 item requiere BlockItem de colocacion manual (ya no se genera automaticamente en NewBlockItem). (d) ServerLifecycleEvents.SERVER_STARTING/SERVER_STARTED para cargar config/data del lado servidor; ServerTickEvents para loops. (e) Datagen: en 1.21.1 se usa el entrypoint fabric-datagen con DataGeneratorEntrypoint que registra providers (ItemTagProvider, BlockLootTableGenerator, ModelProvider) para generar assets/recipes/loot automaticamente.
