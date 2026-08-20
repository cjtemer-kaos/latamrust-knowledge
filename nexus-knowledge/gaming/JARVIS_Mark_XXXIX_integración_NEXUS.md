# JARVIS Mark XXXIX integración NEXUS

JARVIS Mark XXXIX es la interfaz de voz de SuperNEXUS. Corre en D:\ias\autopsia\Mark-XXXIX. Usa qwen2.5-coder:7b via Ollama directo (no Director para chat). TTS/STT via Director :9000. API propia en puerto 9039: POST /command para enviar órdenes desde cualquier nodo de la colmena, POST /speak para TTS directo, GET /status. UI PyQt6 con PTT spacebar. 20 action tools (file_controller, open_app, browser_control, web_search, etc). Commit 5845f89.
