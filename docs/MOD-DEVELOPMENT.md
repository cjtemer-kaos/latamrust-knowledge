# Fabric Mod Development — Guía Completa (Minecraft 1.21.1)

> Guía para crear mods Fabric funcionales en el server LATAMRUST COBBLEMON.
> Versión: Minecraft 1.21.1 · Fabric Loader 0.19.3 · Fabric API 0.116.15+1.21.1 · Java 21
> Ejemplo real funcional: `mod-examples/latamrust-core/` (anticheat con networking + mixins + config)

---

## 1. Setup del proyecto

### gradle.properties
```properties
org.gradle.jvmargs=-Xmx1G
org.gradle.parallel=true

minecraft_version=1.21.1
yarn_mappings=1.21.1+build.3
loader_version=0.19.3

mod_version=1.0.0
maven_group=com.yourgroup
archives_base_name=your-mod-id

fabric_version=0.105.0+1.21.1
```

### build.gradle
```groovy
plugins {
    id 'fabric-loom' version '1.7-SNAPSHOT'
    id 'maven-publish'
}

version = project.mod_version
group = project.maven_group

base { archivesName = project.archives_base_name }

repositories {
    maven { name = 'luckperms'; url = 'https://repo.lucko.me/' }
}

loom {
    splitEnvironmentSourceSets()
    mods {
        "your-mod-id" {
            sourceSet sourceSets.main
            sourceSet sourceSets.client
        }
    }
}

dependencies {
    minecraft "com.mojang:minecraft:${project.minecraft_version}"
    mappings "net.fabricmc:yarn:${project.yarn_mappings}:v2"
    modImplementation "net.fabricmc:fabric-loader:${project.loader_version}"
    modImplementation "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"
    // APIs opcionales — compileOnly (se proveen en runtime)
    compileOnly 'net.luckperms:api:5.5'
}

processResources {
    inputs.property "version", project.version
    filesMatching("fabric.mod.json") { expand "version": project.version }
}

tasks.withType(JavaCompile).configureEach { it.options.release = 21 }

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
```

### ⚠️ PITFALLS del setup
- **Gradle 8.10** obligatorio — Fabric Loom 1.7 NO funciona con Gradle 9.x. El template de FabricMC trae 9.x; cambiá `gradle/wrapper/gradle-wrapper.properties` a `gradle-8.10-bin.zip`.
- El plugin es `fabric-loom`, NO `net.fabricmc.fabric-loom-remap`.
- Fabric API correcto para 1.21.1: `0.116.15+1.21.1` (no 0.100.8).

---

## 2. fabric.mod.json

```json
{
    "schemaVersion": 1,
    "id": "your-mod-id",
    "version": "${version}",
    "name": "Your Mod Name",
    "description": "Descripción",
    "authors": ["You"],
    "license": "MIT",
    "environment": "*",
    "entrypoints": {
        "main": ["com.yourgroup.YourMod"],
        "server": ["com.yourgroup.YourModServer"],
        "client": ["com.yourgroup.YourModClient"]
    },
    "mixins": [
        "your-mod-id.mixins.json",
        { "config": "your-mod-id.client.mixins.json", "environment": "client" }
    ],
    "depends": {
        "fabricloader": ">=0.19.3",
        "fabric-api": "*",
        "minecraft": "~1.21.1",
        "java": ">=21"
    },
    "suggests": { "luckperms": "*" }
}
```

### ⚠️ Entrypoints CRÍTICOS
- `"main"` → clase debe implementar `ModInitializer` con `onInitialize()`
- `"server"` → clase debe implementar `DedicatedServerModInitializer` con `onInitializeServer()`
- `"client"` → clase debe implementar `ClientModInitializer` con `onInitializeClient()`
- Error típico: declarar `"server"` pero implementar `ModInitializer` → crash al boot con `LanguageAdapterException: cannot be cast to DedicatedServerModInitializer`.

### Orden de carga de mods (¡TRUCO CLAVE!)
Fabric hace **topological sort** por las dependencias declaradas. Si el mod A declara `"depends": {"mod-b": "*"}`, entonces **mod-b carga ANTES que A**.

Esto resolvió el deadlock Paradigm↔LuckPerms (ver `LP-LOADER.md`):
```
luckperms → latamrust-core → paradigm
```

---

## 3. Estructura de carpetas (split source sets)

```
src/
  main/java/com/yourgroup/
    YourMod.java                    # Initializer común/server
    packets/                        # CustomPacketPayload records
    commands/                       # Comandos Brigadier
  client/java/com/yourgroup/
    YourModClient.java              # Initializer client (screens, keybinds)
    screens/                        # Screens solo client
  main/resources/
    fabric.mod.json
    your-mod-id.mixins.json
  client/resources/
    your-mod-id.client.mixins.json
```

**CRÍTICO**: con `splitEnvironmentSourceSets()`, `src/main/` NO puede importar clases de `src/client/`.

---

## 4. Networking (1.20.5+ / 1.21.1)

### CRÍTICO: usar `CustomPacketPayload` records, NO el viejo `FabricPacket`/`PacketType` (removidos en 1.21.1).

```java
// Server → Client payload
public record StaffPanelPayload(String panelType) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.of("your-mod", "staff_panel");
    public static final CustomPacketPayload.Type<StaffPanelPayload> TYPE =
        new CustomPacketPayload.Type<>(ID);

    // Usar anonymous class para codec (más confiable en 1.21.1)
    public static final StreamCodec<RegistryFriendlyByteBuf, StaffPanelPayload> CODEC =
        new StreamCodec<>() {
            @Override public void encode(RegistryFriendlyByteBuf buf, StaffPanelPayload p) {
                buf.writeString(p.panelType);
            }
            @Override public StaffPanelPayload decode(RegistryFriendlyByteBuf buf) {
                return new StaffPanelPayload(buf.readString());
            }
        };

    @Override public Type<? extends CustomPacketPayload> type() { return TYPE; }
}
```

### Registro (en common initializer)
```java
PayloadTypeRegistry.clientboundPlay().register(StaffPanelPayload.TYPE, StaffPanelPayload.CODEC);
PayloadTypeRegistry.serverboundPlay().register(StaffActionPayload.TYPE, StaffActionPayload.CODEC);
```

### Enviar / Recibir
```java
// Server → Client
ServerPlayNetworking.send(player, new StaffPanelPayload("main"));
// Client → Server
ClientPlayNetworking.send(new StaffActionPayload("ban", "TargetPlayer"));

// Server-side receiver (corre en server thread)
ServerPlayNetworking.registerGlobalReceiver(StaffActionPayload.ID, (payload, context) -> {
    ServerPlayerEntity player = context.player();
    // ... lógica
});
```

### ⚠️ PITFALLS
- Java no infiere tipos genéricos de method references en codecs → usar anonymous class.
- En 1.21.1 es `StreamCodec` (para `CustomPacketPayload`), NO `PacketCodec`.

---

## 5. Comandos Brigadier

```java
public class ModCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("staffpanel")
            .requires(source -> hasStaffPermission(source))
            .executes(context -> openPanel(context.getSource()))
            .then(literal("ban")
                .then(argument("player", PlayerArgumentType.player())
                    .executes(context -> banPlayer(context))
                    .then(argument("reason", StringArgumentType.greedyString())
                        .executes(context -> banPlayerWithReason(context))
                    )
                )
            )
        );
    }
}
```

### ⚠️ CRÍTICO: `.requires()` en TODAS las registraciones
Si registrás el mismo literal varias veces (ej. `/staff` + `/staff ban` + `/staff mute`), **CADA registro debe tener su propio `.requires()`**. Si falta en un subcomando, silenciosamente sobreescribe el permiso del padre.

### Permisos: usar fabric-permissions-api, NO hasPermissionLevel
`source.hasPermissionLevel(2)` chequea OP vanilla (ops.json), NO LuckPerms. Jugadores con rango staff NO tienen OP level.

```java
import me.lucko.fabric.api.permissions.v0.Permissions;

// CORRECTO: consulta LuckPerms primero, fallback a OP level 2
Permissions.check(source, "staffpanel.use", 2);

// build.gradle: modImplementation "me.lucko:fabric-permissions-api:0.3.1"
```

---

## 6. GUIs de inventario (vanilla-compatible, server-only)

**El patrón clave para GUIs que funcionan con clientes vanilla**: usar el sistema de inventario vanilla, sin ScreenHandlerType custom.

### ⚠️ CRÍTICO: NO registrar ScreenHandlerType custom en mods server-only
Registrar tipos custom de screen handler fuerza la sync de registries al cliente → los jugadores sin el mod son kickeados. Usar tipos vanilla directamente:

```java
// CORRECTO — vanilla type, sin registro custom
public class StaffPanelMenu extends GenericContainerScreenHandler {
    public StaffPanelMenu(int syncId, Inventory playerInv, ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X3, syncId, playerInv, buildPanelContainer(), 3);
    }

    private static SimpleInventory buildPanelContainer() {
        SimpleInventory container = new SimpleInventory(27);
        // items = "botones" (wool, glass panes con CUSTOM_NAME)
        container.setStack(0, createButton(Items.RED_WOOL, "§c§lBanear"));
        container.setStack(1, createButton(Items.ORANGE_WOOL, "§6§lMutear"));
        // ...
        return container;
    }
}
```

### Abrir desde el server
```java
player.openMenu(new MenuProvider() {
    @Override public Text getDisplayName() { return Text.literal("§c§lPanel de Staff"); }
    @Override public AbstractContainerMenu createMenu(int syncId, Inventory inv, PlayerEntity p) {
        return new StaffPanelMenu(syncId, inv, (ServerPlayerEntity) p);
    }
});
```

### ⚠️ PITFALLS GUIs
- `LoreComponent` (no `ItemLore`) — import: `net.minecraft.component.type.LoreComponent`.
- `onSlotClick` en 1.21.1 retorna `void`, NO `boolean`.
- Overridear `Slot.getStack()` es poco confiable → usar `SimpleInventory` real con items dentro.
- `closeHandledScreen()` es protected → usar `player.closeScreen()`.

---

## 7. Integración LuckPerms

### Permisos en runtime
```java
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;

User user = LuckPermsProvider.get().getUserManager().loadUser(uuid).join();
boolean allowed = user.getCachedData().getPermissionData()
    .checkPermission("staffpanel.use").asBoolean();
```

### ⚠️ PITFALL #1: `user.getNodes()` retorna `Collection<Node>` NO un Map
No usar `containsKey()`. Iterar con for-each:
```java
for (Node node : user.getNodes()) {
    if (node.getKey().equals("group.admin")) { /* es admin */ }
}
```

### ⚠️ PITFALL #2: LuckPerms via RCON = output vacío
Los comandos LP ejecutados via RCON ejecutan pero NO devuelven output (mcrcon retorna string vacío). Verificar por otros medios (ej. `list` muestra el prefix del rango).

### ⚠️ PITFALL #3: `modCompileOnly` para APIs de otros mods
Si tu mod llama APIs de otro mod compilado con mappings distintas, usar `modCompileOnly` (NO `compileOnly`) para que Loom remapee:
```groovy
modCompileOnly files("path/to/OtherMod.jar")  // Loom remapea a tus mappings
```

---

## 8. Mixins

### Config (`your-mod-id.mixins.json`)
```json
{
    "required": true,
    "package": "com.yourgroup.mixin",
    "compatibilityLevel": "JAVA_21",
    "mixins": ["ExampleMixin"],
    "client": [],
    "injectors": { "defaultRequire": 1 }
}
```

### ⚠️ CRÍTICO: verificar nombres de targets contra Yarn mappings ANTES de compilar
Un mixin con nombre de método incorrecto compila pero **crash-ea todo el server al boot**: `MixinApplyError: Critical injection failure: could not find any targets matching 'X'`.

Extraer nombres reales del jar de mappings de Loom (columnas tiny v2: official → intermediary → named):
```bash
unzip -p "$HOME/.gradle/caches/fabric-loom/1.21.1/net.fabricmc.yarn.1_21_1.1.21.1+build.3-v2/mappings.jar" "mappings/mappings.tiny" \
  | grep -A 40 "^c\tcjt\t" | grep "^m" | awk -F'\t' '{print $3, "→", $4}'
```

Trampas conocidas 1.21.1:
- Enderman block pickup está en la clase INNER `EndermanEntity$PickUpBlockGoal` (`class_1560$class_1563`), no en el entity.
- `CreeperEntity` tiene DOS `explode()` — desambiguar por descriptor.

---

## 9. Mods server-only (¡lo más común en este server!)

El server usa **solo mods server-side**. Un mod con `environment: *` y entrypoint client hace que jugadores sin el mod sean kickeados.

### Checklist de conversión a server-only:
1. `fabric.mod.json`: `"environment": "server"`, eliminar entrypoint `"client"`
2. `build.gradle`: quitar `splitEnvironmentSourceSets()` y `sourceSet sourceSets.client`
3. Eliminar carpeta `client/`
4. **NO registrar ScreenHandlerType custom** (fuerza sync al cliente)
5. `grep -r "net.minecraft.client" src/main/java/` → debe dar vacío

### Ejemplo real: `mod-examples/latamrust-core/`
```json
"environment": "server",
"entrypoints": {
    "main": ["com.mikadev.Anticheat"],
    "server": ["com.mikadev.AnticheatServer"]
}
```
Pero OJO: latamrust-core tiene client mixins para el lado cliente (ResourcePackDisabler) — es un mod hibrido. Un mod PURO server-only no tiene nada en client/.

---

## 10. Build, test, deploy

```bash
./gradlew build          # → build/libs/your-mod-id-1.0.0.jar
./gradlew runServer      # test local
cp build/libs/your-mod-id-1.0.0.jar "D:/SERVIDOR/servers/LATAMRUST COBBLEMON/mods/"
```

### Verificación post-build
```bash
# 1. El jar existe
ls -la build/libs/*.jar
# 2. fabric.mod.json válido
python3 -c "import json; json.load(open('src/main/resources/fabric.mod.json'))"
# 3. Sin errores de compilación
./gradlew build 2>&1 | grep -i "error"
# 4. El jar tiene clases
unzip -l build/libs/your-mod.jar | grep -c "\.class"
# 5. ¡UN BOOT REAL del server! (cualquier dependencia rota aborta el boot)
```

### ⚠️ SIEMPRE hacer un boot real del server después de instalar un mod nuevo
Una dependencia faltante/rota aborta todo el boot (`Incompatible mods found!` / `HARD_DEP_NO_CANDIDATE` / `MixinApplyError`). Leer las líneas `Immediate reason` / `Caused by`, NO el primer frame del stack trace. Casos reales: ClaimBlocks necesitaba `gooeylibs >= 3.1.1`; immersive_paintings necesitaba `fzzy_config >= 0.7.0+1.21`.

---

## 11. Reglas del usuario (¡NO romper!)

1. **Código universal** — NUNCA hardcodear paths (`D:/SERVIDOR/`), IPs, ni puertos. Usar `server.getRunDirectory().toFile()` y configs JSON.
2. **NO sugerir quitar mods como solución** — el usuario lo rechaza rotundamente. Reparar, no eliminar.
3. **Todos los mods server-side** — nada que requiera client-side obligatorio.
4. **Strings en español** para la UI.
5. Verificar 4 veces antes de declarar éxito. Test real en el server.

---

## 12. Links de referencia

- Fabric Wiki: https://wiki.fabricmc.net
- Fabric Docs: https://docs.fabricmc.net/develop
- Yarn Mappings: https://maven.fabricmc.net/docs/yarn/
- Example Mod: https://github.com/FabricMC/example-mod
- LuckPerms API: https://github.com/LuckPerms/API
- Loom Docs: https://docs.fabricmc.net/develop/loom

*Última actualización: 2026-08-10 · Target: MC 1.21.1, Fabric Loader 0.19.3, Fabric API 0.116.15+1.21.1, Java 21*
