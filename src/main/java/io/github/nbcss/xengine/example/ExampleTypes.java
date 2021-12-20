package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.XMaterial;
import org.bukkit.Material;

public enum ExampleTypes implements XMaterial {
    GEM_ORE{
        @Override
        public Material asBukkitMaterial() {
            return Material.STONE;
        }
    };

    @Override
    public String getName() {
        return name();
    }
}
