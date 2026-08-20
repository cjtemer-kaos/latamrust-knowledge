# react-testing-pitfall

PITFALL: React controlled components + browser automation. El browser_type y browser_press de Hermes NO disparan onChange/onKeyDown de React. Para testing de UI React, usar agent-cu (Electron) o curl al API directamente. Nunca concluir que "no funciona" basándose solo en browser testing de React controlled inputs.
