package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.core.item.ItemBuilder;

public interface XItem {

    XMaterial getType();
    XItemStack asStack(int count);
    default XItemStack asStack(){
        return asStack(1);
    }

    interface Builder {
        Builder handler(XItemClass type);
        Builder info(XItemSettings settings);
        Builder type(XMaterial type);
        XItem register();
    }

    interface BlockItemBuilder {
        BlockItemBuilder info(XItemSettings settings);
        XItem register();
    }

    static Builder of(String namespace, String id){
        return ItemBuilder.of(namespace, id);
    }

    static BlockItemBuilder of(XBlock block){
        return ItemBuilder.of(block);
    }
}
