# Direct: fabric-mod-1.21.1-yarn-mappings-loom

Category: Minecraft-mods
Tags: direct-learned
Created: 2026-08-20T13:25:33.851693

---

Mappings en Fabric 1.21.1: Yarn es el conjunto de mappings abiertas (licencia CC0) de Minecraft usadas por el ecosistema Fabric (yarn-1.21.1+build.3). Fabric Loom (plugin Gradle) remapea el codigo ofuscado de Mojang a nombres legibles ('named' = yarn) durante el desarrollo, y produce jars con nombres 'intermediary' para produccion. Fabric Loader remapea el jar del juego a intermediario (caché en ${gameDir}/.fabric/remappedJars/${minecraftVersion}). Para reflection multi-entorno existe MappingResolver: FabricLoader.getInstance().getMappingResolver().mapClassName("intermediary", "net.minecraft.class_5421") resuelve a RecipeBookType en 1.21.x. Ejemplo: net.minecraft.network.packet.s2c.common.CustomPayloadS2CPacket (named) = intermediary class_2658 = oficial zn.
