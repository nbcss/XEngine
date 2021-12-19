package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.api.block.XBlockMaterial;
import io.github.nbcss.xengine.api.block.XBlockSettings;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventory;

public class ExampleBlocks {
    public static final XBlock GEM_ORE_BLOCK;
    static {
        GEM_ORE_BLOCK = XBlock.of("example", "gem_ore")
                .type(Material.STONE)
                .handler(XBlockClass.base())
                .info(XBlockSettings.of(XBlockMaterial.STONE).strength(1.0F, 6.0F))
                .register();
    }
}
