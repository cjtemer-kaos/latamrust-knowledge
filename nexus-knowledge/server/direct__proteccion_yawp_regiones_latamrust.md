# Direct: Proteccion YAWP regiones LATAMRUST

Category: Server
Tags: yawp, proteccion, latamrust, regiones, owners
Created: 2026-08-19T11:17:40.331511

---

Proteccion YAWP en LATAMRUST: para proteger zonas (aldea*, gym*, inv*) se edita world/data/yawp/minecraft_overworld.dat (NBT gzip) con SERVER DETENIDO (YAWP sobrescribe el .dat en caliente). A cada region se le aplica: (1) grupo owners compartido con los 6 admins (KAOS__MCS, Aryys, Leftor_, JONYmcs, JhonSai, Robben_), (2) set de 11 flags modelo spawn (break-blocks/place-blocks Denied = no romper/colocar; item-pickup/invincible/melee-animals Allowed; explosions/fire/mobs/fall-damage Denied). Los jugadores pueden abrir cofres e interactuar (use/access quedan por defecto). Round-trip NBT validado (parse->serialize->parse = byte identico). Ver skill yawp-region-protection. Zonas aplicadas 2026-08-18: aldeaa, aldea2..13, gym1..4, inv1, inv2.
