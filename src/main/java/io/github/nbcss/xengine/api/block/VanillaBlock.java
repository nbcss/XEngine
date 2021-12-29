package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.BlockWrapper;
import net.minecraft.world.level.block.Blocks;

public interface VanillaBlock extends XBlock {
    VanillaBlock AIR = new BlockWrapper(Blocks.AIR);
    VanillaBlock STONE = new BlockWrapper(Blocks.STONE);
    VanillaBlock GRANITE = new BlockWrapper(Blocks.GRANITE);
    VanillaBlock POLISHED_GRANITE = new BlockWrapper(Blocks.POLISHED_GRANITE);
    VanillaBlock DIORITE = new BlockWrapper(Blocks.DIORITE);
    VanillaBlock POLISHED_DIORITE = new BlockWrapper(Blocks.POLISHED_DIORITE);
    VanillaBlock ANDESITE = new BlockWrapper(Blocks.ANDESITE);
    VanillaBlock POLISHED_ANDESITE = new BlockWrapper(Blocks.POLISHED_ANDESITE);
    VanillaBlock GRASS_BLOCK = new BlockWrapper(Blocks.GRASS_BLOCK);
    VanillaBlock DIRT = new BlockWrapper(Blocks.DIRT);
}
