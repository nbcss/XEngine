package io.github.nbcss.xengine.network;

import com.google.common.collect.Sets;
import io.github.nbcss.xengine.utils.Reflection;
import io.netty.buffer.Unpooled;
import net.minecraft.core.IRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketDataSerializer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutCustomPayload;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.util.Set;

public class RegistrySyncSystem {
    private static final MinecraftKey ID = new MinecraftKey("fabric", "registry/sync");
    private static final Method GET_HANDLE = Reflection.bukkitMethod(
            "entity", "CraftPlayer", "getHandle");
    private static final Set<String> SYNC_TYPES = Sets.newHashSet(
            "minecraft:block",
            "minecraft:block_entity_type",
            "minecraft:item");
    private static NBTTagCompound cache = null;

    public static void sync(Player player){
        Packet<?> packet = getPacket();
        if(packet != null){
            ((EntityPlayer) Reflection.invoke(GET_HANDLE, player)).b.sendPacket(packet);
        }
    }

    public static Packet<?> getPacket(){
        NBTTagCompound tag = toTag();
        if (tag == null) {
            return null;
        }

        PacketDataSerializer buf = new PacketDataSerializer(Unpooled.buffer());
        buf.a(tag);

        return new PacketPlayOutCustomPayload(ID, buf);
    }

    @SuppressWarnings("unchecked")
    public static <T> NBTTagCompound toTag() {
        if(cache != null)
            return cache;
        NBTTagCompound mainTag = new NBTTagCompound();

        for (MinecraftKey registryId : IRegistry.f.keySet()) {
            IRegistry<T> registry = (IRegistry<T>) IRegistry.f.get(registryId);
            assert registry != null;

            if(!SYNC_TYPES.contains(registryId.toString())){
                continue;
            }

            NBTTagCompound registryTag = new NBTTagCompound();

            for (T o : registry) {
                MinecraftKey id = registry.getKey(o);
                if (id == null)
                    continue;
                int rawId = registry.getId(o);

                registryTag.setInt(id.toString(), rawId);
            }

            mainTag.set(registryId.toString(), registryTag);
        }

        if (mainTag.getKeys().isEmpty()) {
            return null;
        }

        NBTTagCompound tag = new NBTTagCompound();
        tag.setInt("version", 1);
        tag.set("registries", mainTag);
        cache = tag;
        return tag;
    }
}
