package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.core.item.type.AliasBlockItemClass;
import io.github.nbcss.xengine.core.item.type.BaseItemClass;
import io.github.nbcss.xengine.core.item.type.BlockItemClass;
import net.minecraft.world.item.Item;

public interface XItemClass {
    Item create(XItemSettings settings);

    static XItemClass base(){
        return BaseItemClass.INSTANCE;
    }
    static XItemClass block(XBlock block){
        return BlockItemClass.of(block);
    }
    static XItemClass aliasBlock(XBlock block){
        return AliasBlockItemClass.of(block);
    }
}
