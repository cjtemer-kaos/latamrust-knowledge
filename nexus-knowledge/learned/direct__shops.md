# Direct: shops

Category: Learned
Tags: shops-panel, cobbledollars, fabric-mod
Created: 2026-08-17T23:15:55.167560

---

Shops panel detecta CobbleDollars real correctamente. PITFALL: la fila superior (slots 0-8) de la GUI para agregar item debe quedar VACIA (sin GRAY_STAINED_GLASS_PANE de relleno). Si se rellena con vidrio, representative()/totalStock() leen slots 0-8, encuentran el vidrio como item no vacio y guardan el vidrio en vez del item real (comprador recibe vidrio aunque el pago sea correcto). Serializar el ItemStack COMPLETO con su Codec + RegistryOps del server (server.getRegistryManager().getOps(JsonOps.INSTANCE)) para que items de mods (Cobblemon: especies, NBT, encantamientos, custom name) no se pierdan. El mod original Snurbo solo guardaba item_id + item_count (perdia el NBT).
