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
    public XItemSettings maxCount(int count) {
        info.a(count);
        return this;
    }

    @Override
    public XItemSettings maxDamageIfAbsent(int maxDamage) {
        info.b(maxDamage);
        return this;
    }

    @Override
    public XItemSettings maxDamage(int maxDamage) {
        info.c(maxDamage);
        return this;
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
