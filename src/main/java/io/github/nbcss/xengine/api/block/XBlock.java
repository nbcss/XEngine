package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.BlockBuilder;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public interface XBlock {
    boolean isInstance(Block block);
    void replace(Block at, boolean applyPhysics);
    String getNamespace();
    String getId();

    default void replace(Block at){
        replace(at, true);
    }

    default void replace(World world, Location loc, boolean applyPhysics){
        replace(world.getBlockAt(loc), applyPhysics);
    }

    default void replace(World world, Location loc){
        replace(world, loc, true);
    }

    interface Builder {
        Builder handler(XBlockClass type);
        Builder type(Material material);
        Builder info(XBlockSettings settings);
        XBlock register();
    }

    static Builder of(String namespace, String id){
        return new BlockBuilder(namespace, id);
    }

    interface StatePredicate {
        boolean test(IBlockData iBlockData, IBlockAccess iBlockAccess, BlockPosition blockPosition);
    }
}
