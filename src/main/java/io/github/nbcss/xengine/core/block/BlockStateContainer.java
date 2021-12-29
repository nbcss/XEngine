package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockState;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlockState;

public class BlockStateContainer implements XBlockState {
    protected final CraftBlockState handle;
    public BlockStateContainer(CraftBlockState handle){
        this.handle = handle;
    }

    public BlockStateContainer(BlockState handle){
        //this.handle = handle;
        this.handle = null;
        //fixme
        //CraftBlockStates

    }

    @Override
    public org.bukkit.block.BlockState asBlockState() {
        return handle;
    }

    public BlockState getState() {
        return handle.getHandle();
    }

    public static BlockStateContainer fromCraft(Object craftBlockState){
        return null;
    }
}
