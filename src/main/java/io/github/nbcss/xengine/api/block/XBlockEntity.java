package io.github.nbcss.xengine.api.block;

import net.minecraft.world.level.block.entity.BlockEntity;

public interface XBlockEntity<T extends BlockEntity> {
    T asTileEntity();
}
