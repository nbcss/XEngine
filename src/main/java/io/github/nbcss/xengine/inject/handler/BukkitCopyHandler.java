package io.github.nbcss.xengine.inject.handler;

import io.github.nbcss.xengine.core.item.ItemContainer;
import io.github.nbcss.xengine.core.item.ItemStackContainer;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;
import net.minecraft.world.item.ItemStack;

public class BukkitCopyHandler implements XMessageProcessor {
    @Override
    public String getChannel() {
        return "asBukkitCopy";
    }

    @Override
    public void handle(XMessage message) {
        ItemStack original = (ItemStack) message.getValue(0);
        if(ItemContainer.get(original.getItem()) != null){
            message.setValue(1, new ItemStackContainer(original));
        }
    }
}
