package io.github.nbcss.xengine.core.block;

import com.google.common.collect.Maps;
import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.api.block.XBlockEntityType;
import io.github.nbcss.xengine.core.item.ItemContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.TileEntity;
import net.minecraft.world.level.block.entity.TileEntityTypes;

import java.util.Map;

public class BlockEntityTypeContainer<T extends TileEntity, U extends XBlockEntity<T>>
        implements XBlockEntityType<T, U> {
    private static final Map<TileEntityTypes<?>, BlockEntityTypeContainer<?, ?>> TYPE_MAP = Maps.newHashMap();
    private final TileEntityTypes<T> handle;
    private BlockEntityTypeContainer(TileEntityTypes<T> handle){
        this.handle = handle;
    }

    @Override
    public TileEntityTypes<T> asTileEntityType() {
        return handle;
    }

    @SuppressWarnings("unchecked")
    public static <T extends TileEntity, U extends XBlockEntity<T>> BlockEntityTypeContainer<T, U>
    get(TileEntityTypes<T> type){
        return (BlockEntityTypeContainer<T, U>) TYPE_MAP.get(type);
    }

    public static <T extends TileEntity, U extends XBlockEntity<T>> BlockEntityTypeContainer<T, U>
    of(TileEntityTypes<T> type){
        BlockEntityTypeContainer<T, U> container = new BlockEntityTypeContainer<>(type);
        TYPE_MAP.put(type, container);
        return container;
    }
}
