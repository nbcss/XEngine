package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;
import net.minecraft.world.item.Item;

public class BaseItemClass implements XItemClass {
    public static final XItemClass INSTANCE = new BaseItemClass();

    @Override
    public Item create(XItemSettings settings){
        return new Item(settings.asInfo());
    }
}
