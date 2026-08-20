# Launcher testing - proceso, problemas comunes, soluciones

LAUNCHER TESTING - Proceso y problemas comunes

TESTING PROCESS:
1. Borrar %APPDATA%\LatamRust\ para fresh install
2. Ejecutar LatamRust_Cobbleverso.exe desde Desktop
3. Click INSTALAR -> espera a que termine
4. Verificar que aparezca '✓ INSTALADO'
5. Click JUGAR -> debe abrir Minecraft con Fabric
6. Entrar al server -> verificar que no hay kickeos

PROBLEMAS COMUNES Y SOLUCIONES:

1. 'Java no encontrado'
   - Causa: Java 21 no instalado en el sistema
   - Fix: Launcher debe descargar Java 21 automaticamente
   - Si falla: instalar Java 21 manualmente desde oracle.com

2. Boton INSTALAR no desaparece
   - Causa: _refresh() no se ejecuta despues de install
   - Fix: usar root.after(100, _refresh) con delay

3. JUEGAR abre Minecraft vanilla
   - Causa: installed() detecta Modrinth profile en vez de LatamRust
   - Fix: installed() solo verificar %APPDATA%\LatamRust\mods\

4. Skins no sincronizan
   - Causa: skins se copian a directorio incorrecto
   - Fix: copiar a %APPDATA%\LatamRust\config\easy_npc\skin\
   - Tambien copiar a Modrinth profile si existe

5. Anticheat kickea jugadores
   - Causa: allowed_mods incompleto en .config
   - Fix: agregar TODOS los mods del cliente al .config
   - Importante: el mod lee de .config, NO de .json
