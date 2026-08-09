package com.cobbleverse.staffpanel.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Simplified jail system - allows movement within jail cell
 * Uses real time (not game time) with JSON persistence
 * All coordinates loaded from config file (no hardcoded values)
 */
public class JailSystem {
    
    // Jail coordinates (loaded from config file)
    private static int jailX = 0;
    private static int jailY = -60;
    private static int jailZ = 0;
    private static int jailRadius = 10;
    
    // Track jailed players: UUID -> release time (milliseconds)
    private static final Map<UUID, Long> jailedPlayers = new HashMap<>();
    
    // Config file
    private static final String CONFIG_FILE = "staffpanel-jail.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    /**
     * Load jail coordinates from config file
     */
    public static void loadConfig(File configDir) {
        File file = new File(configDir, CONFIG_FILE);
        if (!file.exists()) {
            // Create default config
            saveConfig(configDir);
            return;
        }
        
        try (Reader reader = new FileReader(file)) {
            Map<String, Object> config = GSON.fromJson(reader, new TypeToken<Map<String, Object>>(){}.getType());
            if (config != null) {
                jailX = ((Number) config.getOrDefault("x", 0)).intValue();
                jailY = ((Number) config.getOrDefault("y", -60)).intValue();
                jailZ = ((Number) config.getOrDefault("z", 0)).intValue();
                jailRadius = ((Number) config.getOrDefault("radius", 10)).intValue();
                System.out.println("[StaffPanel] Jail config loaded: " + jailX + "," + jailY + "," + jailZ + " radius=" + jailRadius);
            }
        } catch (Exception e) {
            System.err.println("[StaffPanel] Failed to load jail config: " + e.getMessage());
        }
    }
    
    /**
     * Save default config
     */
    private static void saveConfig(File configDir) {
        File dir = new File(configDir, "staffpanel");
        if (!dir.exists()) dir.mkdirs();
        
        File file = new File(dir, CONFIG_FILE);
        Map<String, Object> config = new HashMap<>();
        config.put("x", 0);
        config.put("y", -60);
        config.put("z", 0);
        config.put("radius", 10);
        config.put("comment", "Jail coordinates and radius. Change these to your jail location.");
        
        try (Writer writer = new FileWriter(file)) {
            GSON.toJson(config, writer);
            System.out.println("[StaffPanel] Default jail config created at: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("[StaffPanel] Failed to create jail config: " + e.getMessage());
        }
    }
    
    /**
     * Load jail data from JSON file
     */
    public static void loadData(File configDir) {
        File file = new File(configDir, "staffpanel/jail-data.json");
        if (!file.exists()) {
            System.out.println("[StaffPanel] No jail data file found, starting fresh");
            return;
        }
        
        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, Long>>(){}.getType();
            Map<String, Long> saved = GSON.fromJson(reader, type);
            
            if (saved != null) {
                long now = System.currentTimeMillis();
                for (Map.Entry<String, Long> entry : saved.entrySet()) {
                    UUID uuid = UUID.fromString(entry.getKey());
                    long releaseTime = entry.getValue();
                    
                    // Only load if not expired
                    if (releaseTime > now) {
                        jailedPlayers.put(uuid, releaseTime);
                    }
                }
                System.out.println("[StaffPanel] Loaded " + jailedPlayers.size() + " jailed players from file");
            }
        } catch (Exception e) {
            System.err.println("[StaffPanel] Failed to load jail data: " + e.getMessage());
        }
    }
    
    /**
     * Save jail data to JSON file
     */
    public static void saveData(File configDir) {
        File dir = new File(configDir, "staffpanel");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        File file = new File(dir, "jail-data.json");
        
        try (Writer writer = new FileWriter(file)) {
            Map<String, Long> toSave = new HashMap<>();
            for (Map.Entry<UUID, Long> entry : jailedPlayers.entrySet()) {
                toSave.put(entry.getKey().toString(), entry.getValue());
            }
            GSON.toJson(toSave, writer);
            System.out.println("[StaffPanel] Saved " + toSave.size() + " jailed players to file");
        } catch (Exception e) {
            System.err.println("[StaffPanel] Failed to save jail data: " + e.getMessage());
        }
    }
    
    /**
     * Parse time string like "24hs", "30min", "2d" to milliseconds
     */
    private static long parseTimeToMillis(String timeStr) {
        timeStr = timeStr.toLowerCase().trim();
        
        if (timeStr.endsWith("hs") || timeStr.endsWith("h")) {
            String num = timeStr.replaceAll("[^0-9]", "");
            return Long.parseLong(num) * 60 * 60 * 1000L;
        } else if (timeStr.endsWith("min") || timeStr.endsWith("m")) {
            String num = timeStr.replaceAll("[^0-9]", "");
            return Long.parseLong(num) * 60 * 1000L;
        } else if (timeStr.endsWith("d")) {
            String num = timeStr.replaceAll("[^0-9]", "");
            return Long.parseLong(num) * 24 * 60 * 60 * 1000L;
        } else if (timeStr.endsWith("s")) {
            String num = timeStr.replaceAll("[^0-9]", "");
            return Long.parseLong(num) * 1000L;
        } else {
            String num = timeStr.replaceAll("[^0-9]", "");
            return Long.parseLong(num) * 60 * 1000L;
        }
    }
    
    /**
     * Format milliseconds to readable string
     */
    private static String formatTimeRemaining(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        
        if (days > 0) {
            return days + "d " + (hours % 24) + "h " + (minutes % 60) + "min";
        } else if (hours > 0) {
            return hours + "h " + (minutes % 60) + "min";
        } else if (minutes > 0) {
            return minutes + "min " + (seconds % 60) + "s";
        } else {
            return seconds + "s";
        }
    }
    
    /**
     * Jail a player - simple command: /jail jail1 <player> [time]
     */
    public static void jailPlayer(ServerPlayerEntity staff, String targetName, String timeStr, File configDir) {
        ServerPlayerEntity target = staff.getServer().getPlayerManager().getPlayer(targetName);
        if (target == null) {
            staff.sendMessage(Text.literal("§4§l[Staff] §7Jugador §f" + targetName + " §7no encontrado"), false);
            return;
        }
        
        long durationMillis = parseTimeToMillis(timeStr);
        long releaseTime = System.currentTimeMillis() + durationMillis;
        
        // Teleport to jail
        staff.getServer().getCommandManager().executeWithPrefix(
            staff.getCommandSource(),
            "tp " + targetName + " " + jailX + " " + (jailY + 1) + " " + jailZ
        );
        
        // Mark as jailed
        jailedPlayers.put(target.getUuid(), releaseTime);
        
        // Save to file
        saveData(configDir);
        
        // Notify
        String timeFormatted = formatTimeRemaining(durationMillis);
        staff.sendMessage(Text.literal("§b§l[Staff] §7Enviaste a §f" + targetName + " §7a la carcel por §f" + timeFormatted), false);
        target.sendMessage(Text.literal("§4§l[Carcel] §7Has sido encarcelado por §f" + staff.getName().getString()), false);
        target.sendMessage(Text.literal("§4§l[Carcel] §7Duración: §f" + timeFormatted), false);
        target.sendMessage(Text.literal("§4§l[Carcel] §7Puedes moverte dentro de la celda (§f" + jailRadius + "§7 bloques)"), false);
    }
    
    /**
     * Unjail a player - simple command: /jail unjail1 <player>
     */
    public static void unjailPlayer(ServerPlayerEntity staff, String targetName, File configDir) {
        ServerPlayerEntity target = staff.getServer().getPlayerManager().getPlayer(targetName);
        if (target == null) {
            staff.sendMessage(Text.literal("§4§l[Staff] §7Jugador §f" + targetName + " §7no encontrado"), false);
            return;
        }
        
        if (!jailedPlayers.containsKey(target.getUuid())) {
            staff.sendMessage(Text.literal("§4§l[Staff] §7Jugador §f" + targetName + " §7no esta en la carcel"), false);
            return;
        }
        
        jailedPlayers.remove(target.getUuid());
        saveData(configDir);
        
        staff.sendMessage(Text.literal("§2§l[Staff] §7Liberaste a §f" + targetName + " §7de la carcel"), false);
        target.sendMessage(Text.literal("§a§l[Carcel] §7Has sido liberado por §f" + staff.getName().getString()), false);
    }
    
    /**
     * Check boundaries and auto-release
     */
    public static void checkJailBoundaries(ServerPlayerEntity player, File configDir) {
        if (!jailedPlayers.containsKey(player.getUuid())) {
            return;
        }
        
        long releaseTime = jailedPlayers.get(player.getUuid());
        long currentTime = System.currentTimeMillis();
        
        // Time expired - release player
        if (currentTime >= releaseTime) {
            jailedPlayers.remove(player.getUuid());
            saveData(configDir);
            player.sendMessage(Text.literal("§a§l[Carcel] §7Tu tiempo de carcel ha terminado. ¡Eres libre!"), false);
            return;
        }
        
        // Check boundaries
        BlockPos playerPos = player.getBlockPos();
        double distance = Math.sqrt(
            Math.pow(playerPos.getX() - jailX, 2) +
            Math.pow(playerPos.getZ() - jailZ, 2)
        );
        
        if (distance > jailRadius) {
            player.getServer().getCommandManager().executeWithPrefix(
                player.getCommandSource(),
                "tp " + player.getName().getString() + " " + jailX + " " + playerPos.getY() + " " + jailZ
            );
            long remaining = releaseTime - currentTime;
            player.sendMessage(Text.literal("§4§l[Carcel] §7No puedes salir! Tiempo: §f" + formatTimeRemaining(remaining)), false);
        }
    }
    
    public static boolean isJailed(ServerPlayerEntity player) {
        return jailedPlayers.containsKey(player.getUuid());
    }
    
    public static long getJailTimeRemaining(ServerPlayerEntity player) {
        Long releaseTime = jailedPlayers.get(player.getUuid());
        if (releaseTime == null) return 0;
        return Math.max(0, releaseTime - System.currentTimeMillis());
    }
}
