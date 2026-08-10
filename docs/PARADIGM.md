# Paradigm — Guía Completa del Mod

> **Versión**: 2.3.0b | **MC**: 1.21.1 | **Plataforma**: Fabric  
> **GitHub**: https://github.com/Avalanche7CZ/Paradigm  
> **Modrinth**: https://modrinth.com/mod/paradigm  
> **Dashboard**: `http://100.83.148.88:8765` (Tailscale)
>
> 📖 **Referencia completa (752 líneas con permisos exactos por comando, custom commands, formato, storage)**: [PARADIGM-COMPLETE-REFERENCE.md](PARADIGM-COMPLETE-REFERENCE.md)
> 🗣️ **Fix de chat (Paradigm controla el chat, arcoíris, backups)**: [CHAT-PARADIGM.md](CHAT-PARADIGM.md)

## 📋 Visión General

Paradigm es un mod completo de gestión de servidores Minecraft para Fabric. Incluye:
- Chat personalizado con formato configurable
- Tablist con header/footer
- 100+ comandos de administración
- Dashboard web para gestión remota
- Sistema de jail
- Grupos de chat
- Sistema de permisos interno
- Hologramas, anuncios, reinicios programados
- Cooldowns, menciones, comandos custom

## 🔧 Configuración

### Archivos de Configuración
| Archivo | Función |
|---------|---------|
| `config/paradigm/main.json` | Configuración general |
| `config/paradigm/chat.json` | Formato de chat |
| `config/paradigm/tablist.json` | Tablist header/footer |
| `config/paradigm/commands.json` | Habilitar/deshabilitar comandos |
| `config/paradigm/cooldowns.json` | Cooldowns de comandos |
| `config/paradigm/motd.json` | Message of the Day |
| `config/paradigm/announcements.json` | Anuncios programados |
| `config/paradigm/restarts.json` | Reinicios programados |
| `config/paradigm/moderation-settings.json` | Moderación (ban, jail) |
| `config/paradigm/mentions.json` | Sistema de menciones |
| `config/paradigm/emojis.json` | Emojis personalizados |
| `config/paradigm/holograms.json` | Hologramas |
| `config/paradigm/data/paradigm.db` | Base de datos SQLite |

### ⚠️ Regla de Oro
**Paradigm reescribe los archivos JSON al hacer reload.** Siempre usar el **dashboard web** o **comandos in-game** para cambios. Editar el JSON directamente NO sirve.

## 📝 Comandos

### Chat
| Comando | Descripción |
|---------|-------------|
| `/msg <player> <msg>` | Mensaje privado |
| `/reply <msg>` | Responder último privado |
| `/sc <msg>` | Chat de staff (solo admins) |
| `/socialspy` | Ver mensajes privados de otros |
| `/ignore <player>` | Ignorar jugador |
| `/unignore <player>` | Dejar de ignorar |
| `/mention <player> <msg>` | Mencionar con notificación |
| `/groupchat <sub>` | Grupos de chat |

### Teletransporte
| Comando | Descripción |
|---------|-------------|
| `/spawn` | Ir al spawn |
| `/setspawn` | Establecer spawn (admin) |
| `/home <name>` | Ir a home personal |
| `/homes` | Listar homes |
| `/sethome <name>` | Crear home |
| `/delhome <name>` | Eliminar home |
| `/warp <name>` | Ir a warp público |
| `/warps` | Listar warps |
| `/setwarp <name>` | Crear warp (admin) |
| `/delwarp <name>` | Eliminar warp (admin) |
| `/tpa <player>` | Solicitar TP |
| `/tpahere <player>` | Pedir que vengan |
| `/tpaccept` | Aceptar TP |
| `/tpdeny` | Rechazar TP |
| `/tpcancel` | Cancelar TP |
| `/back` | Volver a última posición |
| `/jump` | Ir al bloque mirado |

### Administración
| Comando | Descripción |
|---------|-------------|
| `/gamemode <mode> [player]` | Modo de juego |
| `/gmc /gms /gma /gmsp` | Modos rápidos |
| `/fly [player]` | Vuelo |
| `/god [player]` | Invencible |
| `/heal [player]` | Curar |
| `/feed [player]` | Llenar hambre |
| `/speed <amount> [player]` | Velocidad |
| `/clearinv [player]` | Limpiar inventario |
| `/repair [hand\|all]` | Reparar items |
| `/enchant <enchant> [level]` | Encantar |
| `/vanish` | Invisible |
| `/sudo <player> <cmd>` | Ejecutar como otro |
| `/whois <player>` | Info detallada |
| `/near [radius]` | Jugadores cercanos |
| `/invsee <player>` | Ver inventario |
| `/day /night /sun /rain /thunder` | Clima/hora |
| `/top` | Bloque más alto |

### Moderación
| Comando | Descripción |
|---------|-------------|
| `/ban <player> [reason]` | Banear |
| `/tempban <player> <time> [reason]` | Ban temporal |
| `/unban <player>` | Desbanear |
| `/ipban <player> [reason]` | Ban por IP |
| `/kick <player> [reason]` | Expulsar |
| `/mute <player> [reason]` | Silenciar |
| `/tempmute <player> <time> [reason]` | Mute temporal |
| `/unmute <player>` | Quitar silencio |
| `/warn <player> [reason]` | Advertir |
| `/jail <player> <time> [reason]` | Encarcelar |
| `/unjail <player>` | Liberar |
| `/setjail` | Ubicación jail |
| `/pardon <player>` | Perdonar |

### Utilidad
| Comando | Descripción |
|---------|-------------|
| `/seen <player>` | Última vez online |
| `/warpinfo <warp>` | Info de warp |
| `/hologram <sub>` | Hologramas |
| `/paradigm help` | Ayuda |
| `/paradigm reload` | Recargar config |
| `/paradigm dashboard` | Info dashboard |
| `/restart` | Reiniciar server |

### Grupos de Chat
| Comando | Descripción |
|---------|-------------|
| `/groupchat create <name>` | Crear grupo |
| `/groupchat invite <player>` | Invitar |
| `/groupchat accept <name>` | Aceptar |
| `/groupchat deny <name>` | Rechazar |
| `/groupchat leave` | Salir |
| `/groupchat info [name]` | Info grupo |
| `/groupchat toggle` | Activar/desactivar chat |

## 🏗️ Módulos (main.json)

| Módulo | Config Key | Estado |
|--------|-----------|--------|
| Anuncios | `announcementsEnable` | ✅ Activo |
| MOTD | `motdEnable` | ✅ Activo |
| Menciones | `mentionsEnable` | ✅ Activo |
| Reinicios | `restartEnable` | ✅ Activo |
| Debug | `debugEnable` | ❌ Desactivado |
| Gestor Comandos | `commandManagerEnable` | ✅ Activo |
| Prioridad Comandos | `forceCommandPriorityEnable` | ✅ Activo |
| Permisos Internos | `internalPermissionsEnable` | ✅ Activo |
| Permisos Externos | `externalCommandPermissionsEnable` | ❌ Desactivado |
| Telemetry | `telemetryEnable` | ✅ Activo |
| Comandos Home | `homeCommandsEnable` | ✅ Activo |
| Comandos TPA | `tpaCommandsEnable` | ✅ Activo |
| Comandos Warp | `warpCommandsEnable` | ✅ Activo |
| Comandos Spawn | `spawnCommandsEnable` | ✅ Activo |
| Comandos Moderación | `moderationCommandsEnable` | ✅ Activo |
| Comandos Admin | `adminUtilityCommandsEnable` | ✅ Activo |

## ⚠️ Problemas Conocidos

### 1. Jail de Paradigm
- No bloquea comandos — jugadores escapan con `/home`
- `/unjail` no guarda posición original
- **Solución**: Usar mod "Jail Logic" (v1.5) en vez del jail de Paradigm

### 2. Carga Lenta (LP vs Paradigm)
- Paradigm intenta registrar 2038 permisos con LuckPerms
- Si LP no está listo, reintenta 5 veces con delay
- Causa **12 minutos de lag** al arrancar
- **Solución**: LP-Loader mod que fuerza carga de LP antes de Paradigm

### 3. Configuración de Chat
- Paradigm sobreescribe Styled Chat
- `enableCustomChatFormat=false` + `paradigm reload chat` por RCON
- **NO editar JSON directamente** — Paradigm lo reescribe

### 4. Tablist
- `%player:displayname%` causa doble rango
- **Solución**: Cambiar a `%player:name%`

## 🔗 Integración con LuckPerms

Paradigm tiene integración con LuckPerms para:
- Registro de permisos (2038 nodos)
- Migración de permisos
- Sync de grupos

**Para deshabilitar**: `externalCommandPermissionsEnable = false` en main.json

## 📊 Dashboard Web

- **URL**: `http://100.83.148.88:8765`
- **Puerto**: 8765
- **Requiere**: Login con token
- **Funciones**: Editar chat, tablist, comandos custom, audit log

## 🗄️ Backups

| Archivo | Ubicación |
|---------|-----------|
| `Paradigm-fabric-1.21.1-2.3.0b.jar.bak` | `mods/` (original sin parchear) |
| `chat.json.bak-20260809` | `config/paradigm/` |
| `chat.json.bak2-20260809` | `config/paradigm/` |

## 📚 Fuentes

- GitHub Wiki: https://github.com/Avalanche7CZ/Paradigm/wiki
- Modrinth: https://modrinth.com/mod/paradigm
- Config files: `config/paradigm/`
- Language files: `lang/en.json` en el JAR
