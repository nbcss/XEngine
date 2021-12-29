package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.api.block.XBlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;

public abstract class BlockEntityContainer<T extends BlockEntity> implements XBlockEntity<T> {
    protected T handle;
    public BlockEntityContainer(XBlockEntityType<T, ?> type, Location loc, BlockData state) {
        this.handle = createHandle(type, loc, state);
    }

    protected abstract T createHandle(XBlockEntityType<T, ?> type, Location loc, BlockData state);

    @Override
    public T asTileEntity() {
        return handle;
    }
}
