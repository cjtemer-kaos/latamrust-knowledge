# Direct: Fabric Loom plugin IDs remap vs no-remap

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:37:37.159171

---

Fabric Loom es el plugin de Gradle para desarrollar mods Fabric. Tiene varios plugin IDs: net.fabricmc.fabric-loom (para versiones de Minecraft NO ofuscadas, 26.1 o posteriores), net.fabricmc.fabric-loom-remap (para versiones ofuscadas, 1.21.11 o anteriores) y fabric-loom (legacy, solo retrocompatibilidad). Loom instala Minecraft y los mods en el entorno de desarrollo, genera run configurations para Fabric Loader, procesa la compilacion de Mixins y maneja el sistema jar-in-jar (nested JARs). Es independiente de version: soporta versiones que Fabric API no soporta. Fuente: docs.fabricmc.net/develop/loom.
