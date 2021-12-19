package io.github.nbcss.xengine.core.block.type;

import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.core.block.BlockSettings;
import net.minecraft.world.level.block.Block;

public abstract class BlockClass implements XBlockClass {
    public abstract Block create(BlockSettings settings);
}
