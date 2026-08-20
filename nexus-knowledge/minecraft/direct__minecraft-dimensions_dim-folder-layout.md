# Direct: minecraft-dimensions/dim-folder-layout

Category: Minecraft
Tags: minecraft, dimensions, overworld, nether, end, DIM-1, DIM1
Created: 2026-08-20T13:35:39.185965

---

LOGICA INTERNA Minecraft Server 1.21 - Dimensiones: un server vanilla carga Overworld=world (region/), Nether=world/DIM-1 y End=world/DIM1 cuando level-name apunta a una sola carpeta; en Paper/Spigot/Bukkit se separan en 3 mundos raiz: world (o el nombre de level-name), world_nether y world_the_end, cada uno con su propio level.dat. Desde 1.16 las dimensiones son data-driven: se definen en datapacks via registries dimension y dimension_type en data/<ns>/dimension/*.json y data/<ns>/dimension_type/*.json (min/max Y, respawn allowed, effects=overworld/the_nether/the_end, natural, piglin safe, skylight, coordinate_scale). El layout DIM-1/DIM1 es el de 1.21.1 (solo versiones 26.1+ usan carpeta dimensions/). El Nether escala coordenadas 8:1 (mundo_overworld = mundo_nether * 8). El campo dimension del level.dat indica la dimension actual del mundo. Server 1.21 crea por defecto Overworld+Nether+End a partir de level-name.
