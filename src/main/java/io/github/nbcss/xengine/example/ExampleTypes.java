package io.github.nbcss.xengine.example;

import io.github.nbcss.xengine.api.XMaterial;

public interface ExampleTypes {
    XMaterial GEM_ORE = XMaterial.of("GEM_ORE")
            .mapping("example", "gem_ore")
            .block(true)
            .register();
}
