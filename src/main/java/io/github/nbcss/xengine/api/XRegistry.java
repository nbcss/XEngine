package io.github.nbcss.xengine.api;

import io.github.nbcss.xengine.core.XRegistryContainer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface XRegistry<T> {
    XRegistry<Block> BLOCK = new XRegistryContainer<>(Registry.BLOCK);
    XRegistry<Item> ITEM = new XRegistryContainer<>(Registry.ITEM);
    XRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPE = new XRegistryContainer<>(Registry.BLOCK_ENTITY_TYPE);

    T get(ResourceLocation key);
    T register(ResourceLocation key, T entry);
}
