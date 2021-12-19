package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.agent.Agent;
import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.TransformByCraft;
import me.yamakaja.runtimetransformer.comm.Message;
import net.minecraft.world.item.Item;
import org.bukkit.inventory.ItemStack;

@TransformByCraft("inventory.CraftItemStack")
public class CraftItemTransformer {

    @Inject(InjectionType.INSERT)
    public static net.minecraft.world.item.ItemStack asNMSCopy(ItemStack original) {
        Message message = new Message("asNMSCopy", original, null);
        Agent.getInstance().getHandler().handle(message);
        Object result = message.getValue(1);
        if(result instanceof net.minecraft.world.item.ItemStack) {
            return (net.minecraft.world.item.ItemStack) result;
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public static ItemStack asBukkitCopy(net.minecraft.world.item.ItemStack original) {
        if (!original.isEmpty()) {
            Message message = new Message("asBukkitCopy", original, null);
            Agent.getInstance().getHandler().handle(message);
            Object result = message.getValue(1);
            if(result instanceof ItemStack) {
                return (ItemStack) result;
            }
        }
        throw null;
    }

    @Inject(InjectionType.OVERRIDE)
    public static Object asNewCraftStack(Item item, int amount) {
        Message message = new Message("asNewCraftStack", item, amount, null);
        Agent.getInstance().getHandler().handle(message);
        return message.getValue(2);
    }
}
