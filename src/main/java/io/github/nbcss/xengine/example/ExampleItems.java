package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemGroup;
import io.github.nbcss.xengine.api.item.XItem;
import io.github.nbcss.xengine.api.item.XItemSettings;

public class ExampleItems {
    public static final XItem GEM_ORE_ITEM;
    //public static final XItem GEM;
    static {
        GEM_ORE_ITEM = XItem.of(ExampleBlocks.GEM_ORE_BLOCK)
                .info(XItemSettings.of().group(XItemGroup.BUILDING_BLOCKS))
                .register();
        /*GEM = XItem.of("example", "gem")
                .handler(XItemClass.base())
                .type(ExampleTypes.GEM_ORE)
                .info(XItemSettings.of().group(XItemGroup.MISC))
                .register();*/
    }
}
