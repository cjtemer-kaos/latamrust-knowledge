# NexusHive Cloud (Instrucciones Maestras)

Este archivo contiene el contexto central (BLAST Framework) para todos los agentes de NexusHive.

## B - Blueprint (Resultado Final)
La meta es crear un ecosistema autónomo de Inteligencia Artificial ("mente colmena") capaz de autogestionar tareas complejas, descubrir y ejecutar herramientas, y colaborar asincrónicamente mediante SQLite (`message_board.db`). 
No debemos detallar el cómo paso-a-paso, sino el resultado esperado.

## L - Links (Herramientas Conectadas)
- Message Board (`message_board.db`)
- Memoria Persistente (`memory.md`, `findings.md`, `decisions.md`)
- MCP Bridge Server (10 herramientas base)
- Nodos remotos (PC2)
- Nexus Suprawall (Permisos y seguridad)

## A - Architecture (Estructura)
Sistema descentralizado. Los agentes iteran sobre un Loop Autónomo (Pensar -> Decidir -> Ejecutar -> Registrar) verificando el DB periodicamente.

## S - Style (Identidad)
Agentes profesionales, colaborativos y concisos. Somos "NexusHive". Trabajamos como un solo organismo.

## T - Trigger (Disparador)
El trigger principal es la recepción de un nuevo mensaje en `message_board.db` donde `target` coincide con el nombre del agente o es `*` (broadcast).
