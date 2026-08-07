/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.reflect.TypeToken
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  net.minecraft.class_5218
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.CBConfig;
import com.f0cus.protectionstones.CBRegion;
import com.f0cus.protectionstones.StoneConfig;
import com.f0cus.protectionstones.StoneLocationData;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_5218;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\u0003J\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017R-\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00190\u0018j\u0002`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006%"}, d2={"Lcom/f0cus/protectionstones/CBLocationsManager;", "", "<init>", "()V", "Lnet/minecraft/class_3218;", "world", "", "load", "(Lnet/minecraft/class_3218;)V", "save", "Ljava/util/UUID;", "ownerId", "Lcom/f0cus/protectionstones/CBRegion;", "region", "addLocation", "(Ljava/util/UUID;Lcom/f0cus/protectionstones/CBRegion;)V", "Lnet/minecraft/class_2338;", "centerPos", "removeLocation", "(Ljava/util/UUID;Lnet/minecraft/class_2338;)V", "", "Lcom/f0cus/protectionstones/StoneLocationData;", "getLocations", "(Ljava/util/UUID;)Ljava/util/List;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/f0cus/protectionstones/PlayerLocationsMap;", "playerLocations", "Ljava/util/concurrent/ConcurrentHashMap;", "getPlayerLocations", "()Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/io/File;", "locationsFile", "Ljava/io/File;", "Lcom/google/gson/Gson;", "GSON", "Lcom/google/gson/Gson;", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBLocationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBLocationManager.kt\ncom/f0cus/protectionstones/CBLocationsManager\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n216#2,2:92\n1#3:94\n*S KotlinDebug\n*F\n+ 1 CBLocationManager.kt\ncom/f0cus/protectionstones/CBLocationsManager\n*L\n41#1:92,2\n*E\n"})
public final class CBLocationsManager {
    @NotNull
    public static final CBLocationsManager INSTANCE = new CBLocationsManager();
    @NotNull
    private static final ConcurrentHashMap<UUID, List<StoneLocationData>> playerLocations = new ConcurrentHashMap();
    @Nullable
    private static File locationsFile;
    @NotNull
    private static final Gson GSON;

    private CBLocationsManager() {
    }

    @NotNull
    public final ConcurrentHashMap<UUID, List<StoneLocationData>> getPlayerLocations() {
        return playerLocations;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void load(@NotNull class_3218 world) {
        block11: {
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            File dir = world.method_8503().method_27050(class_5218.field_24188).resolve("claimblocks").toFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = locationsFile = new File(dir, "player_data.json");
            boolean bl = file != null ? file.exists() : false;
            if (bl) {
                try {
                    File file2 = locationsFile;
                    if (file2 == null) break block11;
                    Object object = file2;
                    Object object2 = Charsets.UTF_8;
                    object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
                    object2 = null;
                    try {
                        ConcurrentHashMap loadedList;
                        InputStreamReader reader = (InputStreamReader)object;
                        boolean bl2 = false;
                        Type type2 = new TypeToken<ConcurrentHashMap<UUID, List<StoneLocationData>>>(){}.getType();
                        ConcurrentHashMap concurrentHashMap = loadedList = (ConcurrentHashMap)GSON.fromJson((Reader)reader, type2);
                        if (concurrentHashMap != null) {
                            Map $this$forEach$iv = concurrentHashMap;
                            boolean $i$f$forEach = false;
                            Iterator iterator = $this$forEach$iv.entrySet().iterator();
                            while (iterator.hasNext()) {
                                Map.Entry element$iv;
                                Map.Entry entry = element$iv = iterator.next();
                                boolean bl3 = false;
                                UUID uuid = (UUID)entry.getKey();
                                List list = (List)entry.getValue();
                                ((Map)playerLocations).put(uuid, CollectionsKt.toMutableList((Collection)list));
                            }
                        }
                        System.out.println((Object)("[ClaimBlocks] Loaded " + playerLocations.size() + " player location entries."));
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
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void save() {
        block8: {
            if (locationsFile == null) {
                return;
            }
            try {
                File file = locationsFile;
                if (file == null) break block8;
                Object object = file;
                Object object2 = Charsets.UTF_8;
                object = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), (Charset)object2);
                object2 = null;
                try {
                    OutputStreamWriter writer = (OutputStreamWriter)object;
                    boolean bl = false;
                    GSON.toJson(playerLocations, (Appendable)writer);
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
    }

    public final void addLocation(@NotNull UUID ownerId, @NotNull CBRegion region) {
        Intrinsics.checkNotNullParameter((Object)ownerId, (String)"ownerId");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        StoneConfig stoneConfig = CBConfig.INSTANCE.getStones().get(region.getStoneType());
        if (stoneConfig == null) {
            return;
        }
        StoneConfig config = stoneConfig;
        int size = Math.max(config.getRadius_x(), config.getRadius_z());
        StoneLocationData locationData = new StoneLocationData(region.getStoneType(), size, region.getCenterBlock());
        playerLocations.computeIfAbsent(ownerId, arg_0 -> CBLocationsManager.addLocation$lambda$1(CBLocationsManager::addLocation$lambda$0, arg_0)).add(locationData);
        this.save();
    }

    public final void removeLocation(@NotNull UUID ownerId, @NotNull class_2338 centerPos) {
        Intrinsics.checkNotNullParameter((Object)ownerId, (String)"ownerId");
        Intrinsics.checkNotNullParameter((Object)centerPos, (String)"centerPos");
        List<StoneLocationData> list = playerLocations.get(ownerId);
        if (list == null) {
            return;
        }
        List<StoneLocationData> list2 = list;
        list2.removeIf(arg_0 -> CBLocationsManager.removeLocation$lambda$1(arg_0 -> CBLocationsManager.removeLocation$lambda$0(centerPos, arg_0), arg_0));
        if (list2.isEmpty()) {
            playerLocations.remove(ownerId);
        }
        this.save();
    }

    @NotNull
    public final List<StoneLocationData> getLocations(@NotNull UUID ownerId) {
        Intrinsics.checkNotNullParameter((Object)ownerId, (String)"ownerId");
        List list = playerLocations.get(ownerId);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    private static final List addLocation$lambda$0(UUID it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new ArrayList();
    }

    private static final List addLocation$lambda$1(Function1 $tmp0, Object p0) {
        return (List)$tmp0.invoke(p0);
    }

    private static final boolean removeLocation$lambda$0(class_2338 $centerPos, StoneLocationData it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Intrinsics.areEqual((Object)it.getCoords(), (Object)$centerPos);
    }

    private static final boolean removeLocation$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    static {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue((Object)gson, (String)"create(...)");
        GSON = gson;
    }
}
