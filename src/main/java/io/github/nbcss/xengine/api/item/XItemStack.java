package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.core.item.ItemContainer;
import io.github.nbcss.xengine.core.item.ItemStackContainer;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;

import java.lang.reflect.Field;

@DelegateDeserialization(org.bukkit.inventory.ItemStack.class)
public abstract class XItemStack extends org.bukkit.inventory.ItemStack {
    private static final Class<?> CRAFT_ITEM_CLASS = Reflection.bukkitClass(
            "inventory", "CraftItemStack");
    private static final Field CRAFT_HANDLE_FIELD = Reflection.field(CRAFT_ITEM_CLASS, "handle");
    protected ItemStack handle;
    protected ItemContainer container;

    protected XItemStack(ItemContainer container, int count){
        this.handle = new ItemStack(container.getItem(), count);
        this.container = container;
    }

    protected XItemStack(ItemStack item) {
        ItemContainer container = ItemContainer.get(item.getItem());
        if(container == null)
            throw new RuntimeException("Not a XItem instance");
        this.handle = item;
        this.container = container;
    }

    @Override
    public void setType(Material type) {
        //no effect for setType()
    }

    public XMaterial getMaterial(){
        return container.getType();
    }

    public static XItemStack as(org.bukkit.inventory.ItemStack item){
        if(item instanceof XItemStack) {
            return (XItemStack) item;
        } else if(CRAFT_ITEM_CLASS.isInstance(item)){
            try {
                ItemStack src = (ItemStack) Reflection.get(CRAFT_HANDLE_FIELD, item);
                return new ItemStackContainer(src);
            } catch (Exception ignore) {}
        }
        return null;
    }

    public static XItemStack of(XMaterial material){
        return of(material, 1);
    }

    public static XItemStack of(XMaterial material, int count){
        ItemContainer container = ItemContainer.get(material);
        return container == null ? null : new ItemStackContainer(container, count);
    }
}
