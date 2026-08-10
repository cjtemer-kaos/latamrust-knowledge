# LP-Loader / Orden de Carga de Mods — Problema resuelto

## Problema
Paradigm intenta registrar 2038 permisos con LuckPerms al iniciar. Si LP no está listo, Paradigm reintenta 5 veces con delay → **12 minutos de lag / deadlock** al arrancar el server.

## Solución (2026-08-10 — idea del usuario, funcionó)
**Un solo mod resuelve dos problemas**: el anticheat (`latamrust-core`) se convirtió en LP Loader.

### Cadena de carga resultante
```
luckperms → latamrust-core → paradigm
```

### Cómo se logró
1. **latamrust-core** (anticheat, source: `mod-examples/latamrust-core/`):
   - `fabric.mod.json`: cambió `"suggests": {"luckperms": "*"}` → `"depends": {"luckperms": "*"}` → obliga a Fabric a cargar LuckPerms primero
   - Timeout del check de mods: `MOD_CHECK_TIMEOUT_SECONDS = 300` (en `AnticheatServer.java`) — los jugadores tienen 5 min para hacer `/login` antes del check (interacción EasyAuth ↔ anticheat)

2. **Paradigm** (jar parcheado, re-empaquetado):
   - `fabric.mod.json`: agregado `"luckperms": "*"` y `"latamrust-core": "*"` en `depends`

3. **Config adicional**: `externalCommandPermissionsEnable=false` en `config/paradigm/main.json`

### Resultado verificado
```
[00:40:42] Done (1.939s)!
[00:40:37] Permissions » Selected "LuckPerms Permissions Service" (Provider: Impactor, Priority = 10)
[00:40:40] Paradigm: LuckPerms integration initialized with 2038 known permission nodes.
```

## Cómo parchear un jar (sin fuente)
```python
import zipfile, json, os

jar = "ruta/al/mod.jar"
zf = zipfile.ZipFile(jar)
fmj = json.loads(zf.read("fabric.mod.json"))
fmj["depends"]["otro-mod"] = "*"  # agregar dependencia
zf.close()

out = jar + ".new"
zin, zout = zipfile.ZipFile(jar), zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED)
for item in zin.infolist():
    data = zin.read(item.filename)
    if item.filename == "fabric.mod.json":
        data = json.dumps(fmj, indent=2).encode()
    zout.writestr(item, data)
zin.close(); zout.close()
# Reemplazar: mv jar.new jar  (¡hacer backup antes!)
```

## Notas
- Verificar que el jar no esté firmado (no `META-INF/*.SF`/`.RSA`) antes de parchear
- Backups: `latamrust-core-1.0.0.jar.bak` (timeout 120s), `Paradigm-fabric-1.21.1-2.3.0b.jar.bak` (original)
