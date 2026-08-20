# animaze-full-analysis

ANIMAZE DEEP ANALYSIS (2026-07-26) — INSTALADO EN ESTA PC:
- Ruta: C:\Program Files (x86)\Steam\steamapps\common\Animaze\ (4.8GB)
- 425 avatares incluidos (formato .avatar = AES-encrypted ZIP)
- Engine: C++ custom + C#/.NET hybrid (79 DLLs, NO es Unity)
- UI: React (cohtml.WindowsDesktop.dll = Coherent GameFace)
- Face Trackers (4): HyprFace (AI neural net), Visage SDK (OpenVINO+Candide3), MediaPipe, Maxine (NVIDIA)
- 52 ARKit blendshapes con configs completas (ARKitFilterConfigDefault.json)
- Lip Sync: OVRLipSync con 16 visemes (AA/AH/AO/AW/OY/EH/IH/EY/Y/R/L/W/M/N/CH/FV) + CMUdict phoneme mapping
- Output: Spout2 (textura a OBS), Virtual Camera, Window Capture
- Tracking config files: HyprFaceFilterConfigDefaultLow30/Mid30/High60/Dark.json
- Skeleton: .skel (biped rig custom), Meshes: .mesh (binary), Materials: .material (PBR), Textures: .ktx (GPU)
- Importa: VRM, Live2D, FBX, Ready Player Me, Union Avatars
- Animations: 157 .anim (Mixamo-based) + .animtree state machines
- Extras: OpenAI emotion→expression (19 emotions), Twitch, Voicemod, Inworld AI, Leap Motion, Tobii eye tracking
- Visage SDK: candide3.wfm (face model 539KB), jk_300.wfm (534KB), OpenVINO plugins
- VRM import → Animaze convierte internamente a .avatar encriptado
- Preferences: eAutoBlink, eBreathingBehavior, eBodyYawFromHeadYaw, ChaseCameraConfig (focusBone BipHead)
- Pipeline: VRoid Studio (crear VRM) → Animaze import → HyprFace tracking → Spout2 → OBS
