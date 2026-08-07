# Repository Structure

```
latamrust-knowledge/
├── README.md                    # Main documentation
├── STRUCTURE.md                 # This file
├── CONTEXT.md                   # Quick context for PC1
├── .gitignore                   # Git ignore rules
│
├── docs/                        # Documentation
│   ├── CRITICAL-RULES.md        # ⛔ MANDATORY READ - Rules to not break server
│   ├── ANTICHEAT.md             # Anticheat system
│   ├── CHUNKY-GUIDE.md          # Chunky world generation
│   ├── CLAIMBLOCKS-DECISION.md  # ClaimBlocks vs FTB Teams
│   ├── DATAPACKS-MODS.md        # Custom mods & datapacks
│   ├── LUCKPERMS.md             # LuckPerms permissions
│   ├── RCON-ACCESS.md           # RCON remote access
│   ├── SERVER-CONFIG.md         # Server configuration (0.19.3 updated)
│   ├── STAFF-PANEL.md           # Staff panel mod docs
│   ├── TAILSCALE.md             # Tailscale network
│   └── TROUBLESHOOTING.md       # Common issues & fixes (0.19.3 updated)
│
├── staff-panel-src/             # Staff Panel mod source code
│   ├── build.gradle             # Gradle build file
│   └── src/main/java/com/cobbleverse/staffpanel/
│       ├── StaffPanelMod.java   # Main mod entry
│       ├── commands/
│       │   └── StaffCommands.java   # /jail, /ban, /kick, etc.
│       └── menu/
│           ├── JailSystem.java      # Jail with time + persistence
│           └── StaffActions.java    # Staff action handlers
│
└── claimblocks-analysis/        # ClaimBlocks analysis
    ├── ClaimBlocks-1.0.jar      # Compiled mod
    └── decompiled/              # Decompiled code
```

## Quick Navigation

- **New to the project?** Start with `README.md`
- **Need to fix something?** Read `docs/CRITICAL-RULES.md` FIRST
- **Server issues?** Check `docs/TROUBLESHOOTING.md`
- **Config questions?** See `docs/SERVER-CONFIG.md`
- **Staff panel?** Read `docs/STAFF-PANEL.md`

## PC1 Knowledge (Agente Hermes - KAOS_MCS)

```
pc1-knowledge/
├── PC1-KNOWLEDGE.md              # Conocimiento completo de PC1
├── launcher/
│   ├── launcher_v5.py            # Launcher v5.0 (Google Drive + Java 21 + skins)
│   ├── main_v5.py                # Entry point PyInstaller
│   └── sync_skins.py             # Sync de skins Easy NPC
└── discord/
    └── discord_bot.py            # Bot Discord conectado directo a Hermes
```

**Unificado**: 2026-08-07 — PC1 + PC2 conocimiento en un solo repo
