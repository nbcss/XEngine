package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public class MaterialData implements XMaterial.Data {
    private boolean block = false;
    private boolean edible = false;
    private boolean record = false;
    private boolean solid = true;
    private boolean air = false;
    private boolean transparent = false;
    private boolean flammable = false;
    private boolean burnable = false;
    private boolean fuel = false;
    private boolean occluding = true;
    private boolean gravity = false;
    private boolean item = true;
    private boolean interactable = false;
    private float hardness = 1.0F;
    private float resistance = 1.0F;
    private float slipperiness = 0.6F;
    private Material remain = null;
    private EquipmentSlot slot = EquipmentSlot.HAND;

    @Override
    public boolean isBlock(){
        return block;
    }

    @Override
    public boolean isEdible(){
        return edible;
    }

    @Override
    public boolean isRecord(){
        return record;
    }

    @Override
    public boolean isSolid(){
        return isBlock() && solid;
    }

    @Override
    public boolean isAir(){
        return air;
    }

    @Override
    public boolean isTransparent() {
        return isBlock() && transparent;
    }

    @Override
    public boolean isFlammable() {
        return isBlock() && flammable;
    }

    @Override
    public boolean isBurnable() {
        return isBlock() && burnable;
    }

    @Override
    public boolean isFuel() {
        return fuel;
    }

    @Override
    public boolean isOccluding() {
        return isBlock() && occluding;
    }

    @Override
    public boolean hasGravity() {
        return isBlock() && gravity;
    }

    @Override
    public boolean isItem() {
        return item;
    }

    @Override
    public boolean isInteractable() {
        return interactable;
    }

    @Override
    public float getHardness() {
        return isBlock() ? hardness : 0.0f;
    }

    @Override
    public float getBlastResistance() {
        return isBlock() ? resistance : 0.0f;
    }

    @Override
    public float getSlipperiness() {
        return isBlock() ? slipperiness : 0.0f;
    }

    @Override
    public Material getCraftingRemainingItem() {
        return isItem() ? remain : null;
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return isItem() ? slot : null;
    }

    public void setBlock(boolean block){
        this.block = block;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void setAir(boolean air) {
        this.air = air;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public void setBurnable(boolean burnable) {
        this.burnable = burnable;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public void setOccluding(boolean occluding) {
        this.occluding = occluding;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public void setItem(boolean item) {
        this.item = item;
    }

    public void setInteractable(boolean interactable) {
        this.interactable = interactable;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public void setResistance(float resistance) {
        this.resistance = resistance;
    }

    public void setSlipperiness(float slipperiness) {
        this.slipperiness = slipperiness;
    }

    public void setCraftingRemainingItem(Material material) {
        this.remain = material;
    }

    public void setEquipmentSlot(EquipmentSlot slot) {
        this.slot = slot;
    }
}
