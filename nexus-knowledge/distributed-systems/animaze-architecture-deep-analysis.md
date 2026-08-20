# animaze-architecture-deep-analysis

ANIMAZE DEEP ANALYSIS (2026-07-26):
- Installed: C:\Program Files (x86)\Steam\steamapps\common\Animaze\ (4.8GB)
- 425 avatar files (.avatar = AES-encrypted ZIP with JSON configs + 3D models)
- Engine: Custom C++ + C#/.NET hybrid (NOT Unity). 79 DLLs.
- Key DLLs: hyprface.dll (AI face tracking), libVisage*64.dll (Visage SDK), 
  OVRLipSync.dll (lip sync), SpoutLibrary.dll (Spout output), PythonMediapipe.dll,
  inference_engine.dll (OpenVINO), LeapC.dll (Leap Motion), tobii_stream_engine.dll (eye tracking)
- UI: React-based (bundle.js 4.8MB) rendered via cohtml.WindowsDesktop.dll (Coherent GameFace)
- 52 ARKit blendshapes with full filter configs (ARKitFilterConfigDefault.json)
- Lip sync: OVRLipSync (16 visemes AA/AH/AO/AW/OY/EH/IH/EY/Y/R/L/W/M/N/CH/FV)
- Face trackers: Visage SDK (proprietary, uses OpenVINO neural nets) + MediaPipe
- 4 face tracking filter configs: HyprFace (AI), Visage, MediaPipe, Maxine (NVIDIA)
- Output: Spout2 (texture sharing to OBS), virtual camera, window capture
- Animations: 157 .anim files (Mixamo-based) + .animtree state machines
- Skeleton: Custom format (.skel) with biped rig
- Materials: PBR (.material format)
- Meshes: Custom binary (.mesh format)
- Import: VRM, Live2D, FBX, Ready Player Me (encrypted internally)
- Has OpenAI integration for emotion-to-expression mapping
- System: Twitch integration, Voicemod voice effects, Inworld AI chatbot
