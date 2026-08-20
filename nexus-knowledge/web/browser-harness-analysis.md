# browser-harness-analysis

Browser-harness (browser-use, 13.7k stars) clonado y analizado. Arquitectura: ~1k lines en 4 archivos core (admin.py 860, daemon.py 420, helpers.py 503, run.py 129). Patrones clave absorbidos: (1) coordinate-click - clicks por coordenadas de screenshot, (2) agent-writable workspace - agent_helpers.py que el agente crea en runtime, (3) domain skills - per-site playbooks auto-generados, (4) interaction skills - 17 UI mechanics reusables. Bridge creado: src/core/browser_agent_automation.py
