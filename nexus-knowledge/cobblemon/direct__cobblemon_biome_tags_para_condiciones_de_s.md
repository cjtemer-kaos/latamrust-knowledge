# Direct: Cobblemon biome tags para condiciones de spawn

Category: Cobblemon
Tags: direct-learned
Created: 2026-08-20T15:16:32.735007

---

Cobblemon define tags de bioma (#cobblemon:) para configurar condiciones de spawn en data packs (fuente: gitlab.com/cable-mc/cobblemon docs/cobblemon-tags). is_cold = biomas 'frios' sin importar dimension, incluye End y biomas sin nieve (usar como anti-condicion, NO como condicion primaria). is_forest y is_snowy_forest NO incluyen biomas Taiga. is_hills e is_peak son subconjuntos de is_mountain (is_hills=montanas suaves, is_peak=montanas extremas). is_sky = biomas con islas flotantes (no el aire sobre otros biomas). is_mushroom = biomas con muchos hongos. is_glacial = biomas con mucho hielo (no solo nieve). is_beach = costas arenosas vs is_coast = cualquier costa oceánica vs is_sandy (separado de is_beach). is_island = islas de oceano vs is_tropical_island = tropicales. is_thermal = geotermales (aguas termales, sin lava) vs is_volcanic = con lagos/flujos de lava. Existen tags #cobblemon/nether:is_[name] para el Nether y #cobblemon/has_block:[name] para biomas con bloques especificos (menos compatibles con mods de biomas).
