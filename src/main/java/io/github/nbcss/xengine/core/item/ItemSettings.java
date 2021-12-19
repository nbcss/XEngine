package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItemGroup;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.Item;

public class ItemSettings implements XItemSettings {
    private final Item.Info info;

    public ItemSettings(Item.Info info) {
        this.info = info;
    }

    public Item.Info getInfo() {
        return info;
    }

    @Override
    public ItemSettings group(XItemGroup group) {
        info.a(((ItemGroup) group).getTab());
        return this;
    }

    public static ItemSettings of(){
        return new ItemSettings(new Item.Info());
    }
}
