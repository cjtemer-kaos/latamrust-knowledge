# vision_model_routing_fix

Claude repaired an error where "image.png" was passed to a non-vision model (qwen2.5-coder:7b or deepseek-r1:8b), causing Ollama error "Cannot read 'image.png' (this model does not support image input)". The fix ensures images are only routed to vision-capable models (qwen2.5vl:7b, qwen2.5vl:2b) and the model selection checks supports_vision flag before sending.
