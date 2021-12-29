package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.BlockEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public interface XBlockEntityType<T extends BlockEntity, U extends XBlockEntity<T>> {
    BlockEntityType<T> asTileEntityType();

    interface Builder<T extends BlockEntity, U extends XBlockEntity<T>> {
        Builder<T, U> factory(Factory<T, U> factory);
        Builder<T, U> blocks(XBlock... blocks);
        //Builder<T> type(Material material);
        XBlockEntityType<T, U> register();
    }

    static <T extends BlockEntity, U extends XBlockEntity<T>> Builder<T, U> of(String namespace, String id){
        return BlockEntityTypeBuilder.of(namespace, id);
    }

    static <T extends BlockEntity & XBlockEntity<T>> Builder<T, T> of_(String namespace, String id){
        return BlockEntityTypeBuilder.of(namespace, id);
    }

    @FunctionalInterface
    interface Factory<T extends BlockEntity, U extends XBlockEntity<T>> {
        U create(BlockPos pos, BlockState blockState);
    }
}
