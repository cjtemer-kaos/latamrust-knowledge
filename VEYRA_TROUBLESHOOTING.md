# Veyra Sounds - Troubleshooting & Lessons Learned

## What We Tried

### 1. VB-CABLE Installation
- Installed VB-CABLE (free version) for virtual audio
- Works: CABLE Input (render) / CABLE Output (capture)
- Status: **Working**

### 2. VoiceMeeter Installation
- Installed VoiceMeeter v1.1.2.2 for additional virtual cables
- Provides: Voicemeeter In 1-5 (render), Voicemeeter Out A1-A5, B1-B3 (capture)
- Problem: **Requires app to be running** for virtual devices to be active
- Status: **Uninstalled** (user doesn't want the app)

### 3. Veyra Sounds Configuration
- Installed Veyra Sounds v1.2.0 (unsigned portable)
- Audio Bridge: CABLE Input → BT-163 speakers — **Working**
- Mic Bridge: USB Mic → VoiceMeeter In 1 — **Failed** (same device as Audio Bridge)

### 4. Veyra Source Code Modification
- Cloned repo to `D:\autopsia\veyra`
- Added VoiceMeeter detection functions
- Compiled successfully (130/130 targets)
- Problem: Mic Bridge and Audio Bridge can't use same VoiceMeeter device

## Key Learnings

### Audio Bridge vs Mic Bridge
- **Audio Bridge**: Captures from a render device (virtual cable input) → plays to speakers
- **Mic Bridge**: Captures from a microphone → renders to a virtual cable
- They CANNOT use the same virtual cable as source/target (causes loop)

### VoiceMeeter Virtual Cables
- VoiceMeeter In 1-5 are **render** endpoints (apps send audio here)
- VoiceMeeter Out A1-A5, B1-B3 are **capture** endpoints (apps receive audio from here)
- **Critical**: VoiceMeeter app MUST be running for these to be active in Windows

### VB-CABLE Limitations
- Free version: Only 1 cable (CABLE Input/Output)
- Need Cable A+B ($1) for 2 virtual cables
- No app required — always active when driver installed

## Working Configuration

### For Discord + Veyra
```
Mic USB → Veyra (processing) → CABLE Input → Discord (CABLE Output)
```

### For Speakers + Veyra
```
System Audio → CABLE Input → Veyra (EQ/effects) → Speakers
```

## Files Modified
- `D:\autopsia\veyra\apps\veyra-ui\Source\AudioDevices.cpp` — Added VoiceMeeter detection
- `D:\autopsia\veyra\apps\veyra-ui\Source\AudioDevices.h` — Added function declarations
- `D:\autopsia\veyra\apps\veyra-ui\Source\Screens\DevicesScreen.cpp` — Added VoiceMeeter warning

## Status: REVERTED
All Veyra modifications were reverted/deleted. User wants simpler solution.
