package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockState;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

import java.lang.reflect.Method;

public class BlockStateContainer implements XBlockState {
    private static final Method GET_STATE = Reflection.bukkitMethod("block",
            "CraftBlockStates", "getBlockState", BlockState.class, CompoundTag.class);
    private final BlockState handle;
    public BlockStateContainer(BlockState state){
        this.handle = state;
    }

    @Override
    public org.bukkit.block.BlockState asBlockState() {
        return (org.bukkit.block.BlockState) Reflection.invoke(GET_STATE, null, handle, null);
    }
}
