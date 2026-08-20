# Direct: Fabric 1.21.1: crear un proyecto de mod

Category: Fabric
Tags: direct-learned
Created: 2026-08-20T17:17:48.675995

---

Para crear un mod Fabric usar el Fabric Template Mod Generator (fabricmc.net/develop/template) o clonar fabric-example-mod (git clone https://github.com/FabricMC/fabric-example-mod.git). Campos: mod name, package name (minusculas, separado por puntos, unico, formato dominio invertido ej com.example.example-mod) y Minecraft version (1.21.1 disponible). Reglas de ruta del proyecto: evitar carpetas cloud (OneDrive), evitar caracteres no-ASCII (emojis/acentos) y espacios; ej bueno C:\Projects\NombreMod. En Advanced Options se puede activar Kotlin, Kotlin buildscripts o data generators. Reemplazar 'example-mod' por tu mod ID en todo (ej resources/assets/mi-mod). Los ejemplos de la doc usan nombres unobfuscados de Mojang (mappings oficiales). Fuente: docs.fabricmc.net/develop
