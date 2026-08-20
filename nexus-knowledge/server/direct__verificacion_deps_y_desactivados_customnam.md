# Direct: Verificacion deps y desactivados CustomNameTags

Category: Server
Tags: deps, customnametags, polymer, verificacion
Created: 2026-08-20T12:29:20.765438

---

VERIFICACION deps mods nuevos LATAMRUST (2026-08-20): revisado todos los fabric.mod.json. CustomNameTags (CustomNameTags-0.3.6) requería 'fabric-permissions-api-v0' que NO esta en el server ni en maven fabric (no es modulo estandar de fabric-api; el bundle 0.116.14 no lo incluye) -> no cargaria. DECISION: desactivados CustomNameTags + Polymer (ambos .disabled) para no romper el arranque, ya que no son necesarios (ya tenemos Custom Names + FTB Teams Nametag v3 para nametags). Resist de los demas mods nuevos: deps OK (chunkactivitytracker esta con id correcto; polymer-core/virtual-entity en polymer-bundled OK; fabric api, kotlin, placeholder-api, cobblemon, ftbteams OK). Pendiente arrancar.
