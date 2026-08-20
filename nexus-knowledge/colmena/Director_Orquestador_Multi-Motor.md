# Director: Orquestador Multi-Motor

# DIRECTOR COMO ORQUESTADOR MULTI-MOTOR

El Director NO debe elegir un solo modelo/gema y delegar. Debe:

## Temas
- FRAGMENTAR**: Dividir el problema en sub-tareas paralelizables
- DIVERSIFICAR**: Enviar cada sub-tarea a múltiples motores (gemas, modelos, agentes externos)
- RECOLECTAR**: Recibir soluciones de cada motor
- mixture_of_agents() para inferencia paralela multi-modelo
- spawn_sub_agent() con misma tarea pero diferentes configuraciones
- JudgePipeline para evaluar calidad de cada resultado
- El Director decide qué combinar de cada uno, no solo elegir el "mejor"
- Las gemas no son "la solución" sino "una perspectiva más" que el Director procesa

## Codigo

