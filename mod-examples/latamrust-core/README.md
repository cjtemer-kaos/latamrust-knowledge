# latamrust-core — Ejemplo Real de Mod Fabric

Mod anticheat del server LATAMRUST COBBLEMON. Sirve como **ejemplo funcional completo** de mod Fabric 1.21.1.

## Qué demuestra este ejemplo

| Feature | Archivo |
|---------|---------|
| Entrypoints main + server + client | `Anticheat.java`, `AnticheatServer.java`, `AnticheatClient.java` |
| Networking custom (CustomPacketPayload) | `packets/RequestModsPayload.java`, `packets/ModListPayload.java` |
| Config simple (SimpleConfig) | `config/SimpleConfig.java` |
| Mixins server + client | `latamrust-core.mixins.json`, `latamrust-core.client.mixins.json` |
| Verificación server→client (handshake) | `AnticheatServer.java` — pide la lista de mods al cliente al entrar |
| Exención por grupo LuckPerms | `AnticheatServer.java` — `exemptGroups` del config |
| **LP Loader** (dependencia de LuckPerms) | `fabric.mod.json` — `"depends": {"luckperms": "*"}` |
| Timeout configurable | `AnticheatServer.java` — `MOD_CHECK_TIMEOUT_SECONDS = 300` |

## Build

```bash
./gradlew build
# → build/libs/latamrust-core-1.0.0.jar
```

## Config (config/latamrust-core.config)

```properties
# Mods permitidos en el cliente (el server kickea si el cliente tiene mods no listados)
allowed_mods=fabric-api,... (lista completa en el config del server)

# Grupos de LuckPerms exentos del check
exempt_groups=admin,staff+,staff,builder

# Timeout del check de mods (segundos)
mod_check_timeout_seconds=300
```

## Notas de producción
- El jar en producción fue recompilado con `MOD_CHECK_TIMEOUT_SECONDS = 300` (5 min) para que los jugadores puedan hacer `/login` de EasyAuth antes del check.
- `"luckperms"` está en `depends` (no `suggests`) para que LuckPerms cargue ANTES que este mod → resuelve el deadlock Paradigm↔LuckPerms (ver `docs/LP-LOADER.md`).
