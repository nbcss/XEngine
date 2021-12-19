package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XMapColor;
import net.minecraft.world.level.material.MaterialMapColor;

public class MapColor implements XMapColor {
    private final MaterialMapColor handle;

    public MapColor(MaterialMapColor handle) {
        this.handle = handle;
    }

    public MaterialMapColor getColor() {
        return handle;
    }
}
