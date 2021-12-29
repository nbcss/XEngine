package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.core.block.BlockSettings;
import io.github.nbcss.xengine.core.block.type.BaseBlockClass;
import io.github.nbcss.xengine.core.block.type.CustomBlockClass;
import io.github.nbcss.xengine.utils.TriggerHandler;
import net.minecraft.world.level.block.Block;

public interface XBlockClass {
    Block create(BlockSettings settings);

    static XBlockClass base(){
        return BaseBlockClass.INSTANCE;
    }
    static XBlockClass custom(TriggerHandler handler){
        return CustomBlockClass.of(handler);
    }
}