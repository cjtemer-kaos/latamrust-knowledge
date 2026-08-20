# Direct: minecraft-server-1.21.1-datapacks-functions

Category: Minecraft
Tags: minecraft, 1.21.1, datapack, functions, pack_format, pack.mcmeta, tags
Created: 2026-08-20T13:46:03.202523

---

Datapacks y functions en 1.21.1: pack.mcmeta con pack_format 48 (1.21-1.21.1). Estructura data/<namespace>/<tipo>/<path>.json y functions como data/<namespace>/function/<path>.mcfunction. Desde 24w21a (1.21) las carpetas son SINGULAR: function (no functions), loot_table, recipe, advancement, predicate, item_modifier, structure, tags/item, tags/block, tags/function, etc. Los datapacks del server van en world/datapacks/ (o carpetas validas); orden de carga guardado en level.dat tag DataPacks (Enabled/Disabled, default 'vanilla'). /reload recarga funciones/tags/loot_tables/recipes/advancements (otros requieren reinicio). Tags de funcion: #minecraft:tick corre al inicio de cada tick, #minecraft:load corre una vez al (re)cargar. 1.21 agrego encantamientos data-driven (data/minecraft/enchantment). Las definiciones vanilla viven en un datapack built-in 'vanilla'. El datapack 'vanilla' se puede listar/editar con /datapack. Fuente: minecraft.wiki/w/Data_Pack + Pack_format (verificado).
