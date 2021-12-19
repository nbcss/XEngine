package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.IRegistry;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;

import java.lang.reflect.Method;

public class BlockContainer implements XBlock {
    private static final Method SET_BLOCK = Reflection.bukkitMethod("block", "CraftBlock",
            "setTypeAndData", IBlockData.class, boolean.class);
    private final Block block;
    private final MinecraftKey key;
    public BlockContainer(Block block){
        this.block = block;
        this.key = IRegistry.W.getKey(block);
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public boolean isInstance(org.bukkit.block.Block block) {
        return false;
    }

    @Override
    public void replace(org.bukkit.block.Block at, boolean applyPhysics) {
        IBlockData data = block.getBlockData();
        Reflection.invoke(SET_BLOCK, at, data, applyPhysics);
    }

    @Override
    public String getNamespace() {
        return key.getNamespace();
    }

    @Override
    public String getId() {
        return key.getKey();
    }
}
