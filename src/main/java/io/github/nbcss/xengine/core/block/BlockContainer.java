package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.lang.reflect.Method;

public class BlockContainer implements XBlock {
    private static final Method SET_BLOCK = Reflection.bukkitMethod("block", "CraftBlock",
            "setTypeAndData", BlockState.class, boolean.class);
    private final XMaterial type;
    private final Block block;
    private final ResourceLocation key;
    private BlockContainer(Block block, XMaterial type){
        this.block = block;
        this.key = Registry.BLOCK.getKey(block);
        this.type = type;
    }

    @Override
    public Block asBlock() {
        return block;
    }

    @Override
    public boolean isInstance(org.bukkit.block.Block block) {
        return false;
    }

    @Override
    public void replace(org.bukkit.block.Block at, boolean applyPhysics) {
        BlockState data = block.defaultBlockState();
        Reflection.invoke(SET_BLOCK, at, data, applyPhysics);
    }

    @Override
    public String getNamespace() {
        return key.getNamespace();
    }

    @Override
    public String getId() {
        return key.getPath();
    }

    @Override
    public XMaterial getType() {
        return type;
    }

    public static BlockContainer of(Block block, XMaterial type){
        return new BlockContainer(block, type);
    }
}
