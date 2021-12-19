package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.core.item.type.BlockItemClass;
import io.github.nbcss.xengine.core.item.ItemBuilder;

public interface XItem {

    XItemMaterial getType();

    interface Builder {
        Builder handler(XItemClass type);
        Builder info(XItemSettings settings);
        Builder type(XItemMaterial type);
        XItem register();
    }

    interface BlockItemBuilder {
        BlockItemBuilder info(XItemSettings settings);
        Builder type(XItemMaterial type);
        XItem register();
    }

    static Builder of(String namespace, String id){
        return new ItemBuilder(namespace, id);
    }

    static BlockItemBuilder of(XBlock block){
        return new ItemBuilder(block.getNamespace(), block.getId())
                .handler(BlockItemClass.of(block));
    }
}
