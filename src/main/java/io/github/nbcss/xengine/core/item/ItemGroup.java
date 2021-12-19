package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItemGroup;
import net.minecraft.world.item.CreativeModeTab;

public class ItemGroup implements XItemGroup {
    private final CreativeModeTab tab;
    public ItemGroup(CreativeModeTab tab){
        this.tab = tab;
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
