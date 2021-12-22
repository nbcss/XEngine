package io.github.nbcss.xengine.api.item;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.core.item.ItemContainer;
import io.github.nbcss.xengine.core.item.ItemStackContainer;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@DelegateDeserialization(org.bukkit.inventory.ItemStack.class)
public abstract class XItemStack extends org.bukkit.inventory.ItemStack {
    private static final Class<?> CRAFT_ITEM_CLASS = Reflection.bukkitClass(
            "inventory", "CraftItemStack");
    private static final Class<?> CRAFT_META_CLASS = Reflection.bukkitClass(
            "inventory", "CraftMetaItem");
    private static final Constructor<?> CREATE_META = Reflection.constructor(CRAFT_META_CLASS, CRAFT_META_CLASS);
    private static final Constructor<?> READ_META = Reflection.constructor(CRAFT_META_CLASS, NBTTagCompound.class);
    private static final Method APPLY_TAG = Reflection.method(CRAFT_META_CLASS,
            "applyToItem", NBTTagCompound.class);
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
    public Material getType() {
        return container.getType().asBukkitMaterial();
    }

    @Override
    public void setType(Material type) {
        //no effect for setType()
    }

    @Override
    public int getAmount() {
        return handle.getCount();
    }

    @Override
    public void setAmount(int amount) {
        handle.setCount(amount);
    }

    @Override
    public int getMaxStackSize() {
        return handle.getItem().getMaxStackSize();
    }

    @Override
    public ItemMeta getItemMeta() {
        if(hasItemMeta(handle)){
            return (ItemMeta) Reflection.newInstance(READ_META, handle.getTag());
        }else{
            return (ItemMeta) Reflection.newInstance(CREATE_META, (Object) null);
        }
    }

    @Override
    public boolean setItemMeta(ItemMeta itemMeta) {
        if (itemMeta == null) {
            handle.setTag(null);
        }else{
            NBTTagCompound tag = new NBTTagCompound();
            handle.setTag(tag);
            Reflection.invoke(APPLY_TAG, itemMeta, tag);
            if (handle.getItem().usesDurability()) {
                handle.setDamage(handle.getDamage());
            }
        }
        return true;
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

    private static boolean hasItemMeta(net.minecraft.world.item.ItemStack item) {
        return item != null && item.getTag() != null && !item.getTag().isEmpty();
    }
}
