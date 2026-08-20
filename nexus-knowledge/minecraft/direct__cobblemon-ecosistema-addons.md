# Direct: cobblemon-ecosistema-addons

Category: Minecraft
Tags: cobblemon, addons, architectury, fabric, gradle, modrimputation-curseforge, kotlin
Created: 2026-08-20T13:21:50.233233

---

Ecosistema de addons/desarrollo para Cobblemon 1.21.1: ejemplos verificados son Cobblemon Trainer Prestige (sistema de titulos con GUI /prestige, rarezas, auto-equip, titulos por legendary/mythical/ultra-beast, MIT) y Cobblemon Expanded Configs (editor in-game con /cec, perfiles, overrides por mundo/bioma/especie/jugador; requiere Fabric API en Fabric). El desarrollo de mods addon es multiplataforma con Architectury (modulos common/fabric/neoforge) y Gradle Loom; para depender del Cobblemon de CurseForge se usa curse.maven (modImplementation 'curse.maven:cobblemon-687131:<fileId>'). El proyecto upstream usa Fabric API 0.116.0+1.21.1 como version de prueba. Requisitos de dependencia de un addon Fabric tipico para 1.21.1: Fabric Loader + Fabric API + Fabric Language Kotlin; en NeoForge: NeoForge + Kotlin for Forge. Hosting del codigo: gitlab.com/cable-mc/cobblemon (cable-mc/Cobblemon).
