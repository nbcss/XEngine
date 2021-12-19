package io.github.nbcss.xengine.api.block;

import io.github.nbcss.xengine.api.XMapColor;
import io.github.nbcss.xengine.api.XSoundEffectGroup;
import io.github.nbcss.xengine.core.block.BlockSettings;

import java.util.function.ToIntFunction;

public interface XBlockSettings {
    XBlockSettings noCollision();
    XBlockSettings nonOpaque();
    XBlockSettings slipperiness(float slipperiness);
    XBlockSettings velocityMultiplier(float velocityMultiplier);
    XBlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier);
    XBlockSettings sounds(XSoundEffectGroup group);
    XBlockSettings luminance(ToIntFunction<XBlockState> luminance);
    XBlockSettings strength(float hardness, float resistance);
    XBlockSettings breakInstantly();
    XBlockSettings strength(float strength);
    XBlockSettings ticksRandomly();
    XBlockSettings dynamicBounds();
    XBlockSettings dropsNothing();
    XBlockSettings dropsLike(XBlock source);
    XBlockSettings air();
    XBlockSettings solidBlock(XBlock.StatePredicate predicate);
    XBlockSettings suffocates(XBlock.StatePredicate predicate);
    XBlockSettings blockVision(XBlock.StatePredicate predicate);
    XBlockSettings postProcess(XBlock.StatePredicate predicate);
    XBlockSettings emissiveLighting(XBlock.StatePredicate predicate);
    XBlockSettings requiresTool();
    BlockSettings mapColor(XMapColor color);
    XBlockSettings hardness(float hardness);
    XBlockSettings resistance(float resistance);

    static XBlockSettings of(XBlockMaterial material){
        return BlockSettings.of(material);
    }
}
