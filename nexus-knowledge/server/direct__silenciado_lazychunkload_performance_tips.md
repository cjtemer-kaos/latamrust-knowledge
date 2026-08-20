# Direct: Silenciado LazyChunkLoad performance_tips

Category: Server
Tags: lazychunkload, consola, silenciar
Created: 2026-08-20T12:57:55.579957

---

SILENCIADO LazyChunkLoad consola LATAMRUST (2026-08-20): el spam '[LazyChunkLoad] Tick:... CPU:MSPT...' era generado por la opción 'performance_tips: true' de la config lazychunkload.json (segun doc del mod: 'Output debug log when CPU or MSPT exceeds threshold'). Cambiado performance_tips a false -> deja de imprimir el status periodico en consola, el mod SIGUE optimizando. Se aplica al recargar config/reiniciar. La opcion log_loading ya estaba false. Config doc completa del mod en modrinth lazy-chunk-load: opciones cpu_threshold, warmup_ticks, preload_*, limit_enabled, tips_disabled, etc.
