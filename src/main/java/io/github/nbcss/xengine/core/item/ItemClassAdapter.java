package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.Item;

public abstract class ItemClassAdapter implements XItemClass {
    @Override
    public Item create(XItemSettings settings) {
        return accept(settings.asInfo());
    }

    protected abstract Item accept(Object property);
}
