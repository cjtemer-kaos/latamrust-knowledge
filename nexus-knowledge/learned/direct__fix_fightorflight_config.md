# Direct: fix_fightorflight_config

Category: Learned
Tags: direct-learned
Created: 2026-08-15T20:03:23.671005

---

Reparado aggressive_biome en config/fightorflight.json5 del server LATAMRUST: tenia entradas corruptas ["", "minecraft", ":deep_dark", ""] -> corregido a ["minecraft:deep_dark"]. Nota: el mod lee el config al arranque (Cloth AutoConfig, sin comando reload) — el fix aplica en el proximo reinicio via MCSS, NO reiniciar con jugadores online. El mod ya estaba en ultima version 0.10.9.
