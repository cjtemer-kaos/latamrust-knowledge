# Conocimiento PC2 GitHub: datapacks-mods, troubleshooting, red, proyectos share

CONOCIMIENTO PC2 (GitHub latamrust-knowledge) - Parte 3: DATAPACKS-MODS, TROUBLESHOOTING, RED, PROJECTS

DATAPACKS/MODS CRITICOS: staff-panel requiere Fabric Loader >=0.19.3, yawp >=0.19.2 (protección de mundo), accessories requiere Fabric API, architectury es core library. Fabric Installer 1.0.1 es PELIGROSO (ver reglas criticas).

TROUBLESHOOTING CLAVE:
1. 'Namespace (intermediary) does not match official' → fabric-server-launch.jar es 616B, restaurar 639B desde .bak
2. 'NoClassDefFoundError: MixinBootstrap' → falta sponge-mixin-0.17.3+mixin.0.8.7.jar, descargar de maven.fabricmc.net
3. 'staff-panel requires fabricloader >=0.19.3' → NO bajar loader, verificar MCSS apunta a fabric-server-launch.jar
4. Verificar server: stat -c%s fabric-server-launch.jar (debe ser 639), ls libraries/net/fabricmc/sponge-mixin/0.17.3+mixin.0.8.7/

RED: PC2 (NEXUS) = 100.83.148.88 Tailscale / 192.168.1.16 LAN / server principal. PC1 = 100.94.236.93 Tailscale / cliente-agente.

PROYECTOS EN SHARE D:/share/ (mapa):
- launcher-cobbleverse/ = launcher principal PRODUCCION (Python → EXE)
- helios-launcher/ = alternativo EXPERIMENTAL (Electron, no usar en prod)
- launcher-v2/ = launchers obsoletos (archivo)
- staff-panel/ = mod Fabric COMPILADO /staff
- latamrust-knowledge/ = documentacion ACTIVA (repo de conocimiento)
- claimblocks-analysis/ = analisis pendiente (ClaimBlocks vs FTB Chunks)
- easy-npc-skins/ = assets listos (skins NPCs por tipo de mob)
- scripts/ = utilidades activas (chunky-auto-switch.sh)
- pack-temp/ = temporal (workspace empaquetado modpack)
- mensajes/ = canal de comunicacion PC2 ↔ PC1

ARCHIVOS SUELTOS: LatamRust_Cobbleverso.exe (launcher v4.3.1 prod 24MB), LatamRust_Cobbleverso_v5.exe (experimental), cobbleverse-pack-v4.0.1.zip (modpack 1.8GB), portablemc.exe (7.8MB), fabric-installer.jar, mojang-mappings.txt, yarn.jar, loader-0.19.*.jar.

ESTADO SERVER 2026-08-07: Fabric Loader 0.19.3, Sponge-Mixin 0.17.3, launcher fabric-server-launch.jar 639B, RAM 10G-20G G1GC, MCSS configurado, 325 mods activos 0 errores fatales, RCON 25575, BlueMap 8101, game 55555.
