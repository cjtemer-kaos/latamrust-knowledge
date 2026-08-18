package com.mikadev;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import com.mikadev.config.SimpleConfig;
import com.mikadev.packets.ModListPayload;
import com.mikadev.packets.RequestModsPayload;
import net.luckperms.api.node.Node;

/**
 * Server-side verification logic.
 *
 * Flow:
 * 1. Player enters PLAY phase -> server sends RequestModsPayload (S2C)
 * 2. Client collects fabric mods -> sends ModListPayload (C2S)  [solo mods]
 * 3. Server receives mod list -> checks against allowed_mods whitelist
 *    AND against banned_mods denylist (known cheat clients).
 * 4. If unauthorized / banned -> kicks player + alerts online admins
 * 5. All mod lists are logged to logs/latamrust/<player>.log
 *
 * 2026-08-17: SOLO server-side. El payload es de 1 campo (mods) — compatible
 * con el cliente distribuido. La deteccion de hacks se hace comparando los mods
 * que el cliente YA reporta contra la lista negra banned_mods (rusherhack, boze,
 * meteor, impact, wurst...). No se toca el cliente.
 */
public class AnticheatServer implements DedicatedServerModInitializer {

    public static SimpleConfig CONFIG;

    // Config keys
    public static final String KEY_ALLOWED_MODS = "allowed_mods";
    public static final String KEY_EXEMPT_GROUPS = "exempt_groups";
    public static final String KEY_BANNED_MODS = "banned_mods";

    // Parsed config values
    public static Set<String> allowedMods;
    public static List<String> exemptGroups;
    public static Set<String> bannedMods;   // known cheat clients, always kicked

    // Timeout in seconds for client to respond with mod list
    private static final int MOD_CHECK_TIMEOUT_SECONDS = 300;

    // Track players waiting for mod list response: UUID -> nanos when join happened
    private final ConcurrentHashMap<UUID, Long> pendingChecks = new ConcurrentHashMap<>();

    // Scheduler for timeout handling
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "LatamRust-Core-Timeout");
        t.setDaemon(true);
        return t;
    });

    /**
     * Default config provider - generates the config file template if missing.
     */
    String configProvider(String filename) {
        return "# LatamRust Core Configuration\n" +
               "# Comma-separated list of allowed Fabric mod IDs\n" +
               "# Players with mods NOT on this list will be kicked\n" +
               KEY_ALLOWED_MODS + "=\n" +
               "\n" +
               "# Comma-separated list of LuckPerms groups that are exempt from checks\n" +
               "# Players in these groups will not be checked or kicked\n" +
               KEY_EXEMPT_GROUPS + "=admin,staff+,staff,builder\n" +
               "\n" +
               "# Mod IDs ALWAYS banned (known cheat clients): kicked even if on allowed_mods.\n" +
               "# Lista negra de hacks (RusherHack, Boze, Meteor, Impact, Wurst...).\n" +
               KEY_BANNED_MODS + "=rusherhack,rusherhack-client,boze,boze-client,meteor-client,impact,wurst,aristois,future,inertia,salhack,kami,liquidbounce,lambda,b0mb,bleachhack,fdpclient,gamesense,kopykate,novoline,phobos,seppuku,sigma,tenacity,toxicclient\n";
    }

    void loadConfig() {
        CONFIG = SimpleConfig.of(Anticheat.MOD_ID).provider(this::configProvider).request();

        // Parse allowed mods list from config + built-in defaults
        allowedMods = new HashSet<>(Arrays.asList(
                CONFIG.getOrDefault(KEY_ALLOWED_MODS, "").split(",")
        ));
        allowedMods.remove("");

        // Add built-in Fabric API / Fabric Loader mods that are always allowed
        allowedMods.addAll(Arrays.asList(
                "fabric-convention-tags-v1", "fabric-biome-api-v1", "fabric-api",
                "fabric-rendering-fluids-v1", "fabric-transfer-api-v1", "fabric-dimensions-v1",
                "fabric-block-view-api-v2", "fabric-screen-handler-api-v1", "fabric-loot-api-v2",
                "fabric-api-lookup-api-v1", "fabric-recipe-api-v1", "fabric-renderer-registries-v1",
                "mixinextras", "fabric-data-generation-api-v1", "minecraft",
                "fabric-keybindings-v0", "fabric-command-api-v2", "fabric-blockrenderlayer-v1",
                "fabric-screen-api-v1", "fabric-events-interaction-v0", "fabric-registry-sync-v0",
                "fabric-entity-events-v1", "fabric-message-api-v1", "fabric-particles-v1",
                "fabric-key-binding-api-v1", "fabric-renderer-api-v1", "fabric-commands-v0",
                "fabric-rendering-v1", "fabric-block-api-v1", "fabric-rendering-v0",
                "fabric-lifecycle-events-v1", "fabric-model-loading-api-v1", "fabric-sound-api-v1",
                "fabric-data-attachment-api-v1", "fabric-item-api-v1", "fabric-client-tags-api-v1",
                "fabric-resource-conditions-api-v1", "java", "fabric-game-rule-api-v1",
                "fabric-networking-api-v1", "fabric-resource-loader-v0", "fabric-command-api-v1",
                "fabric-renderer-indigo", "fabric-api-base", "fabric-content-registries-v0",
                "fabric-object-builder-api-v1", "cobbleverse-anticheat", "fabricloader",
                "fabric-gametest-api-v1", "fabric-transitive-access-wideners-v1",
                "fabric-item-group-api-v1", "fabric-convention-tags-v2",
                "fabric-rendering-data-attachment-v1", "fabric-crash-report-info-v1",
                "fabric-loot-api-v3"
        ));

        // Parse exempt groups
        exemptGroups = new ArrayList<>(Arrays.asList(
                CONFIG.getOrDefault(KEY_EXEMPT_GROUPS, "admin,staff+,staff,builder").split(",")
        ));
        exemptGroups.removeIf(String::isEmpty);

        // Parse banned mods (cheat clients)
        bannedMods = new HashSet<>(Arrays.asList(
                CONFIG.getOrDefault(KEY_BANNED_MODS, "").split(",")
        ));
        bannedMods.remove("");

        Anticheat.LOGGER.info("Loaded config: {} allowed mods, {} exempt groups, {} banned mods",
                allowedMods.size(), exemptGroups.size(), bannedMods.size());
    }

    @Override
    public void onInitializeServer() {
        loadConfig();

        // Register the C2S receiver for mod list payloads
        ServerPlayNetworking.registerGlobalReceiver(ModListPayload.ID, (payload, context) -> {
            MinecraftServer server = context.server();
            var player = context.player();

            if (player == null) return;

            UUID uuid = player.getUuid();
            String playerName = player.getName().getString();
            List<String> modList = payload.mods();

            // Clear pending check (client responded in time)
            pendingChecks.remove(uuid);

            // Check LuckPerms exemptions
            if (isPlayerExempt(server, uuid)) {
                Anticheat.LOGGER.info("[LatamRust] Player '{}' is exempt (LuckPerms group), skipping check",
                        playerName);
                logModList(playerName, modList, "EXEMPT");
                return;
            }

            // Check BANNED mods FIRST (cheat clients) — kick even if whitelisted
            List<String> bannedFound = new ArrayList<>();
            for (String modId : modList) {
                if (bannedMods.contains(modId)) {
                    bannedFound.add(modId);
                }
            }
            if (!bannedFound.isEmpty()) {
                logModList(playerName, modList, "BANNED MOD: " + bannedFound);
                Anticheat.LOGGER.warn("[LatamRust] Player '{}' has BANNED mods (cheat client): {}",
                        playerName, bannedFound);
                String banKick = "§c[LatamRust Core] §fCheat client detected: §e"
                        + String.join(", ", bannedFound)
                        + "§c\n§7Cheating is not allowed on CobbleVerse.";
                player.networkHandler.disconnect(Text.literal(banKick));
                alertOnlineAdmins(server, playerName, bannedFound);
                return;
            }

            // Check mod list against whitelist
            List<String> unauthorizedMods = new ArrayList<>();
            for (String modId : modList) {
                if (!allowedMods.contains(modId)) {
                    unauthorizedMods.add(modId);
                }
            }

            // Log the mod list regardless of result
            if (unauthorizedMods.isEmpty()) {
                logModList(playerName, modList, "OK");
                Anticheat.LOGGER.info("[LatamRust] Player '{}' passed mod check ({} mods OK)",
                        playerName, modList.size());
            } else {
                logModList(playerName, modList, "VIOLATION: " + unauthorizedMods);

                Anticheat.LOGGER.warn("[LatamRust] Player '{}' has UNAUTHORIZED mods: {}",
                        playerName, unauthorizedMods);

                // Kick the player
                String kickMessage = "§c[LatamRust Core] §fUnauthorized modifications detected:\n" +
                        "§e" + String.join(", ", unauthorizedMods) + "\n\n" +
                        "§7Please remove these mods to play on CobbleVerse.";
                player.networkHandler.disconnect(Text.literal(kickMessage));

                // Alert online admins
                alertOnlineAdmins(server, playerName, unauthorizedMods);
            }
        });

        // Send mod-check request when a player enters PLAY phase
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            UUID uuid = handler.getPlayer().getUuid();
            String playerName = handler.getPlayer().getName().getString();

            Anticheat.LOGGER.info("[LatamRust] Player '{}' joined, requesting mod list...", playerName);

            // Send request to client
            ServerPlayNetworking.send(handler.getPlayer(), new RequestModsPayload());

            // Track pending check for timeout
            pendingChecks.put(uuid, System.nanoTime());

            // Schedule timeout - if client doesn't respond, kick them
            scheduler.schedule(() -> {
                if (pendingChecks.remove(uuid) != null) {
                    // Client did not respond in time - disconnect
                    server.execute(() -> {
                        var player = server.getPlayerManager().getPlayer(uuid);
                        if (player != null) {
                            Anticheat.LOGGER.warn("[LatamRust] Player '{}' timed out - no mod list received",
                                    player.getName().getString());
                            player.networkHandler.disconnect(Text.literal(
                                    "§c[LatamRust Core] §fLatamRust Core check timed out. " +
                                    "Please make sure the LatamRust Core mod is installed."));
                        }
                    });
                }
            }, MOD_CHECK_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        });

        Anticheat.LOGGER.info("[LatamRust] Server-side verification initialized (v2.1.0 - deny-list)");
    }

    /**
     * Check if a player is exempt from verification via LuckPerms groups.
     * Returns false if LuckPerms is not available (fail closed).
     */
    private boolean isPlayerExempt(MinecraftServer server, UUID playerUuid) {
        try {
            net.luckperms.api.LuckPerms lpApi = getLuckPermsApi();
            if (lpApi == null) {
                Anticheat.LOGGER.debug("[LatamRust] LuckPerms not available, no exemptions possible");
                return false;
            }

            var userManager = lpApi.getUserManager();
            var userFuture = userManager.loadUser(playerUuid);
            var user = userFuture.join();

            if (user == null) {
                Anticheat.LOGGER.debug("[LatamRust] LuckPerms user not found for UUID: {}", playerUuid);
                return false;
            }

            // Check if player has any exempt group
            for (String group : exemptGroups) {
                String node = "group." + group.trim();
                for (Node n : user.getNodes()) {
                    if (n.getKey().equals(node)) {
                        return true;
                    }
                }
            }

            return false;
        } catch (Exception e) {
            Anticheat.LOGGER.error("[LatamRust] Error checking LuckPerms exemption: {}", e.getMessage());
            return false; // On error, don't exempt (fail closed)
        }
    }

    /**
     * Send alert to all online players who have the cobbleverse.anticheat.alert permission.
     */
    private void alertOnlineAdmins(MinecraftServer server, String playerName, List<String> unauthorizedMods) {
        try {
            net.luckperms.api.LuckPerms lpApi = getLuckPermsApi();
            if (lpApi == null) {
                Anticheat.LOGGER.warn("[LatamRust] LuckPerms not available - cannot send admin alerts");
                return;
            }

            String alertMessage = "§c§l\u26a0 [LatamRust] §cPlayer §e" + playerName +
                    " §chas unauthorized mods: §f" + String.join(", ", unauthorizedMods);

            for (var onlinePlayer : server.getPlayerManager().getPlayerList()) {
                try {
                    var lpUser = lpApi.getUserManager().getUser(onlinePlayer.getUuid());
                    if (lpUser != null) {
                        var permData = lpUser.getCachedData().getPermissionData();
                        if (permData.checkPermission("latamrust.alert").asBoolean()) {
                            onlinePlayer.sendMessage(Text.literal(alertMessage), false);
                        }
                    }
                } catch (Exception e) {
                    Anticheat.LOGGER.debug("[LatamRust] Could not check permissions for {}: {}",
                            onlinePlayer.getName().getString(), e.getMessage());
                }
            }
        } catch (Exception e) {
            Anticheat.LOGGER.error("[LatamRust] Error sending admin alerts: {}", e.getMessage());
        }
    }

    /**
     * Log the player's mod list to logs/latamrust/<player>.log
     * Creates the directory and file if they don't exist.
     */
    private void logModList(String playerName, List<String> modList, String status) {
        try {
            // Get server run directory
            Path gameDir = net.fabricmc.loader.api.FabricLoader.getInstance().getGameDir();
            Path logDir = gameDir.resolve("logs").resolve("anticheat");
            Files.createDirectories(logDir);

            // Sanitize player name for filename (remove characters invalid in filenames)
            String safeFileName = playerName.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            Path playerLog = logDir.resolve(safeFileName + ".log");

            String timestamp = LocalDateTime.now().toString();
            String entry = String.format("[%s] Status: %s | Mods (%d): %s%n",
                    timestamp, status, modList.size(), String.join(", ", modList));

            Files.write(playerLog,
                    entry.getBytes(StandardCharsets.UTF_8),
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.APPEND);
        } catch (IOException e) {
            Anticheat.LOGGER.error("[LatamRust] Failed to write log for {}: {}", playerName, e.getMessage());
        }
    }

    // ── LuckPerms API access ──

    private static net.luckperms.api.LuckPerms cachedLpApi = null;
    private static boolean luckpermsApiResolved = false;

    /**
     * Get LuckPerms API instance. Caches the result.
     * Returns null if LuckPerms is not available on the server.
     */
    private static net.luckperms.api.LuckPerms getLuckPermsApi() {
        if (luckpermsApiResolved) {
            return cachedLpApi;
        }

        try {
            cachedLpApi = net.luckperms.api.LuckPermsProvider.get();
            luckpermsApiResolved = true;
            Anticheat.LOGGER.info("[LatamRust] LuckPerms API connected successfully");
            return cachedLpApi;
        } catch (IllegalStateException e) {
            Anticheat.LOGGER.warn("[LatamRust] LuckPerms not available: {}", e.getMessage());
            cachedLpApi = null;
            luckpermsApiResolved = true;
            return null;
        } catch (Exception e) {
            Anticheat.LOGGER.error("[LatamRust] Unexpected error accessing LuckPerms: {}", e.getMessage());
            cachedLpApi = null;
            luckpermsApiResolved = true;
            return null;
        }
    }
}
