package io.github.nbcss.xengine.core;

import com.google.common.collect.Maps;
import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.utils.Reflection;
import org.bukkit.Material;

import java.lang.reflect.Field;
import java.util.Map;

public class MaterialContainer implements XMaterial {
    private static final Map<Material, XMaterial> MATERIAL_MAP = Maps.newHashMap();
    private static final Field ID = Reflection.field(Material.class, "id");
    private final Material material;
    private final Data data;
    private MaterialContainer(Material material, Data data){
        this.material = material;
        this.data = data;
    }

    @Override
    public String getName() {
        return material.name();
    }

    @Override
    public Material asBukkitMaterial() {
        return material;
    }

    @Override
    public boolean isEquals(Material material) {
        return this.material == material;
    }

    @Override
    public boolean isVanilla() {
        return (int) Reflection.get(ID, material) >= 0;
    }

    @Override
    public Data getData() {
        return data;
    }

    public static XMaterial get(Material material){
        return MATERIAL_MAP.get(material);
    }

    public static XMaterial of(Material material, Data data){
        MaterialContainer container = new MaterialContainer(material, data);
        MATERIAL_MAP.put(material, container);
        return container;
    }
}
