package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItemGroup;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.Item;

public class ItemSettings implements XItemSettings {
    private final Item.Properties info;

    public ItemSettings(Item.Properties info) {
        this.info = info;
    }

    @Override
    public Item.Properties asInfo() {
        return info;
    }

    @Override
    public XItemSettings maxCount(int count) {
        info.stacksTo(count);
        return this;
    }

    @Override
    public XItemSettings maxDamageIfAbsent(int maxDamage) {
        info.defaultDurability(maxDamage);
        return this;
    }

    @Override
    public XItemSettings maxDamage(int maxDamage) {
        info.durability(maxDamage);
        return this;
    }

    @Override
    public ItemSettings group(XItemGroup group) {
        info.tab(((ItemGroup) group).getTab());
        return this;
    }

    public static ItemSettings of(){
        return new ItemSettings(new Item.Properties());
    }
}
