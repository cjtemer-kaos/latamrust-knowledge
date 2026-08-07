# ⛔ REGLAS CRÍTICAS — NO ROMPER EL SERVER

> **ESTE ARCHIVO ES OBLIGATORIO PARA CUALQUIER AGENTE/ASISTENTE**
> **Leer ANTES de hacer CUALQUIER cambio en el servidor**

## 🚫 PROHIBICIONES ABSOLUTAS

### 1. NUNCA ejecutar el Fabric Installer
```bash
# ❌ NUNCA HACER ESTO:
java -jar fabric-installer.jar server -mcversion 1.21.1 -loader 0.19.3
```
**Por qué**: El Fabric Installer 1.0.1 crea un `fabric-server-launch.jar` (616B) que **NO incluye** `intermediary-1.21.1.jar` en su Class-Path. Esto causa que el Fabric Loader interprete el namespace runtime como `official` en vez de `intermediary`, y **TODOS los 68 mods con accessWideners `intermediary` crashean** con el error:
```
ClassTweakerFormatException: Namespace (intermediary) does not match current runtime namespace (official)
```
**El launcher ORIGINAL (639B) SÍ tiene el intermediary. NUNCA sobrescribirlo.**

### 2. NUNCA modificar el `fabric-server-launch.jar`
- **Tamaño actual**: 639 bytes (el ORIGINAL correcto)
- **Si ves 616 bytes**: El Fabric Installer lo sobrescribió → restaurar desde `.bak`
- **Class-Path correcto** debe incluir:
  ```
  libraries/net/fabricmc/intermediary/1.21.1/intermediary-1.21.1.jar
  libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar
  libraries/net/fabricmc/fabric-loader/0.19.3/fabric-loader-0.19.3.jar
  ```

### 3. NUNCA borrar el directorio `sponge-mixin/0.17.3+mixin.0.8.7/`
**Por qué**: El loader 0.19.3 (build 26.2) hardcodea esta versión. Sin ella:
```
NoClassDefFoundError: org/spongepowered/asm/launch/MixinBootstrap
```

### 4. NUNCA editar el `fabric-installer.json` dentro de `fabric-loader-0.19.3.jar`
**Por qué**: El loader tiene paths hardcodeados. Cambiar la versión de sponge-mixin rompe la resolución de librerías.

### 5. NUNCA modificar archivos `.jar` de mods
**Excepción**: Solo con autorización explícita del admin KAOS_MCS
**Por qué**: Los mods están compilados con mappings `intermediary`. Modificarlos rompe la compatibilidad.

### 6. NUNCA cambiar la versión del Fabric Loader
- **Versión actual**: 0.19.3 (build 26.2)
- **Sponge-Mixin**: 0.17.3
- **NO bajar a 0.18.4** (rompe dependencias de `staff-panel` y `yawp`)
- **NO subir a 0.19.4+** (sin probar primero)

### 7. NUNCA hardcodear paths absolutos
- Usar rutas relativas o variables de entorno
- El server irá a cloud eventualmente

### 8. NUNCA tocar `launcher.py`
- Está estabilizado en v4.3.1
- Cualquier cambio requiere aprobación explícita

## ✅ LO QUE SÍ SE PUEDE HACER

### Cambios seguros
- Agregar/quitar mods de `mods/` (con backup)
- Modificar configs de mods en `config/`
- Editar datapacks en `world/datapacks/`
- Ejecutar comandos RCON
- Modificar `start.bat` (parámetros JVM)
- Actualizar documentación

### Cambios con precaución
- Actualizar mods (verificar compatibilidad primero)
- Modificar `mcss_server_config.json` (verificar startupLine)
- Cambiar world borders (verificar F3 coords)
- Modificar LuckPerms (usar web editor, no RCON)

## 🔧 SI EL SERVER SE ROMPE

### Error: `Namespace (intermediary) does not match official`
```bash
# 1. Verificar fabric-server-launch.jar
stat -c%s fabric-server-launch.jar  # Debe ser 639, no 616

# 2. Si es 616, restaurar backup
cp fabric-server-launch.jar.bak fabric-server-launch.jar

# 3. Verificar Class-Path incluye intermediary
unzip -p fabric-server-launch.jar META-INF/MANIFEST.MF | grep intermediary
```

### Error: `NoClassDefFoundError: MixinBootstrap`
```bash
# 1. Verificar sponge-mixin 0.17.3 existe
ls libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/

# 2. Si no existe, descargar de Maven
curl -L -o libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar \
  "https://maven.fabricmc.net/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/sponge-mixin-0.17.3+mixin.0.8.7.jar"
```

### Error: `staff-panel requires fabricloader >=0.19.3`
```bash
# NO bajar a 0.18.4 — mantener 0.19.3
# Verificar que MCSS apunta a fabric-server-launch.jar, no a .fabric/server/...
cat mcss_server_config.json | grep startupLine
# Debe decir: -jar fabric-server-launch.jar nogui
```

## 📋 CHECKLIST ANTES DE CUALQUIER CAMBIO

- [ ] ¿Leí este archivo completo?
- [ ] ¿Tengo backup del archivo que voy a modificar?
- [ ] ¿El cambio fue aprobado por el admin?
- [ ] ¿Verifiqué que no rompe dependencias?
- [ ] ¿Probé el cambio en un entorno seguro primero?

## 🏗️ ARQUITECTURA DEL BOOT

```
fabric-server-launch.jar (639B)
  └── Class-Path →
      ├── asm-9.10.1.jar
      ├── sponge-mixin-0.17.3.jar  ← ¡CRÍTICO!
      ├── intermediary-1.21.1.jar  ← ¡CRÍTICO!
      └── fabric-loader-0.19.3.jar
           └── fabric-installer.json → sponge-mixin:0.17.3
```

**El launcher ORIGINAL (639B) es el que funciona. NUNCA sobrescribir con el del Fabric Installer.**

---

**Última actualización**: 2026-08-07
**Autor**: KAOS_MCS (admin)
**Estado**: Vigente — servidor online con 325 mods
