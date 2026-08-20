# Direct: cobblemon-assets

Category: Minecraft
Tags: cobblemon, blockbench, assets, variants, datapack, resourcepack, shiny
Created: 2026-08-20T13:21:33.117049

---

Assets y variantes para Pokemon custom en Cobblemon: la estructura de un addon es assets/<namespace>/textures/pokemon/<pokemon>/ para las texturas normales (<pokemon>.png) y shiny (<pokemon>_shiny.png); models en formato Blockbench .geo.json; ademas animaciones, posers y resolvers. Las variantes se definen con 'aspects' dentro del archivo de especie/asset: el aspecto 'shiny' cambia a la textura shiny, y se pueden crear aspectos custom (ej. 'mischief') que cambian el modelo o aplican textura emissive. El pack se empaqueta en .zip con data/, assets/, pack.mcmeta y pack.png en la raiz (Minecraft solo lee 1 carpeta de profundidad para pack.mcmeta). Para servidores: el zip va en la carpeta datapacks del mundo del servidor y CADA jugador debe colocarlo en su carpeta resourcepacks. Los datapacks tambien pueden definir spawn detail presets, fossils, move effects y formas regionales.
