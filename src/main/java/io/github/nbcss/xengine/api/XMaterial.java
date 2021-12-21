package io.github.nbcss.xengine.api;

import org.bukkit.Material;

public interface XMaterial {
    String getName();
    default Material asBukkitMaterial(){
        return Material.VOID_AIR;
    }
}
