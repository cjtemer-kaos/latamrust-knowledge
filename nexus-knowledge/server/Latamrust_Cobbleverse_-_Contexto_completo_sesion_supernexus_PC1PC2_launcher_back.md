# Latamrust Cobbleverse - Contexto completo sesion supernexus (PC1/PC2, launcher, backend, auth)

CONTEXTO SESION 'supernexus' (20260711_135528_51accb) - 877+ acciones documentadas.

PROYECTO: 'Latamrust Cobbleverse' - launcher custom standalone que incluye MC 1.21.1 + Fabric 0.18.4 + Cobblemon 1.7.3.

PC1 (192.168.1.4): Estacion de desarrollo. Hermes activo. LatamRust online:9001. HTTP server:8888.
PC2 (192.168.1.16): Servidor principal. Windows PC2-NEXUS. SSH user cjtr.

COMPLETADO:
- CobbleVerse server copiado a PC2 D:\SERVIDOR\ (1.3GB, 3638 archivos)
- latamrust-nexus copiado a PC2 D:\ias\proyectos\latamrust-nexus\ (5.7GB, 9537 archivos)
- Python venv creado en PC2 con todas las dependencias
- Hermes config en PC2 con MCP bridge apuntando a latamrust-nexus
- mcp_bridge_wrapper.py transferido a PC2
- __init__.py creados en todo src/
- Auth server (auth_server.py) copiado a PC2, apunta a 192.168.1.16:9002
- Login UI creada: login.ejs, login.css, login_handler.js, cobbleverse_auth.js

BLOQUEADO:
1. Backend LatamRust en PC2: ModuleNotFoundError 'No module named src'. Fix: sys.path.insert(0, 'D:\\ias\\proyectos\\latamrust-nexus') en start_server.py
2. Launcher Latamrust Cobbleverse: NO INICIADO. Requiere fork Helios/Zeventy + distribution.json con MC assets en GitHub.
3. LuckPerms: Solo grupo default. Comandos /lp no funcionan por RCON. Fix: usar /lp desde chat in-game como OP.

ARCHIVOS CLAVE:
- D:\ias\proyectos\cobbleverse-launcher\server\auth_server.py (auth server, 16KB)
- D:\ias\proyectos\cobbleverse-launcher\app\assets\js\cobbleverse_auth.js (cliente auth)
- D:\ias\proyectos\cobbleverse-launcher\app\login.ejs (UI login)
- D:\ias\proyectos\cobbleverse-launcher\app\assets\css\login.css (estilos login)
- D:\ias\proyectos\cobbleverse-launcher\app\assets\js\login_handler.js (handler login)
- D:\ias\proyectos\cobbleverse-launcher\distribution.json (pendiente)

SERVER CONFIG: Fabric 0.18.4, MC 1.21.1, Cobblemon 1.7.3, Java 21, offline-mode=true, puerto 55555, RCON 25575 pw:cobbleverse2026.

METODO TRANSFERENCIA: SMB robocopy para bulk. HTTP :8888 para archivos individuales.

La sesion exploto por Context length exceeded (177K tokens). La sesion esta stuck pero los datos no se perdieron - estan en esta nota del brain.
