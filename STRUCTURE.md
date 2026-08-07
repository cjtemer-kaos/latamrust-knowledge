# Repository Structure

```
latamrust-knowledge/
├── README.md                    # Main documentation
├── STRUCTURE.md                 # This file
├── .gitignore                   # Git ignore rules
│
├── docs/                        # Documentation
│   ├── ANTICHEAT.md             # Anticheat system
│   ├── CHUNKY-GUIDE.md          # Chunky world generation
│   ├── CLAIMBLOCKS-DECISION.md  # ClaimBlocks vs FTB Teams
│   ├── DATAPACKS-MODS.md        # Custom mods & datapacks
│   ├── LUCKPERMS.md             # LuckPerms permissions
│   ├── RCON-ACCESS.md           # RCON remote access
│   ├── SERVER-CONFIG.md         # Server configuration
│   ├── STAFF-PANEL.md           # Staff panel mod docs
│   ├── TAILSCALE.md             # Tailscale network
│   └── TROUBLESHOOTING.md       # Common issues & fixes
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
└── claimblocks-analysis/        # ClaimBlocks mod analysis
    ├── ClaimBlocks-1.0.jar      # Original JAR
    └── decompiled/              # Decompiled source
```

## How to Use with OpenCode

1. Open this repo in OpenCode
2. Reference `docs/` for server knowledge
3. Reference `staff-panel-src/` for mod development
4. Reference `claimblocks-analysis/` for mod analysis
