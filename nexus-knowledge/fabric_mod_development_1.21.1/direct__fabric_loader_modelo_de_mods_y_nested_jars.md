# Direct: Fabric Loader modelo de mods y nested JARs

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:38:05.330488

---

Fabric Loader define un mod como un JAR con fabric.mod.json en su raiz que declara id, version, entrypoints y configuraciones de mixin. Puede declarar dependencias (depends) o conflictos; Loader intenta resolverlas y si no puede, el juego no arranca. Los nested JARs (jar-in-jar, via la opcion include de Loom) dejan que un mod empaquete sus propias dependencias y Loader elige la mejor version. La carpeta de mods se cambia con la system property fabric.modsFolder. API util: FabricLoader.getInstance().isModLoaded(id). Fuente: docs.fabricmc.net/develop/loader.
