# GitHub Releases - workflow para actualizar modpack, skins, launcher

GITHUB RELEASES - Workflow para actualizar modpack

REPOS:
- cjtemer-kaos/cobbleverse-pack: modpack + skins
- cjtemer-kaos/cobbleverse-launcher-v2: launcher fuente
- cjtemer-kaos/supernexus-hermes-config: guia configuracion

RELEASES cobbleverse-pack:
- v4.0.1: cobbleverse-v401.zip (1787MB, modpack completo)
- skins-v1: cobbleverse-skins.zip (106KB, 325 skins)

PARA ACTUALIZAR MODPACK:
1. Crear ZIP con todos los archivos del profile Modrinth
2. Subir a GitHub Release: gh release create v4.0.2 cobbleverse.zip --repo cjtemer-kaos/cobbleverse-pack
3. Actualizar Google Drive ID si se usa Google Drive
4. Los jugadores abren launcher -> update -> skins se sincronizan

PARA ACTUALIZAR SKINS:
1. Ejecutar python sync_skins.py en PC1
2. Subir cobbleverse-skins.zip a GitHub Release skins-v1
3. Los jugadores abren launcher -> JUGAR -> skins se sincronizan

PARA ACTUALIZAR LAUNCHER:
1. Modificar codigo fuente en D:\ias\proyectos\cobbleverse-launcher-v2\
2. Compilar: python -m PyInstaller --onefile --windowed --name LatamRust_Cobbleverso main_v5.py
3. Copiar exe a \\PC2-NEXUS\share\ y a GitHub Releases
4. Los jugadores descargan nuevo exe
