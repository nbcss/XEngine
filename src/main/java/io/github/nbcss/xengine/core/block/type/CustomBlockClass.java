package io.github.nbcss.xengine.core.block.type;

import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.core.block.BlockSettings;
import io.github.nbcss.xengine.utils.TriggerHandler;
import net.minecraft.world.level.block.Block;

public class CustomBlockClass implements XBlockClass {
    private final TriggerHandler handler;
    private CustomBlockClass(TriggerHandler handler){
        this.handler = handler;
    }

    @Override
    public Block create(BlockSettings settings) {
        return new CustomBlock(settings.asInfo(), handler);
    }

    public static CustomBlockClass of(TriggerHandler handler){
        return new CustomBlockClass(handler);
    }

    public static class CustomBlock extends Block {
        private final TriggerHandler handler;
        public CustomBlock(Properties info, TriggerHandler handler) {
            super(info);
            this.handler = handler;
        }
    }
}
