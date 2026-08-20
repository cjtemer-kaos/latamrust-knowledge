# fine-tuning/lora-qlora

LoRA (Low-Rank Adaptation) entrena solo una pequena parte del modelo: memoria 4-8GB en vez de 80GB, tiempo horas en vez de dias, GPU consumer vs cluster. QLoRA cuantiza a 4-bit ahorrando 75% memoria. LoRA rank recomendado: 8-64. Target modules: q_proj, v_proj, k_proj, o_proj.
