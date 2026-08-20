# Human Layer — implementacion nivel 3 (evaluador)

evaluate_naturalness() en src/core/human_layer.py. Evalua 5 metricas: bridge phrases, transiciones formales, diversidad de longitud de oraciones, uniformidad de inicio, ratio de contracciones. Score 0-100. Si score < 60, se registra feedback en el resultado. Integrado en el pipeline del Director.
