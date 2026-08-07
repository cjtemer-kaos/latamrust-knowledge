/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.reflect.TypeToken
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  net.fabricmc.loader.api.FabricLoader
 *  org.jetbrains.annotations.NotNull
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.StoneConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R.\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2={"Lcom/f0cus/protectionstones/CBConfig;", "", "<init>", "()V", "", "", "Lcom/f0cus/protectionstones/StoneConfig;", "getDefaultConfig", "()Ljava/util/Map;", "", "load", "save", "generateReadme", "Lcom/google/gson/Gson;", "GSON", "Lcom/google/gson/Gson;", "Ljava/io/File;", "kotlin.jvm.PlatformType", "configDir", "Ljava/io/File;", "configFile", "stones", "Ljava/util/Map;", "getStones", "setStones", "(Ljava/util/Map;)V", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBConfig.kt\ncom/f0cus/protectionstones/CBConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
public final class CBConfig {
    @NotNull
    public static final CBConfig INSTANCE = new CBConfig();
    @NotNull
    private static final Gson GSON;
    private static final File configDir;
    @NotNull
    private static final File configFile;
    @NotNull
    private static Map<String, StoneConfig> stones;

    private CBConfig() {
    }

    @NotNull
    public final Map<String, StoneConfig> getStones() {
        return stones;
    }

    public final void setStones(@NotNull Map<String, StoneConfig> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<set-?>");
        stones = map;
    }

    private final Map<String, StoneConfig> getDefaultConfig() {
        String help = "Use the 'Value' code (Base64) from minecraft-heads.com for custom textures";
        String defaultHead = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDk4NDhkZGU4ZTUzMGRjNzA1ZmI2NzdkYWQ4MTQ5MmNjMjIyYmY5NmZkNjMyYjg1MTRhZWZiODA5MzFmZTBkIn19fQ==";
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)"template1", (Object)new StoneConfig(10, 10, help, defaultHead, "&8&lClaim Module &f- &5T1")), TuplesKt.to((Object)"template2", (Object)new StoneConfig(20, 20, help, defaultHead, "&8&lClaim Module &f- &5T2")), TuplesKt.to((Object)"template3", (Object)new StoneConfig(30, 30, help, defaultHead, "&8&lClaim Module &f- &5T3")), TuplesKt.to((Object)"template4", (Object)new StoneConfig(40, 40, help, defaultHead, "&8&lClaim Module &f- &5T4")), TuplesKt.to((Object)"template5", (Object)new StoneConfig(50, 50, help, defaultHead, "&8&lClaim Module &f- &5T5")), TuplesKt.to((Object)"template6", (Object)new StoneConfig(75, 75, help, defaultHead, "&8&lClaim Module &f- &5T6")), TuplesKt.to((Object)"template7", (Object)new StoneConfig(100, 100, help, defaultHead, "&8&lClaim Module &f- &5T7")), TuplesKt.to((Object)"template8", (Object)new StoneConfig(150, 150, help, defaultHead, "&8&lClaim Module &f- &5T8"))};
        return MapsKt.mapOf((Pair[])pairArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void load() {
        if (!configDir.exists()) {
            configDir.mkdirs();
        }
        this.generateReadme();
        if (!configFile.exists()) {
            System.out.println((Object)"[ClaimBlocks] Config file not found, creating default.");
            stones = this.getDefaultConfig();
            this.save();
        } else {
            try {
                Object object = configFile;
                Object object2 = Charsets.UTF_8;
                object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
                object2 = null;
                try {
                    InputStreamReader reader = (InputStreamReader)object;
                    boolean bl = false;
                    Type type2 = new TypeToken<Map<String, ? extends StoneConfig>>(){}.getType();
                    Map loadedStones = (Map)GSON.fromJson((Reader)reader, type2);
                    Object object3 = loadedStones;
                    if (object3 == null || object3.isEmpty()) {
                        object3 = "[ClaimBlocks] Config file was empty or corrupted, rebuilding with default settings.";
                        System.out.println(object3);
                        stones = INSTANCE.getDefaultConfig();
                        INSTANCE.save();
                    } else {
                        stones = loadedStones;
                    }
                    System.out.println((Object)("[ClaimBlocks] Loaded " + stones.size() + " stone configurations."));
                    Unit unit = Unit.INSTANCE;
                }
                catch (Throwable throwable) {
                    object2 = throwable;
                    throw throwable;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
                }
            }
            catch (Exception e) {
                System.out.println((Object)("[ClaimBlocks] Error loading config: " + e.getMessage() + ". Resetting file."));
                stones = this.getDefaultConfig();
                this.save();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void save() {
        try {
            Object object = configFile;
            Object object2 = Charsets.UTF_8;
            object = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), (Charset)object2);
            object2 = null;
            try {
                OutputStreamWriter writer = (OutputStreamWriter)object;
                boolean bl = false;
                GSON.toJson(stones, (Appendable)writer);
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable) {
                object2 = throwable;
                throw throwable;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void generateReadme() {
        File readmeFile = new File(configDir, "README.md");
        if (readmeFile.exists()) {
            return;
        }
        String content = "# \ud83d\udee1\ufe0f ClaimBlocks - Professional Protection System\n\n**ClaimBlocks** is a powerful and lightweight protection mod for Fabric, designed to provide a professional security environment using \"Claim Modules\" (blocks or custom heads).\n\n---\n\n## \ud83d\ude80 Commands\n\n| Command | Permission | Description |\n| :--- | :--- | :--- |\n| `/cb` | `cb.user` | Displays the help menu with all available commands. |\n| `/cb menu` | `cb.user` | Opens the management interface for your own protections. |\n| `/cb menu <player>` | `cb.admin` | **(Admin)** Opens the protection list of another player. |\n| `/cb view` | `cb.user` | Toggles the visual boundaries (particles) of the current zone. |\n| `/cb delete` | `cb.user` | Deletes the protection you are looking at (must be the owner/admin). |\n| `/cb add <player>` | `cb.user` | Quickly adds a member to the protection you are standing in. |\n| `/cb info` | `cb.admin` | **(Admin)** Displays technical info about the current protection. |\n| `/cb get <type>` | `cb.admin` | **(Admin)** Gives you 1x of a specific protection module. |\n| `/cb give <p> <t> <n>` | `cb.admin` | **(Admin)** Gives `n` modules of type `t` to player `p`. |\n\n---\n\n## \ud83d\udee0\ufe0f Management Interface (GUI)\n\nWhen you open a protection in the menu, you have several specialized tools:\n\n1.  **\ud83d\udea9 Configure Flags**: Manage PvP, Mob Spawning, Hunger, TNT, and more.\n2.  **\ud83d\udc65 Manage Members**: Add or remove players from your protection.\n3.  **\u2728 Set Title**: Configure custom titles and subtitles shown when entering the area.\n4.  **\ud83c\udff7\ufe0f Rename**: Change the display name of your zone for easier identification.\n5.  **\ud83d\udccd Location**: Shows the exact coordinates of the module in chat.\n6.  **\ud83d\udc41\ufe0f Hide Module**: Physically removes the protection block/head from the world.\n7.  **\ud83d\ude80 Teleport**: **(Admin)** Instantly teleport to the protection's center.\n8.  **\ud83d\uddd1\ufe0f Delete**: Permanently removes the protection and returns the module to your inventory.\n\n---\n\n## \u2699\ufe0f Configuration Files\n\nAll configurations are located in `config/ClaimBlocks/`:\n\n*   **`settings.json`**: Define your protection modules. You can set the radius (X/Z), custom display names, and textures using Base64 codes from [minecraft-heads.com](https://minecraft-heads.com).\n*   **`texts.json`**: Fully customize every message, GUI label, and lore shown in the mod. Supports color codes and formatting.\n*   **`claims.json`**: The core database containing all active protections.\n\n---\n\n## \ud83d\udcc2 Data Files (World Folder)\n\nThe following data is stored specifically for each world in `world/claimblocks/`:\n\n*   **`player_data.json`**: An index for quick lookup of protections owned by each player.\n\n---\n\n## \ud83d\udd11 Permissions\n\n*   **`cb.user`**: Default access for all players. Allows placing modules and basic management.\n*   **`cb.admin`**: Full administrative access. Allows managing any protection, teleporting, and using \"give\" commands.";
        try {
            FilesKt.writeText$default((File)readmeFile, (String)content, null, (int)2, null);
            System.out.println((Object)"[ClaimBlocks] Generated README.md in config folder.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue((Object)gson, (String)"create(...)");
        GSON = gson;
        configDir = FabricLoader.getInstance().getConfigDir().resolve("ClaimBlocks").toFile();
        configFile = new File(configDir, "settings.json");
        stones = MapsKt.emptyMap();
    }
}
