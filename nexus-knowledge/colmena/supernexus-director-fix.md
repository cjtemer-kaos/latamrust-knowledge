# supernexus-director-fix

FIX: Director deliraba buscando en web para preguntas simples. Causa: keywords conversacionales insuficientes en src/core/director.py línea 738-744. La heurística _conversational_kw determina si una pregunta necesita web research. Fix: agregar "funcionas", "funciona", "sirve", "sirves", "trabajas", "trabaja", "estas bien", "eres real", "soy tu", "que opinion", "gracias", "por favor", "dale", "sigue", "para" a la lista. Para agregar más keywords en futuro: editar _conversational_kw en director.py y reiniciar el servidor Python.
