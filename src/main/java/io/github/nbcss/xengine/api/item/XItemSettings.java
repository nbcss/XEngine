package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.core.item.ItemSettings;
import net.minecraft.world.item.Item;

public interface XItemSettings {
    XItemSettings maxCount(int count);
    XItemSettings maxDamageIfAbsent(int maxDamage);
    XItemSettings maxDamage(int maxDamage);
    XItemSettings group(XItemGroup group);
    Item.Properties asInfo();

    static XItemSettings of(){
        return ItemSettings.of();
    }
}
