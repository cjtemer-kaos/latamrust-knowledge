# Easy NPC Skins - sistema completo, 2 metodos, scripts, mod pendiente

EASY NPC SKINS - Sistema completo de sincronizacion

PROBLEMA: Admin crea NPC con skin custom -> otros jugadores no la ven -> errores en chat

SOLUCION 2 METODOS:
1. Launcher Method: Sincronizar skins via GitHub release
2. Online Method: Modificar mod para enviar skins via SynchedEntityData (pendiente)

LAUNCHER METHOD (implementado):
- Server: D:\SERVIDOR\servers\LATAMRUST COBBLEMON\config\easy_npc\skin\
- GitHub: release skins-v1 (325 skins, 106KB)
- Client: %APPDATA%\LatamRust\config\easy_npc\skin\
- Script: sync_skins.py (copia TODO del server a GitHub)
- Launcher descarga skins en INSTALAR y en JUGAR

SKINS CREADAS:
- 296 templates para 38 tipos de NPC (generate_skins.py)
- 29 skins Pokemon tematicas (generate_pokemon_skins.py)
- Total: 325 skins en release skins-v1

ONLINE METHOD (pendiente - requiere Gradle build):
- Modificar SkinDataEntry.java: agregar getSkinContentAsBytes()
- Modificar CustomTextureManager.java: decodificar Base64
- Modificar SkinHandler.java: codificar PNG a Base64 al guardar
- BOs-Easy-NPC clonado en D:\ias\proyectos\BOs-Easy-NPC (rama 1.21.1)
- Build falla por dependencias circulares (config-ui ↔ Easy NPC)
