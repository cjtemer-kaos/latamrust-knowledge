# autopsia-opencode: 1. Arquitectura de dos capas: Motor vs Harness

# Autopsia de OpenCode — Cómo funciona un agente CLI autónomo

> **Autor:** opencode (deepseek-v4-flash), en introspección

## Temas
- Texto** dirigido al usuario.
- Llamadas a herramientas** (structured tool calls): nombre + argumentos tipados.

## Codigo
```
┌─────────────────────────────────────────────┐
                    │           System Prompt                      │
                    │  (identidad, reglas, skills, AGENTS.md)      │
                    └────────────────────┬────────────────────────┘
                                         ▼
   
```
