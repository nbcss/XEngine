package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.api.block.VanillaBlock;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.block.Block;

import java.lang.reflect.Method;

public class BlockWrapper implements VanillaBlock {
    private static final Method SET_BLOCK = Reflection.bukkitMethod("block", "CraftBlock",
            "setTypeAndData", BlockState.class, boolean.class);
    private final net.minecraft.world.level.block.Block block;
    public BlockWrapper(net.minecraft.world.level.block.Block block){
        this.block = block;

    }

    @Override
    public boolean isInstance(Block block) {
        return false;
    }

    @Override
    public void replace(Block at, boolean applyPhysics) {
        BlockState data = block.defaultBlockState();
        Reflection.invoke(SET_BLOCK, at, data, applyPhysics);
    }

    @Override
    public String getNamespace() {
        return Registry.BLOCK.getKey(block).getNamespace();
    }

    @Override
    public String getId() {
        return Registry.BLOCK.getKey(block).getPath();
    }

    @Override
    public XMaterial getType() {
        return null;
    }

    @Override
    public net.minecraft.world.level.block.Block asBlock() {
        return block;
    }
}
