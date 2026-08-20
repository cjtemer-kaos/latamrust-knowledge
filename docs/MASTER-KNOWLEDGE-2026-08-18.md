# MASTER KNOWLEDGE — LATAMRUST COBBLEMON (absorbido 2026-08-18 por opencode)

> Consolidación de las 3 fuentes: `latamrust-knowledge` (repo + D:\share local), sesión Hermes (PC2), cerebro latamrust-nexus (SuperNEXUS fork). Server NO modificado.

## 1. Identidad del servidor
- **LATAMRUST COBBLEMON** (CobbleVerse "Pokemon Adventure"). Fabric 1.21.1 · Loader **0.19.3** (build 26.2) · Sponge-Mixin **0.17.3** · Java 21 Adoptium · 325+ mods · MCSS (BatFile) · RAM 10–20G G1GC · Ryzen 5 2600 (6C/12T) / 32GB.
- **Server path**: `D:\SERVIDOR\servers\LATAMRUST COBBLEMON`. Ruta knowledge local: `D:\share\latamrust-knowledge` (más docs que el GitHub `cjtemer-kaos/latamrust-knowledge`).
- Puertos: juego **55555** · RCON **25575** · BlueMap **8101** · Paradigm dashboard **8765** · LuckPerms editor **8080**.
- server.properties real: `online-mode=false`, `allow-flight=true`, `allow-cheats=true`, `enable-command-block=true`, `max-tick-time=-1`, view/sim-distance **8**, max-players **30**, `level-name=world`, rcon.on. MOTD "LATAM RUST Adventure PvE | 30 jugadores | Modpack incluido".
- Mundo: OW 60k×60k (c 0,0, r±30k) · Nether 7.5k · End 30k (c -150,6) · Distortion 5k (c -11,-4) · Nightmare 5k (c 0,0). Día 50 min / noche 10 min, sin lluvia (datapack).

## 2. Reglas críticas (NO ROMPER)
1. NUNCA ejecutar el **Fabric Installer** (genera launcher 616B sin `intermediary` → crash `ClassTweakerFormatException: Namespace (intermediary) does not match official` en 68 mods).
2. `fabric-server-launch.jar` debe ser **639B** (no 616); Class-Path = asm-9.10.1 + **sponge-mixin-0.17.3+mixin.0.8.7** + **intermediary-1.21.1** + fabric-loader-0.19.3. Restaurar desde `.bak` si se ve 616.
3. NUNCA borrar `libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/` (`NoClassDefFoundError: MixinBootstrap`).
4. NUNCA editar `fabric-installer.json` dentro del loader (paths hardcodeados).
5. NUNCA modificar `.jar` de mods (solo con aprobación de **KAOS_MCS**).
6. NUNCA cambiar loader: no 0.18.4 (rompe staff-panel y yawp) ni 0.19.4+ sin probar.
7. NUNCA hardcodear paths absolutos (server irá a cloud). NUNCA tocar `launcher.py`.
8. NUNCA comandos chunky (`status/progress/cancel`) con server vivo → bloquea Server thread (evidencia 08-07: kick a 2 jugadores). Chunky solo con server apagado o vía logs.
9. SIEMPRE verificar config de mod nuevos (defaults malos: 08-07 lag de 63s / 1260 ticks).
- Cambios seguros: mods con backup, `config/`, `world/datapacks/`, RCON, `start.bat`, docs. Precaución: actualizar mods, `mcss_server_config.json` (startupLine = `-jar fabric-server-launch.jar nogui`), borders, LuckPerms (usar web editor).
- JVM/MCSS: `-Xms10G -Xmx20G` Aikar flags (G1NewSize 30/40 max, region 8M, IHOP 15, ActiveProcessorCount 6, UseStringDeduplication, ExitOnOutOfMemoryError), `-jar fabric-server-launch.jar nogui`, `allocatedMemory=20480`.

## 3. Mods propios del proyecto
- **latamrust-core** (anticheat custom, com.mikadev, v1.2): kick por allow-list de mods (**483 permitidos**), `exempt_groups=admin,staff+,staff,builder`, timeout **300s**, logs `logs/latamrust-core.log`, `/latamrust mods <p>` y reload. Actúa como primer cargador de LuckPerms.
- **staffpanel**: v1.0.1 GUI pura (depende de `paradigm` + `jailmod`; genera comandos). v1.0.0 antigua = equipada con JailSystem propio (jail JSON, `staffpanel-jail.json`, radius, tick cada 1s). Déploy **pendiente** (shops_panel + staffpanel 1.0.1 en `pendientes-despliegue/` + `INSTRUCCIONES.txt`).
- **hermes-agent v1.1.0** en `mods/`; fuente en `D:\SERVIDOR\mods-dev\`.

## 4. Protección, permisos y chat
- FTB Chunks (claims) + FTB Teams activos. **ClaimBlocks** prototipo listo (Kotlin, F0CUS; 5 templates stone 10×10→150×150; 11 flags; `/cb *`; dep gooeylibs) — decisión pendiente, doc recomienda mantener ambos.
- **LuckPerms**: 9 rangos (admin > staff+ > staff > builder > director > vipx > vip > trainer > default). Storage real **H2** (`mods/luckperms/luckperms-h2-v2.mv.db`; yml dice json — contradicción, H2 es la verdad). Prefixes: admin `&c[ADMIN]&r`=100, VIP=20, VIPX, TRAINER=5 (higher weight → prefix gana). VIP/VIPX temporales vía `lp user <p> parent addtemp vip 30d`. Kit: VIP 8 homes/TP 5s, VIPX 10 homes/TP instantáneo. Web editor `/lp editor` → :8080. OPs lvl4: KAOS__MCS, Robben_, Leftor_, Aryys, JhonSai, JONYmcs. Whitelist 11.
- **Paradigm 2.3.0b**: fuente de verdad = **dashboard :8765 / comandos** (NUNCA editar JSON directo, lo sobreescribe). Chat: `{prefix}<rainbow>{player_name}</rainbow> <color:dark_gray>»</color> <color:white>{message}</color>`; reload `paradigm reload chat`. Jail de Paradigm no bloquea comandos → usar jailmod/jail logic. Reinicios Realtime `["00:00","06:00","12:00","18:00"]`. Tablist en `styledplayerlist/config.json` (`<red><bold>ADMIN</bold></red> <rainbow>%player:name%</rainbow>`, nunca %displayname%). Anuncios 4 canales (chat 60s, actionbar 30s, title 120s, bossbar 45s). Custom commands en `config/paradigm/commands/*.json`.
- yawp + banhammer (sqlite) + EasyAuth (sesión+password) + ledger + worldedit + spark + observable.

## 5. Rendimiento (aplicado; verificado OK 08-18)
- Perf configs actuales correctas: **ThreadTweak** main/game=5 · **ServerCore** activation-range on, MONSTER spawn-interval 4, dynamic perf on · **PacketFixer** allSizesUnlimited=false · **ModernFix** overrides · **Lithium** tuneado · **FerriteCore** · VMP (entity tracking, chunk send 200) · Krypton · FastAsyncWorldSave · LetMeDespawn.
- **CobbleLagClear** (cleanup 20 min, blockCropGrowth, avisos 10/5/3/1) y **CobblemonChunkManager** (16/chunk, MIGRATE_THEN_DESPAWN, heatmap HOT12/WARM6/COLD5) instalados. **C2ME deshabilitado** (spam 48K "Unknown registry key"). Respaldos pre-optim `config-backup-pre-optim-20260808_0807/0808`.
- **Cobblemon config** (`config/cobblemon/main.json`): pokemonPerChunk 0.3, maximumSpawnsPerPass 1, ticks 30, zona 8×16, rango 16–48, XP ×2.0, shinyRate 2048, storage **NBT** (Mongo inactivo), save 120s, raid dim spawn rate 1200, RCT chance 0.35 / maxTrainers 60 / interval 900.
- Diagnóstico: `jstack`, `jstat -gc`, spark, `/ccm heatmap`. TPS 20 objetivo, MSPT <50ms.
- **Chunky**: deshabilitado tras spikes 110s; pregen viable en 1.21.1 = **Fabric Quilt Chunk Pregenerator** (`/pregen start <radius>`). Limpieza pendiente: `config/chunky` + scripts `chunky-*.sh`.

## 6. PC1 — Launcher y Discord
- **Launcher v5.0** (Tkinter, PyInstaller onefile 24MB, `LatamRust_Cobbleverso.exe`): modpack Google Drive ID `1h0ohkqZrSO2XX-ZIXYx7Ru0lAKqj9--n` · Java 21 Oracle auto-install (GAME_DIR `%APPDATA%\LatamRust`) · portablemc.exe a GAME_DIR (fix) · skins GitHub release `skins-v1` → `config/easy_npc/skin` · botón JUGAR verde si `mods/` tiene fabric-api · RAM spinbox 2–32G. Código: `pc1-knowledge/launcher/` (launcher_v5.py, main_v5.py, sync_skins.py). NO tocar launcher.py estable (v4.3.1 launcher del server).
- **Discord bot** `asistente ia#2568` (ID 1460096814261862524 · guild KAOS Mcs 712390482096816209 · canal asistente-ia). Conexión **directa a Hermes** (`http://127.0.0.1:8642/api/chat`, no SuperNEXUS). Trigger: `ia <msg>`, mención, DM. `!ping`/`!status`. Voz Discord pendiente (Opus codec no encontrado).

## 7. Hermes (PC2)
- Modelo `nemotron-3-ultra-free` vía **opencode-zen** (`https://opencode.ai/zen/v1`). TTS es-MX-JorgeNeural. Visión Ollama gemma3:4b. Lanzado por `gateway-service\start_nexus_silent.ps1` (NEXUS API :9000 + gateway). Kanban vacío · memories vacío · state.db 7 sesiones deepseek-v4-flash-free. Pasar de OpenRouter (rate-limit 401) a Zen.
- `hermes_commands/` vacío · `hermes_responses/` solo round-trip test.

## 8. LATAMRUST-NEXUS (SuperNEXUS fork, D:\ias\proyectos\latamrust-nexus)
- "LATAM RUST Admin Console": aiohttp backend :9001 (launcher bat → `start_server.py` → Electron `ui/dist`), ~171 endpoints. Rutas LatamRust `/api/rust/*` (rcon WS, monitor, plugins oxide/carbon, map zones, discord, tebex, wipes jueves quincena AR, leaderboard, quests, player-watch, combatlog) + `/api/voice/*` (XTTS-V2 clone, Whisper) + `/api/minecraft/*` (status/config/mods/backups/rcon/start-stop).
- DirectorLatamRust 32 gemas (9 operativas + 23 LLM desde `data/gemas/*.json`). `gemas_client_overrides/` **sagrado, nunca editar**; gemas_core sync (165/165 tests).
- ⚠️ Brain del nexus describe server **obsoleto** (Fabric 0.18.4 / Java 25 / 103 mods / stopped) — NO coincide con el server real 0.19.3. Datos stale en `data/minecraft_servers.json`. Actualizar ANTES de usar `/api/minecraft/*`.

## 9. Hallazgos pendientes (sin acción, priorizados)
1. Item `mega_showdown:normalium-z`/`mowunit` no registrado + `cobblemon:mega_z` dex fallida (fuente `D:\ias\proyectos\CobblemonMegaShowdown-main`) → revisar sync zamega↔mega_showdown.
2. Deploy pendiente shops_panel + staffpanel 1.0.1 (`pendientes-despliegue/`).
3. Encoding corrupto en `config/cobblelagclear.json` (`PokAcmon`/`autom�tica`, UTF-8 escrito Latin-1).
4. `ops.json` corrupto (entrada `"list"` lvl 4).
5. Brain nexus con datos MC server desactualizados.
6. Limpieza opcional: `config/chunky`, chunky scripts, librerías loader viejas (0.16.14/0.18.4) y sponge-mixin 0.15.5/0.17.0.

## 10. Estado server (08-18 verificado)
Online PID 16996 (~7.5GB), boot 2.26s limpio. Errores no fatales en `logs/latest.log`: normalium-z en joins, receta craftstats craft_wand (patrón '_'), function minecraft:tick, registries vanillabackport "empty", patch libjf PCGUI. Jugador eilex anticheat OK (337 mods).