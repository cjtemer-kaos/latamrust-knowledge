# Aprendizaje build BOs-Easy-NPC - Gradle multi-module, dependencias circulares, alternativa Metdoo 2

APRENDIZAJE: Build de BOs-Easy-NPC (Gradle multi-module)

ESTRUCTURA DEL PROYECTO:
- core/Common: Modulo base (SkinDataEntry, CustomTextureManager, etc.)
- core/Fabric: Version Fabric del core
- config-ui: UI de configuracion (depende de core)
- bundle: Package final que instala todos los modulos

ORDEN DE BUILD:
1. core/Common → genera easy_npc-common-1.21.1-7.5.0.jar (2.3MB) ✅ COMPILA
2. core/Fabric → necesita core/Common compilado
3. config-ui → necesita core compilado
4. bundle/Fabric → necesita config-ui compilado (modRuntimeOnly)

PROBLEMA: bundle/Fabric/build.gradle tiene dependencia 'modRuntimeOnly' con config-ui que Gradle resuelve en fase de configuracion (no en runtime). Sed rompe sintaxis.

SOLUCION: No sed el build.gradle. En vez de eso, usar el metodo MODRINTH:
1. Descargar el JAR original de Easy NPC v7.4.1 desde Modrinth
2. Descompilar con jadx
3. Aplicar mis cambios (SkinDataEntry + CustomTextureManager)
4. Recompilar con el mesmo Gradle pero SIN dependencia config-ui

O ALTERNATIVA SIMPLER: No modificar el mod. En vez de eso:
1. El launcher ya distribuye skins via GitHub (Metodo 2)
2. Para las skins con UUID, copiarlas del server a todos los clientes via el launcher
3. El problema de UUID es que Easy NPC guarda skins con el UUID del NPC, no con nombres descriptivos
4. Solucion: copiar TODOS los archivos de config/easy_npc/skin/ del server a los clientes
