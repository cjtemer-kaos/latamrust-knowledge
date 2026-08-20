# Direct: minecraft/fabric/1.21.1/cobbledollars

Category: Config
Tags: cobblemon, fabric, 1.21.1, cobbledollars, economia, shops
Created: 2026-08-20T13:36:09.524282

---

CobbleDollars (Hazuriel) addon de economia para Cobblemon Fabric 1.21.1 (verificado en CurseForge): requiere Fabric API + Cobblemon (Architectury solo en <=1.5.2; en 2.x no). Config en config/cobbledollars/. Formato activo 2.x: defaultShop es un array de categorias -> cada una un objeto { categoria: [ { item, price } ] }, ej: poke balls: cobblemon:poke_ball a 2000; los items pueden venir de otros mods (create:cogwheel). Bank: banco de cambio con array bank [{ item, price }], ej. minecraft:emerald=500, cobblemon:red_apricorn=2500. Version 1.5.x usaba merchantShop { balls:{}, items:{} } y bankItems {}. Se puede anadir dinero desde comandos (/cobbledollars o el nodo de pais) y los jugadores pagar a NPC merchants. Getter de cobbledollars al capturar/batallar.
