package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public record XRegistryContainer<T>(Registry<T> registry) implements XRegistry<T> {
    @Override
    public T get(ResourceLocation key) {
        return registry.get(ResourceKey.create(registry.key(), key));
    }

    @Override
    public T register(ResourceLocation key, T entry) {
        return Registry.register(registry, key, entry);
    }
}
