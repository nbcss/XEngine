package io.github.nbcss.xengine.inject.handler;

import io.github.nbcss.xengine.utils.Reflection;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;
import net.minecraft.world.item.Item;

import java.lang.reflect.Method;

public class NewCraftStackHandler implements XMessageProcessor {
    private static final Method AS_CRAFT_MIRROR = Reflection.bukkitMethod("inventory",
            "CraftItemStack",
            "asCraftMirror",
            net.minecraft.world.item.ItemStack.class);

    @Override
    public String getChannel() {
        return "asNewCraftStack";
    }

    @Override
    public void handle(XMessage message) {
        Item item = (Item) message.getValue(0);
        int amount = (int) message.getValue(1);
        net.minecraft.world.item.ItemStack handle = new net.minecraft.world.item.ItemStack(item, amount);
        message.setValue(2, Reflection.invoke(AS_CRAFT_MIRROR, null, handle));
    }
}
