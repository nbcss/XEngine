package io.github.nbcss.xengine.core.block.type;

import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.core.block.BlockSettings;
import net.minecraft.world.level.block.Block;

public class BaseBlockClass extends BlockClass {
    public static final XBlockClass INSTANCE = new BaseBlockClass();
    private BaseBlockClass(){}

    @Override
    public Block create(BlockSettings settings){
        return new Block(settings.getInfo());
    }
}
