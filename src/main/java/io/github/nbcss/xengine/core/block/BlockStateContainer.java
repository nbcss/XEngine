package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockState;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlockState;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlockStates;

public class BlockStateContainer implements XBlockState {
    private final CraftBlockState handle;
    public BlockStateContainer(CraftBlockState handle){
        this.handle = handle;
    }

    public BlockStateContainer(IBlockData handle){
        //this.handle = handle;
        this.handle = null;
        //fixme
        //CraftBlockStates
    }

    public CraftBlockState getHandle() {
        return handle;
    }

    public IBlockData getState() {
        return handle.getHandle();
    }

    public static BlockStateContainer fromCraft(Object craftBlockState){
        return null;
    }
}
