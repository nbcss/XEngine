package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.BlockEntityTypeBuilder;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntityTypes;
import net.minecraft.world.level.block.state.IBlockData;

public interface XBlockEntityType<T extends TileEntity, U extends XBlockEntity<T>> {
    TileEntityTypes<T> asTileEntityType();

    interface Builder<T extends TileEntity, U extends XBlockEntity<T>> {
        Builder<T, U> factory(Factory<T, U> factory);
        Builder<T, U> blocks(XBlock... blocks);
        //Builder<T> type(Material material);
        XBlockEntityType<T, U> register();
    }

    static <T extends TileEntity, U extends XBlockEntity<T>> Builder<T, U> of(String namespace, String id){
        return BlockEntityTypeBuilder.of(namespace, id);
    }

    static <T extends TileEntity & XBlockEntity<T>> Builder<T, T> of_(String namespace, String id){
        return BlockEntityTypeBuilder.of(namespace, id);
    }

    @FunctionalInterface
    interface Factory<T extends TileEntity, U extends XBlockEntity<T>> {
        U create(BlockPosition pos, IBlockData blockState);
    }
}
