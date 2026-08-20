# autopsia-opencode: 2. El loop agéntico (el corazón)

# 2. El loop agéntico (el corazón)

2. RAZONAR    → el motor decide: ¿respondo, o uso una herramienta?

## Temas
- El loop agéntico (el corazón)
- PERCIBIR   → recibir entrada (usuario o resultado de tool)
- RAZONAR    → el motor decide: ¿respondo, o uso una herramienta?
- ACTUAR     → si decide tool: ejecutarla (una o varias en paralelo)
- Tool calls** → una o más llamadas a herramientas. El harness las ejecuta (muchas veces
- Texto final** → la respuesta para el usuario. El loop termina.
- Múltiples tools en paralelo** cuando son independientes (leer 3 archivos no relacionados,
- Una tool a la vez** cuando hay dependencia secuencial (leer un archivo para saber qué

## Codigo
```
1. PERCIBIR   → recibir entrada (usuario o resultado de tool)
2. RAZONAR    → el motor decide: ¿respondo, o uso una herramienta?
3. ACTUAR     → si decide tool: ejecutarla (una o varias en paralelo)
4. OBSERVAR   → inyectar el resultado de la tool al contexto
5. REPETIR    → volver a 2 con el contex
```

```
1. LEER → archivos relevantes (los que menciona el usuario + los que encuentro buscando)
2. BUSCAR → grep/glob para encontrar todo lo relacionado
3. ENTENDER → proceso lo que leí
4. PLANEAR → decido qué cambiar exactamente
5. EJECUTAR → hago los cambios (edit/write)
6. VERIFICAR → ejecuto tests/lint
```
