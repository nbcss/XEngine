package io.github.nbcss.xengine.core.block;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import io.github.nbcss.xengine.api.XRegistry;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockEntity;
import io.github.nbcss.xengine.api.block.XBlockEntityType;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Set;

public class BlockEntityTypeBuilder<T extends BlockEntity, U extends XBlockEntity<T>>
        implements XBlockEntityType.Builder<T, U> {
    private static final Class<?> FACTORY = Reflection.asClass(
            "net.minecraft.world.level.block.entity.TileEntityTypes$a");
    private static final Constructor<BlockEntityType> CONSTRUCTOR = Reflection.constructor(
            BlockEntityType.class, FACTORY, Set.class, Type.class);

    private final ResourceLocation key;
    private XBlockEntityType.Factory<? extends T, U> factory;
    private Block[] blocks;

    private BlockEntityTypeBuilder(XBlockEntityType.Factory<? extends T, U> factory, Block[] blocks) {
        this.factory = factory;
        this.blocks = blocks;
        this.key = null;
    }

    private BlockEntityTypeBuilder(String namespace, String id){
        this.key = new ResourceLocation(namespace, id);
    }

    public static <T extends BlockEntity, U extends XBlockEntity<T>> BlockEntityTypeBuilder<T, U>
    of(XBlockEntityType.Factory<? extends T, U> factory, Block... blocks) {
        return new BlockEntityTypeBuilder<>(factory, blocks);
    }

    public static <T extends BlockEntity, U extends XBlockEntity<T>> BlockEntityTypeBuilder<T, U>
    of(String namespace, String id) {
        return new BlockEntityTypeBuilder<>(namespace, id);
    }

    public BlockEntityType<?> build() {
        return build(null);
    }

    public BlockEntityType<?> build(Type<?> type) {
        try {
            Object factory = java.lang.reflect.Proxy.newProxyInstance(BlockEntityType.class.getClassLoader(),
                    new Class<?>[]{FACTORY},
                    new Proxy<>(this.factory));
            Set<Block> blocks = ImmutableSet.copyOf(this.blocks);
            return CONSTRUCTOR.newInstance(factory, blocks, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public XBlockEntityType.Builder<T, U> factory(XBlockEntityType.Factory<T, U> factory) {
        this.factory = (pos, state) -> (U) factory.create(pos, state).asTileEntity();
        return this;
    }

    @Override
    public XBlockEntityType.Builder<T, U> blocks(XBlock... blocks) {
        this.blocks = Arrays.stream(blocks).map(block -> ((BlockContainer)block).asBlock()).toArray(Block[]::new);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public XBlockEntityType<T, U> register() {
        assert key != null;
        BlockEntityType<T> old = (BlockEntityType<T>) XRegistry.BLOCK_ENTITY_TYPE.get(key);
        if(old != null){
            return BlockEntityTypeContainer.of(old);
        }
        BlockEntityType<?> types = build();
        BlockEntityType<T> current = (BlockEntityType<T>) XRegistry.BLOCK_ENTITY_TYPE.register(key, types);
        return BlockEntityTypeContainer.of(current);
    }

    private static class Proxy<T extends BlockEntity, U extends XBlockEntity<T>> implements InvocationHandler {
        private final XBlockEntityType.Factory<? extends T, U> factory;
        private Proxy(XBlockEntityType.Factory<? extends T, U> factory){
            this.factory = factory;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            if(method.getName().equals("create")) {
                BlockPos pos = (BlockPos) args[0];
                BlockState state = (BlockState) args[1];
                return factory.create(pos, state).asTileEntity();
            }
            throw new RuntimeException("Incorrect call of method");
        }
    }
}
