/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.reflect.TypeToken
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.f0cus.protectionstones;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u001c\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2={"Lcom/f0cus/protectionstones/CBHeadAPI;", "", "<init>", "()V", "", "input", "getTexture", "(Ljava/lang/String;)Ljava/lang/String;", "name", "fetchFromAPI", "API_KEY", "Ljava/lang/String;", "BASE_URL", "Ljava/net/http/HttpClient;", "kotlin.jvm.PlatformType", "client", "Ljava/net/http/HttpClient;", "Lcom/google/gson/Gson;", "GSON", "Lcom/google/gson/Gson;", "Ljava/util/concurrent/ConcurrentHashMap;", "textureCache", "Ljava/util/concurrent/ConcurrentHashMap;", "HeadData", "ClaimBlocks"})
public final class CBHeadAPI {
    @NotNull
    public static final CBHeadAPI INSTANCE = new CBHeadAPI();
    @NotNull
    private static final String API_KEY = "QpOxIaa2+CQ+rMRUGIVKvAruidD1LrZlQk0o8oV6qxpFoAmPp8yAAiZIm9ytMT4hb7LKgQvREku7TD9T1N60yQ==";
    @NotNull
    private static final String BASE_URL = "https://minecraft-heads.com/scripts/api.php";
    private static final HttpClient client = HttpClient.newHttpClient();
    @NotNull
    private static final Gson GSON = new Gson();
    @NotNull
    private static final ConcurrentHashMap<String, String> textureCache = new ConcurrentHashMap();

    private CBHeadAPI() {
    }

    @Nullable
    public final String getTexture(@NotNull String input) {
        String string;
        Intrinsics.checkNotNullParameter((Object)input, (String)"input");
        if (StringsKt.isBlank((CharSequence)input)) {
            return null;
        }
        if (StringsKt.startsWith$default((String)input, (String)"eyJ", (boolean)false, (int)2, null)) {
            return input;
        }
        String string2 = textureCache.get(input);
        if (string2 != null) {
            String it = string2;
            boolean bl = false;
            return it;
        }
        String query = StringsKt.contains$default((CharSequence)input, (CharSequence)"minecraft-heads.com", (boolean)false, (int)2, null) ? StringsKt.substringAfterLast$default((String)input, (String)"/", null, (int)2, null) : input;
        try {
            String string3;
            String response = this.fetchFromAPI(query);
            if (response != null) {
                ((Map)textureCache).put(input, response);
                string3 = response;
            } else {
                string3 = null;
            }
            string = string3;
        }
        catch (Exception e) {
            System.out.println((Object)("[ClaimBlocks] Error fetching head from API: " + e.getMessage()));
            string = null;
        }
        return string;
    }

    private final String fetchFromAPI(String name) {
        URI uri = URI.create("https://minecraft-heads.com/scripts/api.php?out=json&search=" + StringsKt.replace$default((String)name, (String)" ", (String)"%20", (boolean)false, (int)4, null));
        HttpRequest request = HttpRequest.newBuilder().uri(uri).header("API-Key", API_KEY).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            Type type2 = new TypeToken<List<? extends HeadData>>(){}.getType();
            Object object = GSON.fromJson(response.body(), type2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"fromJson(...)");
            List results = (List)object;
            HeadData headData = (HeadData)CollectionsKt.firstOrNull((List)results);
            return headData != null ? headData.getValue() : null;
        }
        return null;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\tJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\t\u00a8\u0006\u001a"}, d2={"Lcom/f0cus/protectionstones/CBHeadAPI$HeadData;", "", "", "name", "uuid", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/f0cus/protectionstones/CBHeadAPI$HeadData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName", "getUuid", "getValue", "ClaimBlocks"})
    public static final class HeadData {
        @NotNull
        private final String name;
        @NotNull
        private final String uuid;
        @NotNull
        private final String value;

        public HeadData(@NotNull String name, @NotNull String uuid, @NotNull String value) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            this.name = name;
            this.uuid = uuid;
            this.value = value;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUuid() {
            return this.uuid;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.uuid;
        }

        @NotNull
        public final String component3() {
            return this.value;
        }

        @NotNull
        public final HeadData copy(@NotNull String name, @NotNull String uuid, @NotNull String value) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            return new HeadData(name, uuid, value);
        }

        public static /* synthetic */ HeadData copy$default(HeadData headData, String string, String string2, String string3, int n, Object object) {
            if ((n & 1) != 0) {
                string = headData.name;
            }
            if ((n & 2) != 0) {
                string2 = headData.uuid;
            }
            if ((n & 4) != 0) {
                string3 = headData.value;
            }
            return headData.copy(string, string2, string3);
        }

        @NotNull
        public String toString() {
            return "HeadData(name=" + this.name + ", uuid=" + this.uuid + ", value=" + this.value + ")";
        }

        public int hashCode() {
            int result = this.name.hashCode();
            result = result * 31 + this.uuid.hashCode();
            result = result * 31 + this.value.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeadData)) {
                return false;
            }
            HeadData headData = (HeadData)other;
            if (!Intrinsics.areEqual((Object)this.name, (Object)headData.name)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.uuid, (Object)headData.uuid)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.value, (Object)headData.value);
        }
    }
}
