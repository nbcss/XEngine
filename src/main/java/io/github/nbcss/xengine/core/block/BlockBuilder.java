package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.api.block.XBlockSettings;
import io.github.nbcss.xengine.core.block.type.BlockClass;
import io.github.nbcss.xengine.core.block.type.BaseBlockClass;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.core.IRegistry;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.Map;

@SuppressWarnings("unchecked")
public class BlockBuilder implements XBlock.Builder {
    private static final Map<Block, Material> MATERIAL_MAP = (Map<Block, Material>) Reflection.get(
            Reflection.bukkitField("util", "CraftMagicNumbers", "BLOCK_MATERIAL"),
            null);
    private final MinecraftKey key;
    private XBlockClass handler = BaseBlockClass.INSTANCE;
    private XBlockSettings settings;
    private Material type = Material.AIR;
    public BlockBuilder(String namespace, String id){
        this.key = new MinecraftKey(namespace, id);
    }

    @Override
    public XBlock.Builder handler(XBlockClass type){
        this.handler = type;
        return this;
    }

    @Override
    public XBlock.Builder type(Material material){
        this.type = material;
        return this;
    }

    @Override
    public XBlock.Builder info(XBlockSettings settings){
        this.settings = settings;
        return this;
    }

    @Override
    public XBlock register(){
        assert settings != null && handler != null;
        ResourceKey<Block> resourceKey = ResourceKey.a(IRegistry.W.f(), key);
        Block old = IRegistry.W.a(resourceKey);
        if(old != null){
            return BlockContainer.of(old);
        }
        Block block = ((BlockClass) handler).create((BlockSettings) settings);
        init(block, type);
        Bukkit.getLogger().info("Added Block [" + key + "]");
        return BlockContainer.of(IRegistry.a(IRegistry.W, key, block));
    }

    public static void init(Block block, Material type){
        MATERIAL_MAP.put(block, type);
        for (IBlockData state : block.getStates().a()) {
            state.a();
            Block.p.b(state);
        }
    }
}
