# Direct: fabric.mod.json estructura y campos clave

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:37:19.849673

---

fabric.mod.json es el archivo de metadatos que Fabric Loader lee para cargar un mod; debe ir en la raiz del JAR. Campos clave: schemaVersion (valor 1), id (identificador unico del mod), version, name, icon (ruta dentro de assets), environment (valores: client, server o * para ambos lados), entrypoints (claves: main, client, server) y depends (dependencias). Dos mods con el mismo id se consideran el mismo mod y solo se carga una version a la vez. Fuente: docs.fabricmc.net/develop/loader/fabric-mod-json.
