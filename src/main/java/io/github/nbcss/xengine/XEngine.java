package io.github.nbcss.xengine;

import io.github.nbcss.xengine.inject.handler.BukkitCopyHandler;
import io.github.nbcss.xengine.inject.handler.NMSCopyHandler;
import io.github.nbcss.xengine.inject.handler.NewCraftStackHandler;
import io.github.nbcss.xengine.inject.transformer.CraftItemTransformer;
import me.yamakaja.runtimetransformer.RuntimeTransformer;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_17_R1.block.CraftBlockStates;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class XEngine extends JavaPlugin implements Listener {

    @Override
    public void onLoad() {
        try{
            Class.forName("io.github.nbcss.xengine.example.ExampleBlocks");
            Class.forName("io.github.nbcss.xengine.example.ExampleItems");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        RuntimeTransformer.attach(this,
                List.of(new NMSCopyHandler(), new BukkitCopyHandler(), new NewCraftStackHandler()),
                List.of(CraftItemTransformer.class)
        );
        getServer().getPluginManager().registerEvents(this, this);
    }

    /*@EventHandler
    public void onClickItem(PlayerInteractEvent event){
        XItemStack item = XItemStack.as(event.getItem());
        if(item != null){
            System.out.println("It is " + item.getMaterial().getName());
        }
        System.out.println("Test start");
        System.out.println(CraftItemStack.asNewCraftStack(Items.M));;
        System.out.println("Test succ");
    }*/

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // Material.LEGACY_AIR
    }
}
