package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockMaterial;
import net.minecraft.world.level.material.Material;

public class BlockMaterial implements XBlockMaterial {
    private final Material material;
    public BlockMaterial(Material material){
        this.material = material;
    }

    public Material asMaterial(){
        return material;
    }
}
