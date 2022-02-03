package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.api.block.XBlockMaterial;
import io.github.nbcss.xengine.api.block.XBlockSettings;

public class ExampleBlocks {
    public static final XBlock GEM_ORE_BLOCK;
    static {
        GEM_ORE_BLOCK = XBlock.of("example", "gem_ore")
                .type(ExampleTypes.GEM_ORE)
                .handler(XBlockClass.base())
                .info(XBlockSettings.of(XBlockMaterial.STONE).strength(1.0F, 6.0F))
                .register();
    }
}
