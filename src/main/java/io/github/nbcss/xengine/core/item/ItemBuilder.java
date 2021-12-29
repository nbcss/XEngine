package io.github.nbcss.xengine.core.item;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.item.XItem;
import io.github.nbcss.xengine.api.item.XItemClass;
import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.core.item.type.BlockItemClass;
import io.github.nbcss.xengine.api.item.XItemSettings;

import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ItemBuilder implements XItem.Builder, XItem.BlockItemBuilder {
    private static final Map<Item, Material> ITEM_MATERIAL = (Map<Item, Material>) Reflection.get(
            Reflection.bukkitField("util","CraftMagicNumbers","ITEM_MATERIAL"),
            null);
    private static final Map<Material, Item> MATERIAL_ITEM = (Map<Material, Item>) Reflection.get(
            Reflection.bukkitField("util","CraftMagicNumbers","MATERIAL_ITEM"),
            null);
    private final ResourceLocation key;
    private XItemSettings settings;
    private XMaterial material;
    private XItemClass handler = XItemClass.base();
    private ItemBuilder(String namespace, String id){
        this.key = new ResourceLocation(namespace, id);
    }

    private ItemBuilder(XBlock block){
        this.key = new ResourceLocation(block.getNamespace(), block.getId());
        this.material = block.getType();
        this.handler = BlockItemClass.of(block);
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
    public XItem.Builder type(XMaterial type) {
        this.material = type;
        return this;
    }

    @Override
    public XItem register(){
        assert settings != null && handler != null && material != null;
        ResourceKey<Item> resourceKey = ResourceKey.create(Registry.ITEM.key(), key);
        Item old = Registry.ITEM.get(resourceKey);
        if(old != null){
            return ItemContainer.of(old, material);
        }
        Item item = handler.create(settings);
        ITEM_MATERIAL.put(item, material.asBukkitMaterial());
        if(!material.isVanilla()){
            MATERIAL_ITEM.put(material.asBukkitMaterial(), item);
        }
        Bukkit.getLogger().info("[XEngine] +Item [" + key + "]");
        return ItemContainer.of(Registry.register(Registry.ITEM, key, item), material);
    }

    public static ItemBuilder of(String namespace, String id){
        return new ItemBuilder(namespace, id);
    }

    public static ItemBuilder of(XBlock block){
        return new ItemBuilder(block);
    }
}
