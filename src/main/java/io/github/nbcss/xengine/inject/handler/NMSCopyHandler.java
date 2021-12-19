package io.github.nbcss.xengine.inject.handler;

import io.github.nbcss.xengine.core.item.ItemStackContainer;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;
import org.bukkit.inventory.ItemStack;

public class NMSCopyHandler implements XMessageProcessor {
    @Override
    public String getChannel() {
        return "asNMSCopy";
    }

    @Override
    public void handle(XMessage message) {
        ItemStack original = (ItemStack) message.getValue(0);
        if(original instanceof ItemStackContainer){
            message.setValue(1, ((ItemStackContainer) original).getHandle());
        }
    }
}
