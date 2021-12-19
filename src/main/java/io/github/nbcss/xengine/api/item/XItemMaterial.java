package io.github.nbcss.xengine.api.item;

import org.bukkit.Material;

public interface XItemMaterial {
    String getName();
    default Material asBukkitMaterial(){
        return Material.VOID_AIR;
    }
}
