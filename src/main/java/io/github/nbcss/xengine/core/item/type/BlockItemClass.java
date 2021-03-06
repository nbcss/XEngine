package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class BlockItemClass implements XItemClass {
    private final XBlock block;
    private BlockItemClass(XBlock block) {
        this.block = block;
    }

    @Override
    public Item create(XItemSettings settings) {
        return new BlockItem(block.asBlock(), settings.asInfo());
    }

    public static BlockItemClass of(XBlock block){
        return new BlockItemClass(block);
    }
}
