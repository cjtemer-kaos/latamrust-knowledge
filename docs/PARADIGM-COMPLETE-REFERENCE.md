# PARADIGM MINECRAFT MOD - COMPLETE REFERENCE
## Version: 2.3.0b (MC 1.21.1) | Source: github.com/Avalanche7CZ/Paradigm
## Compiled from official Wiki, README, and Modrinth documentation

---

# TABLE OF CONTENTS
1. [Navigation & Utility Commands](#1-navigation--utility-commands)
2. [Chat & Social Commands](#2-chat--social-commands)
3. [Moderation Commands](#3-moderation-commands)
4. [Admin Utility Commands](#4-admin-utility-commands)
5. [Paradigm Administration Commands](#5-paradigm-administration-commands)
6. [Permission System Commands](#6-permission-system-commands)
7. [Moderation Features (Detailed)](#7-moderation-features-detailed)
8. [Chat System (Detailed)](#8-chat-system-detailed)
9. [Announcements System](#9-announcements-system)
10. [Restart System](#10-restart-system)
11. [Tablist System](#11-tablist-system)
12. [Custom Commands System](#12-custom-commands-system)
13. [Message Formatting System](#13-message-formatting-system)
14. [MOTD & Server List](#14-motd--server-list)
15. [Storage Options](#15-storage-options)
16. [Configuration Files](#16-configuration-files)
17. [Command Toggles & Module Switches](#17-command-toggles--module-switches)

---

# 1. NAVIGATION & UTILITY COMMANDS

| Command | Description | Permission |
|---------|-------------|------------|
| `/sethome` | Set a home at current location | paradigm.home.set |
| `/home [name]` | Teleport to a saved home | paradigm.home.use |
| `/delhome [name]` | Delete a saved home | paradigm.home.delete |
| `/homes` | List all saved homes | paradigm.home.use |
| `/back` | Return to previous location (after teleport/death) | paradigm.back |
| `/spawn` | Teleport to server spawn | paradigm.spawn |
| `/setspawn` | Set server spawn location | paradigm.spawn.set |
| `/warp [name]` | Teleport to a named warp point | paradigm.warp.use |
| `/warps` | List all available warps | paradigm.warp.list |
| `/setwarp [name]` | Create a new warp point | paradigm.warp.set |
| `/delwarp [name]` | Delete a warp point | paradigm.warp.delete |
| `/warpinfo [name]` | Show information about a warp | paradigm.warp.info |
| `/tpa [player]` | Send teleport request to player | paradigm.tpa |
| `/tpahere [player]` | Request player to teleport to you | paradigm.tpa.here |
| `/tpaccept` | Accept incoming teleport request | paradigm.tpa.accept |
| `/tpdeny` | Deny incoming teleport request | paradigm.tpa.deny |
| `/tpcancel` | Cancel outgoing teleport request | paradigm.tpa.cancel |
| `/seen [player]` | Check when player was last online | paradigm.seen |
| `/ignore [player]` | Ignore a player's messages | paradigm.ignore |
| `/unignore [player]` | Stop ignoring a player | paradigm.ignore.remove |

**Home Names:** Limited to 32 characters, command-safe characters only (letters, numbers, underscore, hyphen, period).

**Back Location:** Records previous location after successful teleport. Death location also saved for `/back` after respawn.

---

# 2. CHAT & SOCIAL COMMANDS

| Command | Description | Permission |
|---------|-------------|------------|
| `/msg <player> <message>` | Send private message | paradigm.msg |
| `/tell <player> <message>` | Alias for /msg | paradigm.msg |
| `/w <player> <message>` | Alias for /msg | paradigm.msg |
| `/whisper <player> <message>` | Alias for /msg | paradigm.msg |
| `/reply [message]` | Reply to last private message | paradigm.msg.reply |
| `/r [message]` | Alias for /reply | paradigm.msg.reply |
| `/sc` | Toggle staff chat | paradigm.staffchat |
| `/groupchat` | Toggle group chat mode | paradigm.groupchat |
| `/mention <player>` | Mention/notify a player | paradigm.mention |
| `/socialspy` | Toggle social spy (view PMs) | paradigm.socialspy |

**Chat Types:** Public, Staff, Group - classified at early platform hook, cancelled from normal pipeline for staff/group.

---

# 3. MODERATION COMMANDS

| Command | Description | Permission |
|---------|-------------|------------|
| `/kick <player> [reason]` | Kick a player | paradigm.moderation.kick |
| `/ban <player> [reason]` | Ban a player | paradigm.moderation.ban |
| `/tempban <player> <duration> [reason]` | Temporarily ban player | paradigm.moderation.ban |
| `/unban <player>` | Remove ban from player | paradigm.moderation.unban |
| `/pardon <player>` | Alias for /unban | paradigm.moderation.unban |
| `/ipban <player> [reason]` | Ban player by IP | paradigm.moderation.ipban |
| `/tempipban <player> <duration> [reason]` | Temporarily IP ban | paradigm.moderation.ipban |
| `/unipban <player>` | Remove IP ban | paradigm.moderation.unipban |
| `/mute <player> [reason]` | Mute a player | paradigm.moderation.mute |
| `/tempmute <player> <duration> [reason]` | Temporarily mute | paradigm.moderation.mute |
| `/unmute <player>` | Remove mute | paradigm.moderation.unmute |
| `/warn <player> <reason>` | Warn a player | paradigm.moderation.warn |
| `/setjail <name>` | Set a jail location | paradigm.jail.set |
| `/jail <player> [jail]` | Send player to jail | paradigm.jail |
| `/unjail <player>` | Release player from jail | paradigm.jail.unjail |
| `/history <player>` | View player punishment history | paradigm.moderation.history |
| `/paradigm punishment info <id>` | Get info on specific punishment | paradigm.moderation.history |
| `/paradigm punishment revoke <id> [reason]` | Revoke specific punishment | paradigm.moderation.revoke |
| `/paradigm punishment history <player>` | View full punishment history | paradigm.moderation.history |

**Duration Format:** `30s` (seconds), `5m` (minutes), `2h` (hours), `7d` (days)

**Scope Options:** `--scope server` (current server only), `--scope network` (network-wide, default)

**Ban Screen:** Configurable with placeholders: `{punishment_id}`, `{punishment_type}`, `{player_name}`, `{player_uuid}`, `{reason}`, `{actor}`, `{started_at}`, `{expires_at}`, `{remaining_time}`, `{scope}`, `{server_id}`, `{network_id}`, `{appeal_url}`

---

# 4. ADMIN UTILITY COMMANDS

| Command | Description | Permission |
|---------|-------------|------------|
| `/vanish` | Toggle invisible mode | paradigm.vanish |
| `/god` | Toggle god mode (invincible) | paradigm.god |
| `/invsee <player>` | View player inventory | paradigm.invsee |
| `/endersee <player>` | View player ender chest | paradigm.endersee |
| `/repair` | Repair held item | paradigm.repair |
| `/enchant <enchantment> [level]` | Enchant held item | paradigm.enchant |
| `/sudo <player> <command>` | Force player to run command | paradigm.sudo |
| `/near` | List nearby players | paradigm.near |
| `/whois <player>` | Show detailed player info | paradigm.whois |
| `/top` | Teleport to highest block at position | paradigm.top |
| `/jump` | Teleport to where you're looking | paradigm.jump |
| `/gamemode <mode>` | Change game mode | paradigm.gamemode |
| `/gmc` | Creative mode | paradigm.gamemode |
| `/creative` | Alias for /gmc | paradigm.gamemode |
| `/gms` | Survival mode | paradigm.gamemode |
| `/survival` | Alias for /gms | paradigm.gamemode |
| `/gma` | Adventure mode | paradigm.gamemode |
| `/adventure` | Alias for /gma | paradigm.gamemode |
| `/gmsp` | Spectator mode | paradigm.gamemode |
| `/spectator` | Alias for /gmsp | paradigm.gamemode |
| `/fly` | Toggle flight mode | paradigm.fly |
| `/clearinv` | Clear your inventory | paradigm.clearinv |
| `/ci` | Alias for /clearinv | paradigm.clearinv |
| `/speed <value>` | Set movement speed | paradigm.speed |
| `/feed` | Fill hunger bar | paradigm.feed |
| `/heal` | Heal to full health | paradigm.heal |
| `/day` | Set time to day | paradigm.time |
| `/night` | Set time to night | paradigm.time |
| `/sun` | Clear weather | paradigm.weather |
| `/rain` | Set rain | paradigm.weather |
| `/thunder` | Set thunder | paradigm.weather |

---

# 5. PARADIGM ADMINISTRATION COMMANDS

| Command | Description |
|---------|-------------|
| `/paradigm help` | Show help and module information |
| `/paradigm reload [config]` | Reload configuration (all or specific) |
| `/paradigm command list` | List all registered commands |
| `/paradigm command search <query>` | Search commands by name |
| `/paradigm command status <command>` | Check command enabled/disabled status |
| `/paradigm command enable <command>` | Enable a command |
| `/paradigm command disable <command>` | Disable a command |
| `/paradigm command reload` | Reload command registration |
| `/paradigm storage status` | Show storage provider status |
| `/paradigm storage test` | Test storage connection |
| `/paradigm storage migrate ...` | Migrate between storage providers |
| `/paradigm dashboard open` | Open dashboard in browser |
| `/paradigm dashboard status` | Check dashboard status |
| `/paradigm dashboard start` | Start dashboard server |
| `/paradigm dashboard stop` | Stop dashboard server |
| `/paradigm dashboard reload` | Reload dashboard configuration |
| `/paradigm dashboard token` | Manage dashboard auth token |
| `/paradigm audit recent` | Show recent audit records |
| `/paradigm audit player <name>` | Show audit records for player |
| `/paradigm audit type <type>` | Show audit records by type |
| `/paradigm perms` | Show permission system info |
| `/paradigm permission check <player> <node>` | Check if player has permission |
| `/paradigm permission explain <node>` | Explain permission node |
| `/paradigm permission nodes` | List all permission nodes |
| `/paradigm permission migrate ...` | Migrate permission data |
| `/paradigm group ...` | Group management (see below) |
| `/customcommandsreload` | Reload custom command definitions |
| `/editor` | Open WebEditor session |

---

# 6. PERMISSION SYSTEM COMMANDS

**Group Management:**
| Command | Description |
|---------|-------------|
| `/paradigm group list` | List all groups |
| `/paradigm group add <group>` | Create a new group |
| `/paradigm group remove <group>` | Delete a group |
| `/paradigm group info <group>` | Show group details |
| `/paradigm group parent add <group> <parent>` | Set group parent |
| `/paradigm group parent remove <group> <parent>` | Remove group parent |

**Group Permissions:**
| Command | Description |
|---------|-------------|
| `/paradigm group perm add <group> <node> [flags]` | Add permission to group |
| `/paradigm group perm deny <group> <node> [flags]` | Deny permission to group |
| `/paradigm group perm remove <group> <node> [flags]` | Remove permission from group |
| `/paradigm group perm remove-id <group> <assignment-id>` | Remove by assignment ID |

**Player Permissions:**
| Command | Description |
|---------|-------------|
| `/paradigm group user add <player> <group> [flags]` | Add player to group |
| `/paradigm group user remove <player> <group> [flags]` | Remove player from group |
| `/paradigm group user perm add <player> <node> [flags]` | Add permission to player |
| `/paradigm group user perm deny <player> <node> [flags]` | Deny permission to player |
| `/paradigm group user perm remove <player> <node> [flags]` | Remove permission from player |
| `/paradigm group user perm remove-id <player> <assignment-id>` | Remove by assignment ID |

**Permission Flags:**
- `--context server=current` - Apply to current server
- `--context server=<server-id>` - Apply to specific server
- `--context network=current` - Apply to current network
- `--context network=<network-id>` - Apply to specific network
- `--context world=<world-id>` - Apply to specific world
- `--context dimension=<dimension-id>` - Apply to specific dimension
- `--expires 30d` - Permission expires in 30 days
- `--permanent` - Permission is permanent (default)

**Permission Fallback Order:**
1. LuckPerms cached metadata (when defined result exists)
2. Paradigm internal cache/API (when `internalPermissionsEnable` is enabled)
3. Platform/vanilla operator fallback

---

# 7. MODERATION FEATURES (Detailed)

## Lifecycle & Scope
- **Active Record:** Has `expiresAtMs: null` (permanent) or not yet expired
- **Default Scope:** Network-wide (`--scope network`)
- **Server Scope:** `--scope server` limits to current server
- **Jail:** Always server-scoped

## IP Handling
- Only literal IPv4/IPv6 addresses accepted
- Ports, IPv6 zone suffixes normalized before lookup
- SHA-256 lookup hash for equality matching
- Raw IPs never shown in command output or dashboard

## Login Enforcement
- Active UUID/IP punishments cached in-memory
- Checked at earliest player connection boundary
- SQL-backed multi-server refreshes asynchronously

## Ban Screen Configuration
```json
{
  "banScreenEnabled": true,
  "banScreenLines": [
    "<bold><color:red>You are banned</color></bold>",
    "",
    "<color:gray>Reason</color>",
    "{reason}",
    "",
    "<color:gray>Ban ID</color>",
    "{punishment_id}",
    "",
    "<color:aqua>{appeal_url}</color>"
  ],
  "appealUrl": "https://example.invalid/appeal/{punishment_id}",
  "cacheRefreshSeconds": 30
}
```

## Dashboard Workflow
- Player selection → Active punishments → Paginated history
- Structured type/reason/duration/scope form for creation
- Revoke buttons target stable punishment ID
- IP-ban requires online address or validated literal IP
- Raw addresses masked, never exposed publicly

---

# 8. CHAT SYSTEM (Detailed)

## Configuration Files
- Main chat: `config/paradigm/chat.json`
- Mentions: `config/paradigm/mentions.json`
- Module switches: `config/paradigm/main.json`

## Public Chat Format
- Enabled by `chatFormatEnable` in `main.json`
- Supports placeholders: `{player_name}`, `{prefix}`, `{suffix}`, `{group}`, `{message}`
- Prefix/suffix/group from Paradigm internal groups or LuckPerms

## Private Messages
- Controls: `/msg`, `/tell`, `/w`, `/whisper`, `/reply`, `/r`
- Separate sender/recipient formats configured
- Staff can use `/socialspy` for PM monitoring

## Staff & Group Chat
- `/sc` toggles staff chat
- `/groupchat` toggles group chat
- Messages classified as Public/Staff/Group at platform hook
- Staff/group messages cancelled from normal pipeline

## Join & Leave Messages
- Supports placeholders: `{player_name}`, `{player_uuid}`, `{server_name}`
- Uses shared formatting parser
- Dashboard provides collapsible preview per field

## Mentions
- `/mention <player>` notifies a player
- Configurable mention sound, message format
- Dashboard has searchable placeholder list

---

# 9. ANNOUNCEMENTS SYSTEM

## Configuration
- Config: `config/paradigm/announcements.json`
- Enabled by: `announcementsEnable` in `main.json`

## Four Independent Channels

### 1. Global Chat Announcements
```json
{
  "chatEnabled": true,
  "chatInterval": 60,
  "chatMessages": ["<color:aqua>Server announcement!</color>"]
}
```

### 2. Actionbar Announcements
```json
{
  "actionbarEnabled": true,
  "actionbarInterval": 30,
  "actionbarMessages": ["<color:yellow>Check our Discord!</color>"]
}
```

### 3. Title/Subtitle Announcements
```json
{
  "titleEnabled": true,
  "titleInterval": 120,
  "titleMessages": ["<color:red>Title</color>|<color:gray>Subtitle</color>"]
}
```

### 4. Bossbar Announcements
```json
{
  "bossbarEnabled": true,
  "bossbarInterval": 45,
  "bossbarMessages": ["<color:red>Server Message</color>"],
  "bossbarColor": "RED",
  "bossbarDuration": 5
}
```

## Order Mode
- `sequential` - Cycle through messages in order
- `random` - Random order

## Bossbar Colors
- `PINK`, `BLUE`, `RED`, `GREEN`, `YELLOW`, `PURPLE`, `WHITE`

---

# 10. RESTART SYSTEM

## Configuration
- Config: `config/paradigm/restart.json`
- Enabled by: `restartEnable` in `main.json`

## Scheduling Modes

### Fixed Interval
```json
{
  "restartType": "Fixed",
  "restartInterval": 6.0
}
```
- Restarts every N hours

### Realtime Schedule
```json
{
  "restartType": "Realtime",
  "realTimeInterval": ["00:00", "06:00", "12:00", "18:00"]
}
```
- Restarts at specific times

## Warning Configuration
```json
{
  "bossbarEnabled": true,
  "bossBarMessage": "&cThe server will be restarting in {minutes}:{seconds}",
  "timerUseChat": true,
  "BroadcastMessage": "&cThe server will be restarting in &e{time}",
  "timerBroadcast": [3600, 1800, 600, 300, 120, 60, 30, 10, 5, 4, 3, 2, 1],
  "defaultRestartReason": "&6The server is restarting!",
  "playSoundEnabled": true,
  "playSoundFirstTime": 60.0,
  "titleEnabled": true,
  "titleStayTime": 2,
  "titleMessage": "&cRestarting in {minutes}:{seconds}"
}
```

## Placeholders
- `{minutes}` - Minutes until restart
- `{seconds}` - Seconds until restart
- `{time}` - Human-readable time
- `{hours}` - Hours until restart

## Pre-Restart Commands
```json
{
  "preRestartCommands": [
    {
      "secondsBefore": 30,
      "command": "broadcast &e[Paradigm] Restarting in 30 seconds..."
    },
    {
      "secondsBefore": 10,
      "command": "[asPlayer] tell {player_name} &cServer restarting in {seconds}s"
    }
  ]
}
```

## Restart Commands
- `/paradigm restart` - Trigger immediate restart
- `/paradigm restart cancel` - Cancel scheduled restart
- `/paradigm restart status` - Check restart status

---

# 11. TABLIST SYSTEM

## Configuration
- Config: `config/paradigm/tablist.json`
- Disabled by default

```json
{
  "enabled": false,
  "header": [
    "<gradient:aqua:light_purple><bold>Paradigm</bold></gradient>",
    "<color:gray>{server_name} · {online_players}/{max_players}</color>"
  ],
  "footer": [
    "<color:gray>Server: {server_id} · Network: {network_id}</color>"
  ],
  "playerFormat": "{prefix}<color:white>{player_name}</color>{suffix}",
  "sorting": ["GROUP_WEIGHT_DESC", "PLAYER_NAME_ASC"],
  "showPing": false,
  "refreshInterval": 5,
  "perWorldOverrides": {}
}
```

## Placeholders
- `{player_name}` - Player username
- `{prefix}` - Permission prefix
- `{suffix}` - Permission suffix
- `{group}` - Primary group name
- `{server_name}` - Server name
- `{online_players}` - Current player count
- `{max_players}` - Max player slots
- `{server_id}` - Server identifier
- `{network_id}` - Network identifier

## Sorting Options
- `GROUP_WEIGHT_DESC` - Group weight descending
- `GROUP_WEIGHT_ASC` - Group weight ascending
- `PLAYER_NAME_ASC` - Name ascending
- `PLAYER_NAME_DESC` - Name descending

## Metadata Provider
- Internal permissions: prefix, suffix, group, weight from Paradigm
- LuckPerms fallback when internal permissions disabled
- Empty prefix/suffix, zero weight if no provider

---

# 12. CUSTOM COMMANDS SYSTEM

## Configuration
- Config: `config/paradigm/commands/*.json`
- Enabled by: `commandManagerEnable` in `main.json`
- Reload: `/customcommandsreload`

## Command Structure
```json
{
  "name": "welcome",
  "description": "Shows a welcome message.",
  "permission": "paradigm.welcome",
  "requirePermission": true,
  "permissionErrorMessage": "&cYou cannot use this command.",
  "arguments": [],
  "actions": [
    {
      "type": "message",
      "text": ["<color:aqua>Welcome, {player_name}!</color>"]
    }
  ],
  "cooldown_seconds": 30,
  "cooldown_message": "&cWait {remaining_time} seconds.",
  "area_restriction": null
}
```

## Argument Types
| Type | Runtime Value | Suggestions |
|------|---------------|-------------|
| `string` | text | none by default |
| `integer` | integer | range from min/max |
| `boolean` | true/false | both values |
| `player` | online player | online player names |
| `world` | world identifier | known worlds |
| `gamemode` | gamemode string | survival, creative, adventure, spectator |
| `custom` | text | customCompletions |

## Action Types
| Type | Fields | Behavior |
|------|--------|----------|
| `message` | text | Parses and sends to command source |
| `teleport` | x, y, z | Teleports executing player |
| `run_command` | commands | Executes as current command source |
| `runcmd` | commands | Alias for run_command |
| `command` | commands | Alias for run_command |
| `run_console` | commands | Executes through server console |
| `conditional` | conditions, on_success, on_failure | Runs nested actions after condition check |

## Condition Types
| Type | Value |
|------|-------|
| `has_permission` | permission node |
| `has_item` | item identifier (item_amount defaults to 1) |
| `health_above` | numeric health threshold |
| `health_below` | numeric health threshold |
| `is_op` | optional operator level, default 2 |

All conditions support `negate` boolean. Player-dependent checks fail for console source.

## Positional Arguments
- `$1`, `$2`, etc. - Reference specific arguments
- `$*` - All arguments joined by spaces

## Area Restriction
```json
{
  "area_restriction": {
    "world": "minecraft:overworld",
    "corner1": [0, 60, 0],
    "corner2": [10, 70, 10],
    "restriction_message": "&cYou are not in the required area."
  }
}
```

---

# 13. MESSAGE FORMATTING SYSTEM

## Colors
**Named Colors:**
`black`, `dark_blue`, `dark_green`, `dark_aqua`, `dark_red`, `dark_purple`, `gold`, `gray`, `dark_gray`, `blue`, `green`, `aqua`, `red`, `light_purple`, `yellow`, `white`

**Format:** `<color:name>` or `<colour:name>`

**Hex Colors:** `<color:#FF5555>` or `<color:FF5555>`

**Legacy Codes:** `&0`-`&f`, `&k`, `&l`, `&m`, `&n`, `&o`, `&r` (converted before tag parsing)

## Formatting Tags
- `<bold>` or `<b>` - Bold
- `<italic>` or `<i>` or `<em>` - Italic
- `<underlined>` or `<u>` - Underlined
- `<strikethrough>` or `<s>` or `<del>` - Strikethrough
- `<obfuscated>` or `<obf>` - Obfuscated
- `<reset>` - Reset formatting

Tags can be nested. Close in reverse order of opening.

## Gradients & Effects
- `<gradient:color1:color2>` - Gradient between two colors
- `<rainbow>` - Rainbow effect
- `<rainbow:offset>` - Rainbow with offset

## Click Actions
- `<click:suggest_command:/command>` - Suggest command
- `<click:run_command:/command>` - Run command
- `<click:open_url:https://example.com>` - Open URL
- `<click:copy_to_clipboard:text>` - Copy to clipboard
- `<click:change_page:page>` - Change book page
- `<click:show_dialogue:dialogue>` - Show dialogue

## Hover Actions
- `<hover:show_text:'text'>` - Show text on hover
- `<hover:show_item:'item'>` - Show item tooltip
- `<hover:show_entity:'entity'>` - Show entity info

## Emojis
- `<emoji:name>` - Insert emoji from `config/paradigm/emojis.json`
- Common: `<emoji:heart>`, `<emoji:star>`, `<emoji:check>`, `<emoji:x>`

## Placeholders
- `{player_name}` - Player username
- `{player_uuid}` - Player UUID
- `{server_name}` - Server name
- `{server_id}` - Server identifier
- `{network_id}` - Network identifier
- `{online_players}` - Current player count
- `{max_players}` - Max player slots
- `{world}` - Current world name
- `{x}`, `{y}`, `{z}` - Player coordinates
- `{prefix}` - Permission prefix
- `{suffix}` - Permission suffix
- `{group}` - Primary group name
- `{message}` - Chat message content

---

# 14. MOTD & SERVER LIST

## Configuration
- Config: `config/paradigm/motd.json`
- Join MOTD: Displayed when player joins
- Server List: Displayed in multiplayer server list

## Features
- RGB/hex color support
- Gradient text
- Click/hover actions
- Placeholder support
- Custom server icon
- Player count hover text

---

# 15. STORAGE OPTIONS

## Supported Providers
1. **JSON** - File-based storage (default)
2. **SQLite** - Embedded database
3. **MySQL/MariaDB** - Network database

## Storage Commands
- `/paradigm storage status` - Show provider status
- `/paradigm storage test` - Test connection
- `/paradigm storage migrate` - Migrate between providers

## Features
- Connection testing
- Fallback state
- Migration dry runs
- Conflict handling
- Migration previews

---

# 16. CONFIGURATION FILES

| File | Purpose |
|------|---------|
| `config/paradigm/main.json` | Main module switches |
| `config/paradigm/commands.json` | Command enable/disable states |
| `config/paradigm/cooldowns.json` | Cooldown and warmup settings |
| `config/paradigm/permissions.json` | Permission data |
| `config/paradigm/discovered_permissions.json` | External command permissions |
| `config/paradigm/chat.json` | Chat formatting |
| `config/paradigm/mentions.json` | Mention settings |
| `config/paradigm/announcements.json` | Announcement configuration |
| `config/paradigm/restart.json` | Restart schedule |
| `config/paradigm/tablist.json` | Tablist configuration |
| `config/paradigm/motd.json` | MOTD settings |
| `config/paradigm/emojis.json` | Emoji definitions |
| `config/paradigm/commands/*.json` | Custom command definitions |

---

# 17. COMMAND TOGGLES & MODULE SWITCHES

## Main Module Switches (`main.json`)
- `homeCommandsEnable` - Home commands
- `tpaCommandsEnable` - TPA commands
- `warpCommandsEnable` - Warp commands
- `spawnCommandsEnable` - Spawn commands
- `moderationCommandsEnable` - Moderation commands
- `adminUtilityCommandsEnable` - Admin utility commands
- `gamemodeCommandsEnable` - Gamemode commands
- `flyCommandEnable` - Fly command
- `clearInventoryCommandEnable` - Clear inventory command
- `timeWeatherCommandsEnable` - Time/weather commands
- `speedCommandEnable` - Speed command
- `feedCommandEnable` - Feed command
- `healCommandEnable` - Heal command
- `commandManagerEnable` - Custom command manager
- `internalPermissionsEnable` - Internal permission system
- `externalCommandPermissionsEnable` - External command permissions
- `chatFormatEnable` - Chat formatting
- `announcementsEnable` - Announcements
- `restartEnable` - Restart system
- `tablistEnable` - Tablist
- `motdEnable` - MOTD

## Command Priority
- `forceCommandPriorityEnable` - Override conflicting command roots
- Disabled commands release their roots
- Paradigm does not reserve disabled command roots

---

# QUICK REFERENCE - ALL COMMANDS BY CATEGORY

## Navigation (19 commands)
`/sethome` `/home` `/delhome` `/homes` `/back` `/spawn` `/setspawn` `/warp` `/warps` `/setwarp` `/delwarp` `/warpinfo` `/tpa` `/tpahere` `/tpaccept` `/tpdeny` `/tpcancel` `/seen` `/ignore` `/unignore`

## Chat (10 commands)
`/msg` `/tell` `/w` `/whisper` `/reply` `/r` `/sc` `/groupchat` `/mention` `/socialspy`

## Moderation (18 commands)
`/kick` `/ban` `/tempban` `/unban` `/pardon` `/ipban` `/tempipban` `/unipban` `/mute` `/tempmute` `/unmute` `/warn` `/setjail` `/jail` `/unjail` `/history` `/paradigm punishment info` `/paradigm punishment revoke` `/paradigm punishment history`

## Admin Utilities (22 commands)
`/vanish` `/god` `/invsee` `/endersee` `/repair` `/enchant` `/sudo` `/near` `/whois` `/top` `/jump` `/gamemode` `/gmc` `/creative` `/gms` `/survival` `/gma` `/adventure` `/gmsp` `/spectator` `/fly` `/clearinv` `/ci` `/speed` `/feed` `/heal` `/day` `/night` `/sun` `/rain` `/thunder`

## Paradigm Administration (20+ commands)
`/paradigm help` `/paradigm reload` `/paradigm command list|search|status|enable|disable|reload` `/paradigm storage status|test|migrate` `/paradigm dashboard open|status|start|stop|reload|token` `/paradigm audit recent|player|type` `/paradigm perms` `/paradigm permission check|explain|nodes|migrate` `/paradigm group list|add|remove|info|parent|perm|user` `/customcommandsreload` `/editor`

## Permission Commands (16+ commands)
`/paradigm group list` `/paradigm group add` `/paradigm group remove` `/paradigm group info` `/paradigm group parent add|remove` `/paradigm group perm add|deny|remove|remove-id` `/paradigm group user add|remove` `/paradigm group user perm add|deny|remove|remove-id`

---

# SOURCES
- GitHub Wiki: https://github.com/Avalanche7CZ/Paradigm/wiki
- Modrinth: https://modrinth.com/mod/paradigm
- Source: https://github.com/Avalanche7CZ/Paradigm
- Author: Avalanche7CZ
- License: CC-BY-NC-ND-4.0
- Total Downloads: 8,956+ across all platforms
- Supported MC Versions: 1.12.2 - 1.21.11
- Loaders: Fabric, Forge, NeoForge

---

*Document compiled from official Paradigm documentation. Last updated: August 2026*
