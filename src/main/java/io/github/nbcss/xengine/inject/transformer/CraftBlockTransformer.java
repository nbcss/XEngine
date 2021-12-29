package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.agent.Agent;
import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.TransformByCraft;
import me.yamakaja.runtimetransformer.comm.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.World;

@TransformByCraft("block.CraftBlockStates")
public class CraftBlockTransformer {

    @Inject(InjectionType.INSERT)
    private static Object getBlockState(World world,
                                        BlockPos blockPosition,
                                        BlockState blockData,
                                        BlockEntity tileEntity) {
        Message message = new Message("getBlockState",
                world, blockPosition, blockData, tileEntity, null);
        Agent.getInstance().getHandler().handle(message);
        Object result = message.getValue(4);
        if(result != null) {
            return result;
        }
        throw null;
    }
}
