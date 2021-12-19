package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XSoundEffectGroup;
import net.minecraft.world.level.block.SoundEffectType;

public class SoundEffect implements XSoundEffectGroup {
    private final SoundEffectType handle;
    public SoundEffect(SoundEffectType handle){
        this.handle = handle;
    }

    public SoundEffectType getSound(){
        return handle;
    }
}
