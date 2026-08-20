# vtuber-ninja-research-consolidated

VTuber Ninja Avatar — Research Consolidated (2026-07-26):

**DECISIÓN: 3D (VRM) es el ganador para ninja enmascarado.**
- Live2D no funciona: necesita partes faciales visibles (boca, ojos separados)
- VRM soporta ojos brillantes emissivos + rotación 3D completa de cabeza/máscara

**Face Tracking para personaje enmascarado:**
- OpenSeeFace (1997★, Python, CPU) > MediaPipe para caras parcialmente cubiertas
- Más estable en baja luz, amplio rango de poses, usado por VSeeFace y VTube Studio
- Envía datos via UDP al renderer
- Solución: trackear cabeza (yaw/pitch/roll) + ojos through mask opening + voice-reactive mask

**Herramientas de creación (gratis):**
1. VRoid Studio (Steam) → VRM con blendshapes, rig, PBR materials
2. Blender + VRM Addon (1671★) → personalizar
3. CharacterStudio (305★, web) → drag-and-drop VRM

**Software de rendering (open source):**
1. VSeeFace (SDK 194★, Unity) → mejor calidad, usa OpenSeeFace
2. VMagicMirror (539★, Unity 6.3) → keyboard/mouse tracking, MIT
3. Vignette (525★, C#) → full VTuber software

**Pipeline recomendado para Kaos:**
1. VRoid Studio → crear avatar base ninja (anime/stylized)
2. Blender → agregar máscara, hood, armadura, lotus emblem
3. OpenSeeFace → face tracking via UDP
4. VSeeFace o VMagicMirror → rendering + streaming
5. OBS Browser Source → capturar output

**Key blendshapes ARKit (52):** jawOpen, eyeBlink, browInnerUp, mouthSmile, etc.

**Calidad del VRM depende de:** blendshapes correctos, rig humanoid, materiales PBR, física de pelo/ropa, polígonos 15k-50k.
