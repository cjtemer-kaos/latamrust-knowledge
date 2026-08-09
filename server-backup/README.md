# LATAMRUST COBBLEMON - Server Backup

Backup de todos los archivos personalizados del server LATAMRUST COBBLEMON (Fabric 1.21.1).

## 📁 Estructura

```
server-backup/
├── configs/                    # Configs personalizados
│   ├── config.yml             # ServerCore (autosave 1800s)
│   ├── main.json              # Cobblemon (save interval 120s)
│   ├── dashboard.json         # Paradigm Dashboard
│   ├── motd.json              # Paradigm MOTD
│   ├── main.json              # Paradigm General
│   ├── tim_core.json          # TimCore (fix: {})
│   ├── latamrust-core.config  # Anti-cheat
│   ├── server.properties      # Server properties
│   └── mcss_server_config.json # MCSS config
├── scripts/                    # Scripts personalizados
│   ├── start.bat              # Start script
│   └── post_startup.bat       # Post-startup (sendCommandFeedback)
├── datapacks/
│   └── custom/
│       └── autogamerule-fix.zip # Auto gamerule fix
└── staff-panel-src/           # Staff Panel mod source
    ├── build.gradle
    ├── settings.gradle
    ├── gradle.properties
    └── main/java/...          # Java source files
```

## 🔧 Configs Clave

| Archivo | Cambio | Valor |
|---------|--------|-------|
| `config.yml` | Autosave | 1800s (30 min) |
| `main.json` | Cobblemon save | 120s |
| `dashboard.json` | Bind | 0.0.0.0:8765 |
| `tim_core.json` | Fix crash | `{}` |
| `mcss_server_config.json` | Startup | BatFile mode |

## 📦 Staff Panel

Mod server-side con:
- `/staff` — Panel de administración
- `/ban`, `/mute`, `/kick`, `/warn` con razón opcional
- `/jail`, `/unjail` — Sistema de cárcel
- `/tp`, `/gm`, `/invsee` — Herramientas admin
- Español completo
- Sin dependencias client-side

## 🚀 Restaurar

1. Copiar configs a `config/` del server
2. Copiar scripts a la raíz del server
3. Copiar `autogamerule-fix.zip` a `world/datapacks/`
4. Compilar staff panel: `gradle clean build`
5. Copiar JAR a `mods/`
