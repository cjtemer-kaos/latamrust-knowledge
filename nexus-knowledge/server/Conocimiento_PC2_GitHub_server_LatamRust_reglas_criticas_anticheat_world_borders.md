# Conocimiento PC2 GitHub: server LatamRust, reglas criticas, anticheat, world borders, chunky

CONOCIMIENTO PC2 (GitHub latamrust-knowledge) - Parte 1: SERVER LATAMRUST

SERVER: LATAMRUST COBBLEMON, Fabric 1.21.1, Loader 0.19.3 (build 26.2), Sponge-Mixin 0.17.3, 325 mods, RAM 10G-20G G1GC, MCSS manager. Puertos: game 55555, RCON 25575, BlueMap 8101.

REGLAS CRITICAS (NO ROMPER):
1. NUNCA ejecutar fabric-installer.jar - crea fabric-server-launch.jar 616B SIN intermediary-1.21.1.jar en Class-Path → 68 mods con accessWideners crashean: 'ClassTweakerFormatException: Namespace (intermediary) does not match current runtime namespace (official)'. El ORIGINAL 639B SÍ incluye intermediary.
2. fabric-server-launch.jar DEBE ser 639 bytes (si es 616, restaurar .bak)
3. NUNCA borrar sponge-mixin/0.17.3+mixin.0.8.7/ (loader lo hardcodea) → 'NoClassDefFoundError: MixinBootstrap'
4. NUNCA editar fabric-installer.json dentro del loader jar
5. NUNCA modificar .jar de mods (compilados con mappings intermediary)
6. NUNCA bajar a Fabric Loader 0.18.4 (rompe staff-panel y yawp que requieren >=0.19.2/0.19.3). No subir a 0.19.4+ sin probar
7. NUNCA hardcodear paths absolutos
8. NUNCA tocar launcher.py (estabilizado v4.3.1)

ANTICHEAT: latamrust-core, valida mods de clientes. Config: latamrust-core.config con allowed_mods (483 mods) y exempt_groups=admin,staff+,staff,builder. Kick si mod no permitido. Logs en logs/latamrust-core.log. Comandos RCON: 'latamrust mods <player>', 'latamrust reload'.

WORLD BORDERS: Overworld 60000 (±30000, centro 0,0), Nether 7500 (±3750), End 30000 (centro -150,6, ±15000), Distortion 5000 (-11,-4), Nightmare 5000 (0,0). Dia 50min, noche 10min, sin lluvia (datapack).

CHUNKY: mundo 'world', centro 0,0, radio 30000, ~334 chunks/seg, ETA ~11.5h, interior 0-15000 generado, anillo exterior 15000-30000 en curso. Config config/chunky.json. Auto-switch cada 5 min: script D:/share/scripts/chunky-auto-switch.sh (pausa si hay jugadores).
