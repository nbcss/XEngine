package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XMapColor;
import net.minecraft.world.level.material.MaterialColor;

public class MapColor implements XMapColor {
    private final MaterialColor handle;

    public MapColor(MaterialColor handle) {
        this.handle = handle;
    }

    public MaterialColor getColor() {
        return handle;
    }
}
