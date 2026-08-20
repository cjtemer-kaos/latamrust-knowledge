# Direct: servidor_produccion_cloud

Category: Learned
Tags: direct-learned
Created: 2026-07-31T12:58:05.926130

---

El servidor MC se alojará en la nube tras desarrollo. Configuración RCON en data/minecraft_servers.json soporta host/puerto configurables. Cliente RCON de Nexus ya soporta conexiones remotas (no solo localhost). El cliente Electron debe conectar al backend local (puerto 9001) que a su vez conecta al server MC via RCON (host configurable).
