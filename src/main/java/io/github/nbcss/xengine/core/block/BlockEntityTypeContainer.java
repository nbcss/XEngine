package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.api.block.XBlockEntityType;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntityTypes;

public class BlockEntityTypeContainer<T extends TileEntity, U extends XBlockEntity<T>>
        implements XBlockEntityType<T, U> {
    private final TileEntityTypes<T> handle;
    public BlockEntityTypeContainer(TileEntityTypes<T> handle){
        this.handle = handle;
    }

    @Override
    public TileEntityTypes<T> asTileEntityType() {
        return handle;
    }
}
