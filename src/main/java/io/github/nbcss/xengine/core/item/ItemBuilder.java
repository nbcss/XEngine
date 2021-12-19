package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.item.XItem;
import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.item.XItemMaterial;
import io.github.nbcss.xengine.core.item.type.ItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;

import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.IRegistry;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ItemBuilder implements XItem.Builder, XItem.BlockItemBuilder {
    private static final Map<Item, Material> MATERIAL_MAP = (Map<Item, Material>)
            Reflection.get(Reflection.bukkitField(
            "util",
            "CraftMagicNumbers",
            "ITEM_MATERIAL"), null);
    private final MinecraftKey key;
    private XItemSettings settings;
    private XItemMaterial material;
    private XItemClass handler = XItemClass.base();
    public ItemBuilder(String namespace, String id){
        this.key = new MinecraftKey(namespace, id);
    }

    @Override
    public ItemBuilder handler(XItemClass type){
        this.handler = type;
        return this;
    }

    @Override
    public ItemBuilder info(XItemSettings settings){
        this.settings = settings;
        return this;
    }

    @Override
    public XItem.Builder type(XItemMaterial type) {
        this.material = type;
        return this;
    }

    @Override
    public XItem register(){
        assert settings != null && handler != null && material != null;
        ResourceKey<Item> resourceKey = ResourceKey.a(IRegistry.Z.f(), key);
        Item old = IRegistry.Z.a(resourceKey);
        if(old != null){
            return ItemContainer.of(old, material);
        }
        Item item = ((ItemClass) handler).create((ItemSettings) settings);
        MATERIAL_MAP.put(item, material.asBukkitMaterial());
        Bukkit.getLogger().info("Added Item [" + key + "]");
        return ItemContainer.of(IRegistry.a(IRegistry.Z, key, item), material);
    }
}
