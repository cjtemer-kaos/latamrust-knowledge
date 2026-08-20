# director-v3-fix-merge-fp16-2026-05-27

## FIX CRITICO: QLoRA merge debe ser sobre fp16, NO sobre 4-bit

### Problema
merge_and_unload() sobre modelo cuantizado 4-bit causa errores de redondeo acumulativos. El modelo genera basura en GGUF/Ollama aunque funcione en transformers fp16.

### Solución aplicada en train_director_qlora.py
```python
# ANTES (MALO): AutoPeftModelForCausalLM re-carga en 4-bit
merged_model = AutoPeftModelForCausalLM.from_pretrained(lora_dir, ...)
merged_model = merged_model.merge_and_unload()  # merge sobre 4-bit = basura

# DESPUES (CORRECTO): Cargar base en fp16, aplicar LoRA, merge
del model; torch.cuda.empty_cache()
base_model_fp16 = AutoModelForCausalLM.from_pretrained(BASE_MODEL, torch_dtype=torch.float16, device_map="auto")
merged_model = PeftModel.from_pretrained(base_model_fp16, lora_dir)
merged_model = merged_model.merge_and_unload()  # merge sobre fp16 = correcto
```

### Pipeline completo verificado
1. Train QLoRA (4-bit base + LoRA) -> lora_adapters/
2. Merge: cargar base fp16 + aplicar LoRA + merge_and_unload -> merged_model_v2/
3. GGUF: python D:\ias\tools\llama.cpp\convert_hf_to_gguf.py merged_model_v2/ --outtype q8_0
4. Ollama: ollama create nexus-director-v3 -f Modelfile

### Estado actual nexus-director-v3
- merged_model_v2/ = merge correcto fp16
- GGUF: nexus-director-v3-fp16merge-q8.gguf (1.64GB Q8_0)
- Ollama: nexus-director-v3:latest FUNCIONA - respuestas coherentes
- Calidad: aceptable para 1.5B/192 ejemplos, no reemplaza gemma4 aún
- Pendiente: generar 1000+ ejemplos sintéticos y re-entrenar para mejorar
