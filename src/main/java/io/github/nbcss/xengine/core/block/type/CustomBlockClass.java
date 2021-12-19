package io.github.nbcss.xengine.core.block.type;

import io.github.nbcss.xengine.core.block.BlockSettings;
import io.github.nbcss.xengine.utils.ActionResult;
import io.github.nbcss.xengine.utils.TriggerHandler;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.EnumHand;
import net.minecraft.world.EnumInteractionResult;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.phys.MovingObjectPositionBlock;
import org.bukkit.inventory.EquipmentSlot;

public class CustomBlockClass extends BlockClass {
    private final TriggerHandler handler;
    private CustomBlockClass(TriggerHandler handler){
        this.handler = handler;
    }

    @Override
    public Block create(BlockSettings settings) {
        return new CustomBlock(settings.getInfo(), handler);
    }

    public static CustomBlockClass of(TriggerHandler handler){
        return new CustomBlockClass(handler);
    }

    public static class CustomBlock extends Block {
        private final TriggerHandler handler;
        public CustomBlock(Info info, TriggerHandler handler) {
            super(info);
            this.handler = handler;
        }

        @Override
        public EnumInteractionResult interact(IBlockData iblockdata, World world, BlockPosition pos, EntityHuman entity, EnumHand hand, MovingObjectPositionBlock hit) {
            //todo
            EquipmentSlot slot = hand == EnumHand.a ? EquipmentSlot.HAND : EquipmentSlot.OFF_HAND;
            ActionResult result = handler.onUse(null, null, null, null, slot, hit);
            return EnumInteractionResult.values()[result.ordinal()];
        }
    }
}
