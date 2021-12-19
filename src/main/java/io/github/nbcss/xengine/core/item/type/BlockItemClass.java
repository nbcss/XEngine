package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.core.block.BlockContainer;
import io.github.nbcss.xengine.core.item.ItemSettings;
import net.minecraft.core.IRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemBlock;
import net.minecraft.world.item.ItemStack;

public class BlockItemClass extends ItemClass {
    private final XBlock block;
    private BlockItemClass(XBlock block) {
        this.block = block;
    }

    @Override
    public Item create(ItemSettings settings) {
        return new ItemBlock(((BlockContainer) block).getBlock(), settings.getInfo());
    }

    public static BlockItemClass of(XBlock block){
        return new BlockItemClass(block);
    }
}
