package io.github.nbcss.xengine.inject.handler;

import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.core.block.BlockEntityTypeContainer;
import io.github.nbcss.xengine.utils.Reflection;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.World;

import java.lang.reflect.Constructor;

public class CraftBlockStateHandler implements XMessageProcessor {
    private static final Constructor<?> CONSTRUCTOR = Reflection.bukkitConstructor(
            "block", "CraftBlockState",
            World.class, BlockPos.class, BlockState.class);
    @Override
    public String getChannel() {
        return "getBlockState";
    }

    @Override
    public void handle(XMessage message) {
        BlockEntity tileEntity = (BlockEntity) message.getValue(3);
        if(tileEntity != null){
            BlockEntityTypeContainer<?, ? extends XBlockEntity<?>> typeContainer =
                    BlockEntityTypeContainer.get(tileEntity.getType());
            if(typeContainer != null){
                Object world = message.getValue(0);
                Object pos = message.getValue(1);
                Object data = message.getValue(2);
                message.setValue(4, Reflection.newInstance(CONSTRUCTOR, world, pos, data));
            }
        }
    }
}
