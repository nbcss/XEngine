package io.github.nbcss.xengine.api;

import io.github.nbcss.xengine.core.MaterialBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

public interface XMaterial {
    String getName();
    Material asBukkitMaterial();
    boolean isEquals(Material material);
    boolean isVanilla();
    Data getData();

    interface Builder {
        /**
         * Mapping the material to a NMS item id
         */
        Builder mapping(String namespace, String id);
        /**
         * Set the max stack count of the material (default = 64, no compatible with durability)
         */
        Builder maxCount(int count);
        /**
         * Set the durability of the material (default = 0, no compatible with max stack number)
         */
        Builder maxDurability(short durability);
        /**
         * Set if this Material is a placeable block (default = false)
         */
        Builder block(boolean block);
        /**
         * Set if this Material is edible (food) (default = false)
         */
        Builder edible(boolean edible);
        /**
         * Set if this Material is a record (default = false)
         */
        Builder record(boolean record);
        /**
         * Set if this Material is a solid block (can be built upon)
         * If it is not block it will always be false (default = true)
         */
        Builder solid(boolean solid);
        /**
         * Set if this Material is an air type block (default = false)
         */
        Builder air(boolean air);
        /**
         * Set if this Material is a transparent block
         * If it is not block it will always be false (default = false)
         */
        Builder transparent(boolean transparent);
        /**
         * Set if this Material can catch fire as block
         * If it is not block it will always be false (default = false)
         */
        Builder flammable(boolean flammable);
        /**
         * Set if this Material can be destroyed by catch fire as block
         * If it is not block it will always be false (default = false)
         */
        Builder burnable(boolean burnable);
        /**
         * Set if this Material can be used as fuel in a Furnace (default = false)
         */
        Builder fuel(boolean fuel);
        /**
         * Set if the material is a block and completely blocks vision
         * If it is not block it will always be false (default = true)
         */
        Builder occluding(boolean occluding);
        /**
         * Set if this material is affected by gravity
         * If it is not block it will always be false (default = false)
         */
        Builder gravity(boolean gravity);
        /**
         * Set if this Material is an obtainable item (default = true)
         */
        Builder item(boolean item);
        /**
         * Set if this Material can be interacted (right-clicked) with as PLACED BLOCK.
         * It will not require to be a block to be true anyway (default = false)
         */
        Builder interactable(boolean interactable);
        /**
         * Set the material hardness as block
         * If it is not block it will always be 0 (default = 1.0)
         */
        Builder hardness(float hardness);
        /**
         * Set the material blast resistance as block
         * If it is not block it will always be 0 (default = 1.0)
         */
        Builder blastResistance(float resistance);
        /**
         * Set the material slipperiness as block
         * If it is not block it will always be 0 (default = 0.6)
         */
        Builder slipperiness(float slipperiness);
        /**
         * Set what material will be remained in crafting table when use for crafting purpose
         * If it is not item it will always be null (default = null)
         */
        Builder craftingRemainingItem(Material material);
        /**
         * Set the material should be put into which equipment slot
         * If it is not item it will always be null (default = HAND)
         */
        Builder equipmentSlot(EquipmentSlot slot);
        /**
         * Complete the material build and register into bukkit server
         */
        XMaterial register();
    }

    static Builder of(String name){
        return MaterialBuilder.of(name);
    }

    interface Data {
        boolean isBlock();
        boolean isEdible();
        boolean isRecord();
        boolean isSolid();
        boolean isAir();
        boolean isTransparent();
        boolean isFlammable();
        boolean isBurnable();
        boolean isFuel();
        boolean isOccluding();
        boolean hasGravity();
        boolean isItem();
        boolean isInteractable();
        float getHardness();
        float getBlastResistance();
        float getSlipperiness();
        Material getCraftingRemainingItem();
        EquipmentSlot getEquipmentSlot();
    }
}
