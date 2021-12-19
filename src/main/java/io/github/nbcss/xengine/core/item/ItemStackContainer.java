package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItemStack;
import net.minecraft.world.item.ItemStack;

public class ItemStackContainer extends XItemStack {

    public ItemStackContainer(ItemStack item) {
        super(item);
    }

    public ItemStackContainer(ItemContainer container, int count) {
        super(container, count);
    }

    public net.minecraft.world.item.ItemStack getHandle(){
        return handle;
    }
}
