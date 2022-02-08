package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.TransformByCraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.World;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@TransformByCraft("block.CraftBlockStates")
public class CraftBlockTransformer {

    @Inject(InjectionType.INSERT)
    private static Object getBlockState(World world,
                                        BlockPos blockPosition,
                                        BlockState blockData,
                                        BlockEntity tileEntity) {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
        String name = "Minecraft:XEngine=Transformer", channel = "getBlockState";
        Object[] values = {world, blockPosition, blockData, tileEntity, null};
        try{
            ObjectName objectName = new ObjectName(name);
            Object[] parameters = {channel, values};
            server.invoke(objectName, "dispatch", parameters, signature);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        Object result = values[4];
        if(result != null) {
            return result;
        }
        throw null;
    }
}
