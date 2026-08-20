# vtuber-architecture-research

VTuber Architecture Research (2026-07-26):

**STACK COMÚN de software VTuber profesional:**
- Motor: Unity (todas las apps: Animaze, VSeeFace, VMagicMirror, Warudo)
- Formato 3D: VRM (estándar abierto, basado en glTF)
- Face tracking: Webcam → MediaPipe/ARKit → 52 blendshapes → deformar mesh
- Lip sync: Micrófono → audio analysis → mouth blendshapes
- Rendering: Unity Universal Render Pipeline (URP)

**Proyectos Open Source clave:**
1. VMagicMirror (539★, C#/Unity 6.3) — VRM display + keyboard/mouse tracking, Windows. MIT license. Último commit: junio 2026.
2. VSeeFace SDK (194★, Unity 2019.4+) — VRM → VSFAvatar format, webcam face tracking, blendshapes. Custom format pero exporta desde Unity.
3. DrBomb/ExpressionAppBridge (54★, Python) — RTX + Mediape tracking para VSeeFace
4. blender-vrm-perfect-sync — Batch add ARKit 52 blendshapes to VRoid VRM models

**Por qué los VRM que hice en Blender se ven mal:**
- Geometría pobre (cara hecha a mano vs VRoid que genera automático)
- Sin blendshapes ARKit (52 morphs para face tracking)
- Sin materiales PBR (solo colores planos)
- Sin rig humanoid properly configured
- Sin IK (inverse kinematics)

**Camino correcto para avatar Kaos:**
1. Crear avatar base en **VRoid Studio** (gratis, genera VRM profesional con blendshapes)
2. Exportar a Blender para personalizar (agregar máscara, hood, armadura)
3. Agregar blendshapes ARKit (52 morphs) con script automatizado
4. Cargar en **VSeeFace** o **VMagicMirror** para face tracking real
5. Alternativa: usar **Warudo** para features más avanzadas

**Face Tracking para máscara ninja:**
- MediaPipe/ARKit detecta 468 landmarks faciales
- Los blendshapes mapean: jaw open, mouth smile, eye blink, etc.
- Personaje ENMASCARADO: los blendshapes de boca no son visibles, pero SÍ afectan la máscara
- Solución: animar la máscara misma (vibración/glow) en vez de boca
- Alternativa: usar tracking del usuario → mover toda la cabeza + ojos
