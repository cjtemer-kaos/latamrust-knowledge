# Easy NPC mod - codigo fuente, archivos modificados, build status

EASY NPC MOD - Codigo fuente y modificaciones

REPO: github.com/MarkusBordihn/BOs-Easy-NPC
RAMAS: 1.20.1 (default), 1.21.1 (la que usamos)
LICENCIA: MIT

ESTRUCTURA:
- core/Common: Modulo base (SkinDataEntry, CustomTextureManager, etc.)
- core/Fabric: Version Fabric del core
- config-ui: UI de configuracion
- bundle: Package final

ARCHIVOS MODIFICADOS (pendientes de build):
1. core/Common/.../SkinDataEntry.java
   - Agregado: getSkinContentAsBytes() - decodifica Base64
   - Agregado: fromPNGBytes() - crea SkinDataEntry desde bytes PNG

2. core/Common/.../handler/SkinHandler.java
   - Agregado: encodeCustomSkinContent() - codifica PNG a Base64
   - Agregado: findSkinFile() - busca archivo PNG por UUID
   - Modificado: setSkin() - codifica CUSTOM skins automaticamente

3. core/Common/.../client/texture/CustomTextureManager.java
   - Agregado: decodificacion Base64 en createTexture()
   - Si skin tiene content Base64, crea textura en memoria

BUILD:
- Rama: 1.21.1 (ya clonada en D:\ias\proyectos\BOs-Easy-NPC)
- Java: 21 (configurado en bundle/build.gradle)
- Problema: dependencias circulares (bundle/Fabric necesita config-ui)
- Common SII compila (easy_npc-common-1.21.1-7.5.0.jar)
- Fabric falla por dependencia config-ui
