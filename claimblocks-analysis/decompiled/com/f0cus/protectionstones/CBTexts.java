/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  net.fabricmc.loader.api.FabricLoader
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import com.f0cus.protectionstones.TextsConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0003R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2={"Lcom/f0cus/protectionstones/CBTexts;", "", "<init>", "()V", "", "load", "save", "Lcom/f0cus/protectionstones/TextsConfig;", "config", "Lcom/f0cus/protectionstones/TextsConfig;", "getConfig", "()Lcom/f0cus/protectionstones/TextsConfig;", "setConfig", "(Lcom/f0cus/protectionstones/TextsConfig;)V", "Ljava/io/File;", "textsFile", "Ljava/io/File;", "Lcom/google/gson/Gson;", "GSON", "Lcom/google/gson/Gson;", "ClaimBlocks"})
@SourceDebugExtension(value={"SMAP\nCBTexts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CBTexts.kt\ncom/f0cus/protectionstones/CBTexts\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
public final class CBTexts {
    @NotNull
    public static final CBTexts INSTANCE = new CBTexts();
    @NotNull
    private static TextsConfig config = new TextsConfig(null, null, null, null, null, 31, null);
    @Nullable
    private static File textsFile;
    @NotNull
    private static final Gson GSON;

    private CBTexts() {
    }

    @NotNull
    public final TextsConfig getConfig() {
        return config;
    }

    public final void setConfig(@NotNull TextsConfig textsConfig) {
        Intrinsics.checkNotNullParameter((Object)textsConfig, (String)"<set-?>");
        config = textsConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void load() {
        File dir = FabricLoader.getInstance().getConfigDir().resolve("ClaimBlocks").toFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = textsFile = new File(dir, "texts.json");
        boolean bl = file != null ? file.exists() : false;
        if (bl) {
            try {
                Unit unit;
                File file2 = textsFile;
                if (file2 != null) {
                    Object object = file2;
                    Object object2 = Charsets.UTF_8;
                    object = new InputStreamReader((InputStream)new FileInputStream((File)object), (Charset)object2);
                    object2 = null;
                    try {
                        InputStreamReader reader = (InputStreamReader)object;
                        boolean bl2 = false;
                        Object object3 = GSON.fromJson((Reader)reader, TextsConfig.class);
                        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"fromJson(...)");
                        config = (TextsConfig)object3;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    catch (Throwable throwable) {
                        object2 = throwable;
                        throw throwable;
                    }
                    finally {
                        CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Unit unit3 = unit;
            }
            catch (Exception e) {
                e.printStackTrace();
                Unit unit = Unit.INSTANCE;
            }
        } else {
            this.save();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void save() {
        block8: {
            if (textsFile == null) {
                return;
            }
            try {
                File file = textsFile;
                if (file == null) break block8;
                Object object = file;
                Object object2 = Charsets.UTF_8;
                object = new OutputStreamWriter((OutputStream)new FileOutputStream((File)object), (Charset)object2);
                object2 = null;
                try {
                    OutputStreamWriter writer = (OutputStreamWriter)object;
                    boolean bl = false;
                    GSON.toJson((Object)config, (Appendable)writer);
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

    static {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue((Object)gson, (String)"create(...)");
        GSON = gson;
    }
}
