package io.github.nbcss.xengine.core.item;

import com.google.common.collect.Maps;
import io.github.nbcss.xengine.api.item.XItem;
import io.github.nbcss.xengine.api.item.XItemMaterial;
import net.minecraft.world.item.Item;

import java.util.Map;

public class ItemContainer implements XItem {
    private static final Map<Item, ItemContainer> ITEM_MAP = Maps.newHashMap();
    private static final Map<XItemMaterial, ItemContainer> MATERIAL_MAP = Maps.newHashMap();
    private final Item item;
    private final XItemMaterial type;

    private ItemContainer(Item item, XItemMaterial type) {
        this.item = item;
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public XItemMaterial getType() {
        return type;
    }

    public static ItemContainer get(Item item){
        return ITEM_MAP.get(item);
    }

    public static ItemContainer get(XItemMaterial type){
        return MATERIAL_MAP.get(type);
    }

    public static ItemContainer of(Item item, XItemMaterial type){
        ItemContainer container = new ItemContainer(item, type);
        ITEM_MAP.put(item, container);
        MATERIAL_MAP.put(type, container);
        return container;
    }
}
