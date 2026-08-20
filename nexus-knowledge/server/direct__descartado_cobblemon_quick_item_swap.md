# Direct: Descartado Cobblemon Quick Item Swap

Category: Server
Tags: cobblemon, itemswap, descartado, client
Created: 2026-08-20T12:21:19.626325

---

DESCARTADO Cobblemon Quick Item Swap (cobblemon-quick-item-switcher). Analizado el codigo del desarrollador (github domanhthang2110/cobblemon-quick-item-switcher): la feature depende del CLIENTE. src/client/java tiene PcGuiMixin, StorageWidgetMixin, PcInventoryOverlay (modifican la GUI de la PC), CobblemonQuickItemSwitcherClient usa ClientPlayNetworking + ScreenEvents + PCGUI. El servidor solo recibe payloads de clicks; SIN el mod en el cliente del jugador la interfaz/boton de la PC no existe. NO funciona 100% server-side -> descartado por regla '100% server-side NUNCA tocar mods de jugadores'.
