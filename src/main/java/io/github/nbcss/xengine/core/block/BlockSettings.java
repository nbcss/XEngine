package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.XMapColor;
import io.github.nbcss.xengine.api.XSoundEffectGroup;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockMaterial;
import io.github.nbcss.xengine.api.block.XBlockSettings;
import io.github.nbcss.xengine.api.block.XBlockState;
import io.github.nbcss.xengine.core.MapColor;
import io.github.nbcss.xengine.core.SoundEffect;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.ToIntFunction;

public class BlockSettings implements XBlockSettings {
    private final BlockBehaviour.Properties info;
    private BlockSettings(BlockBehaviour.Properties info){
        this.info = info;
    }

    @Override
    public BlockBehaviour.Properties asInfo() {
        return info;
    }

    @Override
    public BlockSettings noCollision(){
        info.noCollission();
        return this;
    }

    @Override
    public BlockSettings nonOpaque(){
        info.noOcclusion();
        return this;
    }

    @Override
    public BlockSettings slipperiness(float slipperiness){
        info.friction(slipperiness);
        return this;
    }

    @Override
    public BlockSettings velocityMultiplier(float velocityMultiplier){
        info.speedFactor(velocityMultiplier);
        return this;
    }

    @Override
    public BlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier){
        info.jumpFactor(jumpVelocityMultiplier);
        return this;
    }

    @Override
    public BlockSettings sounds(XSoundEffectGroup group){
        info.sound(((SoundEffect) group).getSound());
        return this;
    }

    @Override
    public BlockSettings luminance(ToIntFunction<XBlockState> luminance){
        info.lightLevel(value -> luminance.applyAsInt(new BlockStateContainer(value)));
        return this;
    }

    @Override
    public BlockSettings strength(float hardness, float resistance){
        info.strength(hardness, resistance);
        return this;
    }

    @Override
    public BlockSettings breakInstantly() {
        info.instabreak();
        return this;
    }

    @Override
    public BlockSettings strength(float strength) {
        info.strength(strength);
        return this;
    }

    @Override
    public BlockSettings ticksRandomly() {
        info.randomTicks();
        return this;
    }

    @Override
    public BlockSettings dynamicBounds() {
        info.dynamicShape();
        return this;
    }

    @Override
    public BlockSettings dropsNothing() {
        info.noDrops();
        return this;
    }

    @Override
    public BlockSettings dropsLike(XBlock source) {
        info.dropsLike(source.asBlock());
        return this;
    }

    @Override
    public BlockSettings air() {
        info.air();
        return this;
    }

    //todo
    /*public BlockSettings allowsSpawning(AbstractBlock.TypedContextPredicate<EntityType<?>> predicate) {
        this.allowsSpawningPredicate = predicate;
        return this;
    }
    */

    @Override
    public BlockSettings solidBlock(XBlock.StatePredicate predicate) {
        info.isRedstoneConductor(predicate::test);
        return this;
    }

    @Override
    public BlockSettings suffocates(XBlock.StatePredicate predicate) {
        info.isSuffocating(predicate::test);
        return this;
    }

    @Override
    public BlockSettings blockVision(XBlock.StatePredicate predicate) {
        info.isViewBlocking(predicate::test);
        return this;
    }

    @Override
    public BlockSettings postProcess(XBlock.StatePredicate predicate) {
        info.hasPostProcess(predicate::test);
        return this;
    }

    @Override
    public BlockSettings emissiveLighting(XBlock.StatePredicate predicate) {
        info.emissiveRendering(predicate::test);
        return this;
    }

    @Override
    public BlockSettings requiresTool() {
        info.requiresCorrectToolForDrops();
        return this;
    }

    @Override
    public BlockSettings mapColor(XMapColor color) {
        info.color(((MapColor) color).getColor());
        return this;
    }

    @Override
    public BlockSettings hardness(float hardness) {
        info.destroyTime(hardness);
        return this;
    }

    @Override
    public BlockSettings resistance(float resistance) {
        info.explosionResistance(resistance);
        return this;
    }

    public static BlockSettings of(Material material){
        return new BlockSettings(BlockBehaviour.Properties.of(material));
    }

    public static BlockSettings of(XBlockMaterial material){
        return of(((BlockMaterial) material).asMaterial());
    }
}
