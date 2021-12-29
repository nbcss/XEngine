package io.github.nbcss.xengine.core;

import io.github.nbcss.xengine.api.XSoundEffectGroup;
import net.minecraft.world.level.block.SoundType;

public class SoundEffect implements XSoundEffectGroup {
    private final SoundType handle;
    public SoundEffect(SoundType handle){
        this.handle = handle;
    }

    public SoundType getSound(){
        return handle;
    }
}
