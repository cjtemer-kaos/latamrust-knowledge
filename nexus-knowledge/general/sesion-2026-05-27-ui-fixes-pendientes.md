# sesion-2026-05-27-ui-fixes-pendientes

# Sesion 27 Mayo 2026 - Estado UI y Pendientes

2. TTS: endpoint correcto /api/voice/speak con authFetch + return_audio, verificar que suene en browser

## Temas
- Chat doble mensaje: FIXED (dedup guard en appStore.ts + removed StrictMode)
- Director routing: FIXED (keywords gemas/activas/estado -> director, no ayuda)
- Logo KAOS_MCS: visible en sidebar con imagen
- WS handler: ejecuta tools via process_message (no solo Ollama)
- Tools sin Ollama: Director autosuficiente, list_dir/read_file funcionan sin LLM
- Path sandbox: FIXED en builtin.py (acepta paths absolutos)
- Modelo fallback: deepseek-r1:8b -> qwen2.5-coder:7b (menos restrictivo)
- System prompt Director: contexto real (37 tools, filesystem, proyecto)

## Codigo

