package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.api.XRegistry;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockClass;
import io.github.nbcss.xengine.api.block.XBlockMaterial;
import io.github.nbcss.xengine.api.block.XBlockSettings;
import io.github.nbcss.xengine.core.block.type.BaseBlockClass;
import io.github.nbcss.xengine.utils.Reflection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.Map;

@SuppressWarnings("unchecked")
public class BlockBuilder implements XBlock.Builder {
    private static final Map<Block, Material> BLOCK_MATERIAL = (Map<Block, Material>) Reflection.get(
            Reflection.bukkitField("util", "CraftMagicNumbers", "BLOCK_MATERIAL"),
            null);
    private static final Map<Material, Block> MATERIAL_BLOCK = (Map<Material, Block>) Reflection.get(
            Reflection.bukkitField("util", "CraftMagicNumbers", "MATERIAL_BLOCK"),
            null);
    private final ResourceLocation key;
    private XBlockClass handler = BaseBlockClass.INSTANCE;
    private XBlockSettings settings = XBlockSettings.of(XBlockMaterial.AIR);
    private XMaterial type = null;
    public BlockBuilder(String namespace, String id){
        this.key = new ResourceLocation(namespace, id);
    }

    @Override
    public XBlock.Builder handler(XBlockClass type){
        this.handler = type;
        return this;
    }

    @Override
    public XBlock.Builder type(XMaterial material){
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
        assert settings != null && handler != null && type != null;
        Block old = XRegistry.BLOCK.get(key);
        if(old != null){
            return BlockContainer.of(old, type);
        }
        Block block = handler.create((BlockSettings) settings);
        init(block, type);
        Bukkit.getLogger().info("[XEngine] +Block [" + key + "]");
        return BlockContainer.of(XRegistry.BLOCK.register(key, block), type);
    }

    private static void init(Block block, XMaterial type){
        BLOCK_MATERIAL.put(block, type.asBukkitMaterial());
        if(!type.isVanilla()){
            MATERIAL_BLOCK.put(type.asBukkitMaterial(), block);
        }
        for (BlockState state : block.getStateDefinition().getPossibleStates()) {
            state.initCache();
            Block.BLOCK_STATE_REGISTRY.add(state);
        }
    }
}
