# claude_code_opencode_go_setup

# Claude Code CLI + OpenCode Go Proxy — Setup verificado

2. Los shortcuts de desktop (`Claude (OpenCode Go).lnk`, `OpenCode Go Proxy.lnk`) apuntaban a scripts .vbs intermedios

## Temas
- `C:\Users\cjtr\.local\bin\claude-oc.ps1` — wrapper PowerShell que arranca proxy si no está, setea env vars, llama claude
- `C:\Users\cjtr\.local\bin\claude-oc.cmd` — wrapper .cmd que delega a .ps1 (preserva args correctamente)
- `C:\Users\cjtr\Desktop\Claude Code (OpenCode Go).lnk` — acceso directo de un click
- `C:\Users\cjtr\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\start-oc-go-cc.lnk` — autostart al logon
- `C:\Users\cjtr\.config\oc-go-cc\config.json` — API key en plaintext (RIESGO), 6 model presets, default `kimi-k2.6`
- Bug fix aplicado:** `qwen3.5-plus` (no existe) → `qwen3.6-plus` en línea 21
- Proxy escucha `127.0.0.1:3456`, timeout 300s
- `ANTHROPIC_BASE_URL=http://127.0.0.1:3456`

## Codigo

