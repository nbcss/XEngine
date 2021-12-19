package io.github.nbcss.xengine.api.block;

import net.minecraft.world.level.block.entity.TileEntity;

public interface XBlockEntity<T extends TileEntity> {
    T asTileEntity();
}
