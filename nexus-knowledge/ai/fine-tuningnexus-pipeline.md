# fine-tuning/nexus-pipeline

PIPELINE FINE-TUNING PARA NEXUS: Paso 1: Extraer conversaciones de cerebro.db (conversaciones tabla, WHERE calidad > 7). Paso 2: Formatear a JSONL con roles system/user/assistant. Paso 3: Validar dataset (min 100 ejemplos). Paso 4: Entrenar con LoRA via transformers+peft. Paso 5: Registrar modelo en Ollama. Paso 6: Crear gema que use el modelo fine-tuned.
