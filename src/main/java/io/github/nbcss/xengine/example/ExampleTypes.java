package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.item.XItemMaterial;

public enum ExampleTypes implements XItemMaterial {
    GEM_ORE;

    @Override
    public String getName() {
        return name();
    }
}
