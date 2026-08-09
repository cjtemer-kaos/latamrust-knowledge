# Chat LatamRust — Paradigm tiene el control (solución arcoíris)

> **Fecha**: 2026-08-09
> **Estado**: ✅ RESUELTO
> **Aplica a**: LATAMRUST COBBLEMON (Fabric 1.21.1)

## 🎯 Diagnóstico

1. **Paradigm** es el mod que CONTROLA el chat (no Styled Chat). Su `customChatFormat` gana sobre Styled Chat.
2. Paradigm guarda config en **SQLite** (`config/paradigm/data/paradigm.db`) + memoria + espejo JSON.
3. **Editar el JSON directo NO sirve** — Paradigm lo sobreescribe al recargar desde su BD/memoria.
4. **La única fuente que Paradigm respeta es el DASHBOARD WEB** (`http://100.83.148.88:8765` con token de login one-time).
5. ⚠️ Si OTRO admin (ej: Robben_) está en el dashboard en paralelo, sus guardados **cancelan** los tuyos. Coordinar quién edita.

## ✅ Solución aplicada

### Formato de chat (Paradigm → CHAT editor)
```
{prefix}<rainbow>{player_name}</rainbow> <color:dark_gray>»</color> <color:white>{message}</color>
```
- `{prefix}` → prefix rojo de LuckPerms (`[ADMIN]`)
- `<rainbow>` → nombre arcoíris
- mensaje blanco

### LuckPerms
- Restaurado al backup del mismo día 10:45 (estado original)
- Prefix del grupo `admin` limpiado: `&c[ADMIN]&r` (rojo)
- Todos los OP en grupo `admin` con los 8 nodos base:
  - `ftbchunks.max_claimed` (server: 5000)
  - `luckperms.group.*`
  - `luckperms.*`
  - `essentialcommands.command.rules`
  - `essentialcommands.command.spawn`
  - `gamemode.creative`
  - `minecraft.command.gamemode`
- Eliminado `test.perm` y prefixes duplicados (`[BUILDER]`, `[VIPX]`, `[VIP]`, `[Jugador]`)

## 🗄️ Backups

| Archivo | Ubicación |
|---------|-----------|
| `chat.json.bak-20260809` | `config/paradigm/` |
| `chat.json.bak2-20260809` | `config/paradigm/` |
| `luckperms-2026-08-09-10-45.json.gz` (estado bueno) | `mods/luckperms/` |

## ⚠️ Regla para el futuro

**Para cambiar el chat en este server SIEMPRE usar el dashboard de Paradigm, NUNCA editar el JSON directo.**

## Comandos útiles

```bash
# Importar backup de LuckPerms (desde el juego, con confirmación)
/lp import luckperms-import
/lp confirm

# Restaurar prefix del grupo admin (rojo)
lp group admin meta setprefix "&c[ADMIN]&r " 100
```