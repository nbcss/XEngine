package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class AliasBlockItemClass implements XItemClass {
    private final XBlock block;
    private AliasBlockItemClass(XBlock block) {
        this.block = block;
    }

    @Override
    public Item create(XItemSettings settings) {
        return new ItemNameBlockItem(block.asBlock(), settings.asInfo());
    }

    public static AliasBlockItemClass of(XBlock block){
        return new AliasBlockItemClass(block);
    }
}
