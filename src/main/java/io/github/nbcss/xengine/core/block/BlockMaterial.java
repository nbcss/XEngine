package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlockMaterial;
import net.minecraft.world.level.material.Material;

public record BlockMaterial(Material material) implements XBlockMaterial {

    public Material asMaterial() {
        return material;
    }
}
