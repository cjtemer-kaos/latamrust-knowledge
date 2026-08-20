# Direct: cobblemon_species_forms_variations

Category: Cobblemon_ecosistema
Tags: direct-learned
Created: 2026-08-20T16:05:30.733658

---

Cobblemon: los archivos de FORMAS de especie (en /data/cobblemon/species_forms/ o junto a la especie) definen las variaciones visuales. Estructura: "species": "cobblemon:<nombre>", "order": 0 (orden de carga; 0 = forma base), "variations": [] con objetos por aspect. Cada variacion: "aspects": [] (ej. ["shiny"] para shiny, o aspects custom como ["mischief"]), "poser": "cobblemon:<nombre>", "model": "cobblemon:<nombre>.geo", "texture": "cobblemon:textures/pokemon/<nombre>/<nombre>.png", "layers": [] (texturas adicionales encima, ej. patron del pecho de Arbok). El nombre de archivo usa convencion <orden>_base (ej. 0_tentaquil_base.json) y 0_ = load order. Los models de Cobblemon son entidades de BEDROCK (mayor soporte de animaciones) aunque es mod de Java; se hacen con BlockBench. Un fich shiny apunta a <nombre>_shiny.png.
