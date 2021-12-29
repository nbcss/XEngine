package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.core.item.ItemGroup;
import net.minecraft.world.item.CreativeModeTab;

public interface XItemGroup {
    XItemGroup BUILDING_BLOCKS = new ItemGroup(CreativeModeTab.TAB_BUILDING_BLOCKS);
    XItemGroup DECORATIONS = new ItemGroup(CreativeModeTab.TAB_DECORATIONS);
    XItemGroup REDSTONE = new ItemGroup(CreativeModeTab.TAB_REDSTONE);
    XItemGroup TRANSPORTATION = new ItemGroup(CreativeModeTab.TAB_TRANSPORTATION);
    XItemGroup MISC = new ItemGroup(CreativeModeTab.TAB_MISC);
    XItemGroup SEARCH = new ItemGroup(CreativeModeTab.TAB_SEARCH);
    XItemGroup FOOD = new ItemGroup(CreativeModeTab.TAB_FOOD);
    XItemGroup TOOLS = new ItemGroup(CreativeModeTab.TAB_TOOLS);
    XItemGroup COMBAT = new ItemGroup(CreativeModeTab.TAB_COMBAT);
    XItemGroup BREWING = new ItemGroup(CreativeModeTab.TAB_BREWING);
    XItemGroup MATERIALS = new ItemGroup(CreativeModeTab.TAB_MATERIALS);
    XItemGroup HOTBAR = new ItemGroup(CreativeModeTab.TAB_HOTBAR);
    XItemGroup INVENTORY = new ItemGroup(CreativeModeTab.TAB_INVENTORY);
}
