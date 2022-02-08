package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.TransformByCraft;
import net.minecraft.world.item.Item;
import org.bukkit.inventory.ItemStack;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@TransformByCraft("inventory.CraftItemStack")
public class CraftItemTransformer {

    @Inject(InjectionType.INSERT)
    public static net.minecraft.world.item.ItemStack asNMSCopy(ItemStack original) {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
        String name = "Minecraft:XEngine=Transformer", channel = "asNMSCopy";
        Object[] values = {original, null};
        try{
            ObjectName objectName = new ObjectName(name);
            Object[] parameters = {channel, values};
            server.invoke(objectName, "dispatch", parameters, signature);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        Object result = values[1];
        if(result instanceof net.minecraft.world.item.ItemStack) {
            return (net.minecraft.world.item.ItemStack) result;
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public static ItemStack asBukkitCopy(net.minecraft.world.item.ItemStack original) {
        if (!original.isEmpty()) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "asBukkitCopy";
            Object[] values = {original, null};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            Object result = values[1];
            if(result instanceof ItemStack) {
                return (ItemStack) result;
            }
        }
        throw null;
    }

    @Inject(InjectionType.OVERRIDE)
    public static Object asNewCraftStack(Item item, int amount) {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
        String name = "Minecraft:XEngine=Transformer", channel = "asNewCraftStack";
        Object[] values = {item, amount, null};
        try{
            ObjectName objectName = new ObjectName(name);
            Object[] parameters = {channel, values};
            server.invoke(objectName, "dispatch", parameters, signature);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return values[2];
    }
}
