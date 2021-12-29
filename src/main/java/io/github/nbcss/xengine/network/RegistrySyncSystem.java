package io.github.nbcss.xengine.network;

import com.google.common.collect.Sets;
import io.github.nbcss.xengine.utils.Reflection;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundCustomPayloadPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.util.Set;

public class RegistrySyncSystem {
    private static final ResourceLocation ID = new ResourceLocation("fabric", "registry/sync");
    private static final Method GET_HANDLE = Reflection.bukkitMethod(
            "entity", "CraftPlayer", "getHandle");
    private static final Set<String> SYNC_TYPES = Sets.newHashSet(
            "minecraft:block",
            "minecraft:block_entity_type",
            "minecraft:item");
    private static CompoundTag cache = null;

    public static void sync(Player player){
        Packet<?> packet = getPacket();
        if(packet != null){
            ((ServerPlayer) Reflection.invoke(GET_HANDLE, player)).connection.send(packet);
        }
    }

    public static Packet<?> getPacket(){
        CompoundTag tag = toTag();
        if (tag == null) {
            return null;
        }

        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeNbt(tag);

        return new ClientboundCustomPayloadPacket(ID, buf);
    }

    @SuppressWarnings("unchecked")
    public static <T> CompoundTag toTag() {
        if(cache != null)
            return cache;
        CompoundTag mainTag = new CompoundTag();

        for (ResourceLocation registryId : Registry.REGISTRY.keySet()) {
            Registry<T> registry = (Registry<T>) Registry.REGISTRY.get(registryId);
            assert registry != null;

            if(!SYNC_TYPES.contains(registryId.toString())){
                continue;
            }

            CompoundTag registryTag = new CompoundTag();

            for (T o : registry) {
                ResourceLocation id = registry.getKey(o);
                if (id == null)
                    continue;
                int rawId = registry.getId(o);

                registryTag.putInt(id.toString(), rawId);
            }

            mainTag.put(registryId.toString(), registryTag);
        }

        if (mainTag.getAllKeys().isEmpty()) {
            return null;
        }

        CompoundTag tag = new CompoundTag();
        tag.putInt("version", 1);
        tag.put("registries", mainTag);
        cache = tag;
        return tag;
    }
}
