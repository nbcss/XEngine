package io.github.nbcss.xengine.core.item.type;

import io.github.nbcss.xengine.core.item.ItemSettings;
import net.minecraft.core.IRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;

public class BaseItemClass extends ItemClass {
    public static final ItemClass INSTANCE = new BaseItemClass();

    @Override
    public Item create(ItemSettings settings){
        return new Item(settings.getInfo());
    }
}
