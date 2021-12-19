package io.github.nbcss.xengine.utils;

import net.minecraft.world.phys.MovingObjectPositionBlock;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

public class TriggerHandler {
    public ActionResult onUse(BlockState state, World world, Location pos, Player player, EquipmentSlot hand, MovingObjectPositionBlock hit) {
        return ActionResult.PASS;
    }
}
