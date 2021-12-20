package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockState;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlockState;

public class BlockStateContainer implements XBlockState {
    protected final CraftBlockState handle;
    public BlockStateContainer(CraftBlockState handle){
        this.handle = handle;
    }

    public BlockStateContainer(IBlockData handle){
        //this.handle = handle;
        this.handle = null;
        //fixme
        //CraftBlockStates

    }

    @Override
    public BlockState asBlockState() {
        return handle;
    }

    public IBlockData getState() {
        return handle.getHandle();
    }

    public static BlockStateContainer fromCraft(Object craftBlockState){
        return null;
    }
}
