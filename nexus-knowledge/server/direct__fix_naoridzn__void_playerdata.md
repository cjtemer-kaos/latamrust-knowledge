# Direct: FIX NaoriDZN_ void playerdata

Category: Server
Tags: fix, void, playerdata, nbtlib, respawn
Created: 2026-08-19T23:36:52.643446

---

FIX NaoriDZN_ atrapado en looap y=void (2026-08-20): NaoriDZN_ (uuid 71dfa362) murio en el void (Y=-12 en 18500,29934) y su Pos quedo Y=-11.7 -> al entrar el server no podia colocarlo ('Couldn't place player in world', StacklessClosedChannel) -> loop de entrar/expulsar (disconnects repetidos 23:26-23:29). FIX (con server parado): edite world/playerdata/71dfa362...dat con nbtlib: Pos de [18502.5,-11.7,29931.4] a [18502.5,70.0,29931.4] (Y=70 segura). Backup: playerdata/71dfa362...dat.bak-fix-033554. Verificado. Chunk r.36.58.mca existe. Universal-Graves: NaoriDZN_ tiene LastGraveId=40 + HasGraveCompass. Pendiente: usuario inicia server y NaoriDZN_ deberia entrar normal. Si el problema es la tumba (grave 40) al recuperar items, puede estar en (18500,-12,29934) en el void.
