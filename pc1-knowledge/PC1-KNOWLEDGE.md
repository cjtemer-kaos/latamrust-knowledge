# PC1 Knowledge — Launcher, Discord Bot, Configs

> **Origen**: PC1 (agente Hermes KAOS_MCS)
> **Fecha**: 2026-08-07
> **Propósito**: Unificar el conocimiento de PC1 con el de PC2 en este repo.

## 🚀 Launcher CobbleVerse v5.0

**Ubicación código**: `D:/ias/proyectos/cobbleverse-launcher-v2/`
**EXE**: `LatamRust_Cobbleverso.exe` (24MB, PyInstaller onefile)

### Características v5.0
- **Google Drive download** con `gdown` (ID: `1h0ohkqZrSO2XX-ZIXYx7Ru0lAKqj9--n`) — ~65MB/s
- **Java 21 auto-install** — descarga JDK a `GAME_DIR/jdk-21/` si no existe
- **Skins sync** (INSTALAR y JUGAR) — GitHub release `skins-v1`, extrae a `config/easy_npc/skin/`
- **portablemc** descargado a `GAME_DIR/portablemc.exe` (NO al directorio del EXE — fix crítico)
- **Update button** — verifica GitHub releases
- **installed() fix** — solo verifica `GAME_DIR/mods/` buscando `fabric-api`
- **Botón JUGAR verde** cuando `installed()` es True (`bg=C["green"], fg=C["white"]`)

### Paths Clave
```python
GAME_DIR = %APPDATA%/LatamRust
BASE_DIR = directorio del EXE (Desktop)
TEMP_DIR = %TEMP%/CobbleVerse_Temp
PORTABLEMC = GAME_DIR/portablemc.exe  # ← FIX: permanente, no se limpia
```

### Fixes críticos aplicados
1. **portablemc a GAME_DIR** — antes se descargaba al Desktop (BASE_DIR) y se limpiaba. Ahora vive en la instalación.
2. **Botón JUGAR verde** — `_refresh()` restaura `bg=C["green"]` cuando installed.
3. **GAME_DIR definido antes de usarse** — no hay referencia antes de definición.

### Build
```bash
PYTHONPATH= "C:/Users/cjtr/AppData/Local/Programs/Python/Python313/python.exe" -m PyInstaller \
  --onefile --windowed --name "LatamRust_Cobbleverso" \
  --add-data "assets;assets" --hidden-import gdown --clean main_v5.py
```

## 🤖 Discord Bot (asistente ia#2568)

**Ubicación**: `D:/ias/proyectos/supernexus-v2/discord_bot.py`
**Bot ID**: `1460096814261862524`
**Server**: 『𝗞𝗔𝗢𝗦 𝗠𝗰𝘀』 (ID: 712390482096816209)
**Canal**: #asistente-ia

### Conexión DIRECTA a Hermes (no SuperNEXUS)
- Usa `HERMES_GATEWAY_URL = http://127.0.0.1:8642/api/chat`
- NO pasa por SuperNEXUS — respuesta directa del motor Hermes
- Webhook alternativo: `http://localhost:8644/webhooks/discord-chat`

### Comandos
- `ia <mensaje>` — respuesta directa
- `@asistente ia <mensaje>` — mención
- DM directo al bot
- `!ping` — latencia
- `!status` — estado

### Invitación (OAuth2)
```
https://discord.com/api/oauth2/authorize?client_id=1460096814261862524&permissions=2147487936&scope=bot
```

## ⚙️ Config Hermes PC1

**Config**: `~/.hermes/config.yaml`
**Provider principal**: custom (Ollama local `gemma4:latest`)
**Provider Zen**: `opencode-zen` → `https://opencode.ai/zen/v1`
**API key**: `OPENCODE_ZEN_API_KEY` en `~/.hermes/.env`

### SuperNEXUS MCP
```yaml
mcp_servers:
  supernexus:
    command: C:\Users\cjtr\AppData\Local\Programs\Python\Python313\python.exe
    args: [D:\ias\proyectos\supernexus-v2\mcp_bridge_wrapper.py]
    env:
      PYTHONPATH: D:\ias\proyectos\supernexus-v2
      NEXUS_BRAIN: C:\Users\cjtr\.nexus\brain
```

## 🌐 Comunicación PC1 ↔ PC2

- **Canal**: `//PC2-NEXUS/share/mensajes/` (send.py / receive.py)
- **Regla**: la comunicación NUNCA se corta
- **Share**: `//PC2-NEXUS/share/` (proyectos compartidos)

## 🔑 Reglas de PC1

1. NUNCA subir IPs/passwords/usernames internos a repos públicos (limpiar con regex)
2. Repo cobbleverse-launcher es PÚBLICO — el launcher baja el pack de ahí
3. Pack >100MB: git rechaza → usar GitHub Releases
4. Revisar código 3 veces antes de declarar "listo"
5. NO tocar código que funciona
6. Testear ANTES de decir "listo"
