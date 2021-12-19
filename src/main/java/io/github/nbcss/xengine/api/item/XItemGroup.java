package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.core.item.ItemGroup;
import net.minecraft.world.item.CreativeModeTab;

public interface XItemGroup {
    XItemGroup BUILDING_BLOCKS = new ItemGroup(CreativeModeTab.b);
    XItemGroup DECORATIONS = new ItemGroup(CreativeModeTab.c);
    XItemGroup REDSTONE = new ItemGroup(CreativeModeTab.d);
    XItemGroup TRANSPORTATION = new ItemGroup(CreativeModeTab.e);
    XItemGroup MISC = new ItemGroup(CreativeModeTab.f);
    XItemGroup SEARCH = new ItemGroup(CreativeModeTab.g);
    XItemGroup FOOD = new ItemGroup(CreativeModeTab.h);
    XItemGroup TOOLS = new ItemGroup(CreativeModeTab.i);
    XItemGroup COMBAT = new ItemGroup(CreativeModeTab.j);
    XItemGroup BREWING = new ItemGroup(CreativeModeTab.k);
    XItemGroup MATERIALS = new ItemGroup(CreativeModeTab.l);
    XItemGroup HOTBAR = new ItemGroup(CreativeModeTab.m);
    XItemGroup INVENTORY = new ItemGroup(CreativeModeTab.n);
}
