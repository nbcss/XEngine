package io.github.nbcss.xengine;

import io.github.nbcss.xengine.inject.handler.*;
import io.github.nbcss.xengine.inject.handler.material.*;
import io.github.nbcss.xengine.inject.transformer.CraftBlockTransformer;
import io.github.nbcss.xengine.inject.transformer.CraftItemTransformer;
import io.github.nbcss.xengine.inject.transformer.MaterialTransformer;
import io.github.nbcss.xengine.network.RegistrySyncSystem;
import me.yamakaja.runtimetransformer.RuntimeTransformer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class XEngine extends JavaPlugin implements Listener {

    @Override
    public void onLoad() {
        try{
            RuntimeTransformer.addProcessors(
                    new NMSCopyHandler(),
                    new BukkitCopyHandler(),
                    new NewCraftStackHandler(),
                    new CraftBlockStateHandler(),
                    new IsBlockHandler(),
                    new IsEdibleHandler(),
                    new IsRecordHandler(),
                    new IsSolidHandler(),
                    new IsAirHandler(),
                    new IsTransparentHandler(),
                    new IsFlammableHandler(),
                    new IsBurnableHandler(),
                    new IsFuelHandler(),
                    new IsOccludingHandler(),
                    new HasGravityHandler(),
                    new IsItemHandler(),
                    new IsInteractableHandler(),
                    new GetHardnessHandler(),
                    new GetBlastResistanceHandler(),
                    new GetSlipperinessHandler(),
                    new GetCraftingRemainingItemHandler(),
                    new GetEquipmentSlotHandler());
            RuntimeTransformer.addTransformers(
                    CraftBlockTransformer.class,
                    CraftItemTransformer.class,
                    MaterialTransformer.class);
            Class.forName("io.github.nbcss.xengine.example.ExampleBlocks");
            Class.forName("io.github.nbcss.xengine.example.ExampleItems");
        }catch (Throwable e){
            e.printStackTrace();
            Bukkit.getLogger().warning("[FATAL ERROR] " +
                    "XEngine cannot load and will shutdown the server to protect data");
            Bukkit.shutdown();
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        try{
            saveDefaultConfig();
            boolean temp = getConfig().getBoolean("use-temp-file", true);
            RuntimeTransformer.attach(this, temp);
            getServer().getPluginManager().registerEvents(this, this);
        }catch (Throwable e){
            e.printStackTrace();
            Bukkit.getLogger().warning("[FATAL ERROR] " +
                    "XEngine cannot start and will shutdown the server to protect data");
            Bukkit.shutdown();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        RegistrySyncSystem.sync(event.getPlayer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // Material.LEGACY_AIR
    }
}
