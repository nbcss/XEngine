package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.core.item.ItemSettings;
import net.minecraft.world.item.Item;

public abstract class ItemClass implements XItemClass {
    public abstract Item create(ItemSettings settings);
}
