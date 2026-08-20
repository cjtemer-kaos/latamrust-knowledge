# Direct: control_remoto_mcss_panel

Category: Learned
Tags: direct-learned
Created: 2026-08-15T19:42:01.643896

---

Server LATAMRUST COBBLEMON se controla via panel web MCSS HTTPS 127.0.0.1:25560. POST /auth {username:KAOS__MCS,password:nacional09} -> apiKey en header. Comando: POST /api/v2/servers/6251f053-d12f-44e9-b97a-38dd98d2bb67/execute/command {command:...}. Consola: GET /api/v2/servers/{id}/console?amountOfLines=40&reversed=true. RCON server.properties no funciona. Panel no refresca consola en tiempo real, usar logs/latest.log. Script mcss_console.py en D:/ias/proyectos.
