package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.utils.Reflection;
import net.auoeke.reflect.EnumConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.EquipmentSlot;

import java.lang.reflect.Field;
import java.util.Map;

@SuppressWarnings("unchecked")
public class MaterialBuilder implements XMaterial.Builder {
    private static final Map<String, Material> BY_NAME = (Map<String, Material>)
            Reflection.get(Reflection.field(Material.class, "BY_NAME"), null);
    private static final Field KEY = Reflection.field(Material.class, "key");
    private static final String FORMAT = "[A-Z_][0-9A-Z_]*";
    private final String name;
    private final MaterialData data;
    private String namespace, id;
    private int stack, durability;
    private MaterialBuilder(String name){
        this.name = name;
        this.namespace = "minecraft";
        this.id = null;
        this.stack = 64;
        this.durability = 0;
        this.data = new MaterialData();
    }

    @Override
    public XMaterial.Builder mapping(String namespace, String id) {
        this.namespace = namespace;
        this.id = id;
        return this;
    }

    @Override
    public XMaterial.Builder maxCount(int count) {
        this.stack = Math.max(1, Math.min(64, count));
        if(this.stack > 1){
            this.durability = 0;
        }
        return this;
    }

    @Override
    public XMaterial.Builder maxDurability(short durability) {
        this.durability = Math.max(0, durability);
        if(this.durability > 0){
            this.stack = 1;
        }
        return this;
    }

    @Override
    public XMaterial.Builder block(boolean val) {
        data.setBlock(val);
        return this;
    }

    @Override
    public XMaterial.Builder edible(boolean val) {
        data.setEdible(val);
        return this;
    }

    @Override
    public XMaterial.Builder record(boolean val) {
        data.setRecord(val);
        return this;
    }

    @Override
    public XMaterial.Builder solid(boolean val) {
        data.setSolid(val);
        return this;
    }

    @Override
    public XMaterial.Builder air(boolean val) {
        data.setAir(val);
        return this;
    }

    @Override
    public XMaterial.Builder transparent(boolean val) {
        data.setTransparent(val);
        return this;
    }

    @Override
    public XMaterial.Builder flammable(boolean val) {
        data.setFlammable(val);
        return this;
    }

    @Override
    public XMaterial.Builder burnable(boolean val) {
        data.setBurnable(val);
        return this;
    }

    @Override
    public XMaterial.Builder fuel(boolean val) {
        data.setFuel(val);
        return this;
    }

    @Override
    public XMaterial.Builder occluding(boolean val) {
        data.setOccluding(val);
        return this;
    }

    @Override
    public XMaterial.Builder gravity(boolean val) {
        data.setGravity(val);
        return this;
    }

    @Override
    public XMaterial.Builder item(boolean val) {
        data.setItem(val);
        return this;
    }

    @Override
    public XMaterial.Builder interactable(boolean val) {
        data.setInteractable(val);
        return this;
    }

    @Override
    public XMaterial.Builder craftingRemainingItem(Material material) {
        data.setCraftingRemainingItem(material);
        return this;
    }

    @Override
    public XMaterial.Builder equipmentSlot(EquipmentSlot slot) {
        data.setEquipmentSlot(slot);
        return this;
    }

    @Override
    public XMaterial.Builder hardness(float hardness) {
        data.setHardness(hardness);
        return this;
    }

    @Override
    public XMaterial.Builder blastResistance(float resistance) {
        data.setResistance(resistance);
        return this;
    }

    @Override
    public XMaterial.Builder slipperiness(float slipperiness) {
        data.setSlipperiness(slipperiness);
        return this;
    }

    @Override
    public XMaterial register() {
        Material material = BY_NAME.get(name);
        if(material == null){
            material = EnumConstructor.construct(Material.class, name, -1, stack, durability);
            if(id != null){
                NamespacedKey key = new NamespacedKey(namespace, id);
                Reflection.set(KEY, material, key);
            }
            EnumConstructor.add(Material.class, material);
            BY_NAME.put(name, material);
            Bukkit.getLogger().info("[XEngine] +Material [" + name + "]");
        }
        return MaterialContainer.of(material, data);
    }

    public static MaterialBuilder of(String name){
        if(!name.matches(FORMAT))
            throw new RuntimeException("Incorrect material name format: " + name);
        return new MaterialBuilder(name);
    }
}
