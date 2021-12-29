package io.github.nbcss.xengine.core.block;

import com.google.common.collect.Maps;
import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.api.block.XBlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;

public class BlockEntityTypeContainer<T extends BlockEntity, U extends XBlockEntity<T>>
        implements XBlockEntityType<T, U> {
    private static final Map<BlockEntityType<?>, BlockEntityTypeContainer<?, ?>> TYPE_MAP = Maps.newHashMap();
    private final BlockEntityType<T> handle;
    private BlockEntityTypeContainer(BlockEntityType<T> handle){
        this.handle = handle;
    }

    @Override
    public BlockEntityType<T> asTileEntityType() {
        return handle;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BlockEntity, U extends XBlockEntity<T>> BlockEntityTypeContainer<T, U>
    get(BlockEntityType<T> type){
        return (BlockEntityTypeContainer<T, U>) TYPE_MAP.get(type);
    }

    public static <T extends BlockEntity, U extends XBlockEntity<T>> BlockEntityTypeContainer<T, U>
    of(BlockEntityType<T> type){
        BlockEntityTypeContainer<T, U> container = new BlockEntityTypeContainer<>(type);
        TYPE_MAP.put(type, container);
        return container;
    }
}
