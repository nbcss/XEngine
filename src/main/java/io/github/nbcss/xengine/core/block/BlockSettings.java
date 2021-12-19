package io.github.nbcss.xengine.core.block;

import io.github.nbcss.xengine.api.XMapColor;
import io.github.nbcss.xengine.api.XSoundEffectGroup;
import io.github.nbcss.xengine.api.block.XBlock;
import io.github.nbcss.xengine.api.block.XBlockMaterial;
import io.github.nbcss.xengine.api.block.XBlockSettings;
import io.github.nbcss.xengine.api.block.XBlockState;
import io.github.nbcss.xengine.core.MapColor;
import io.github.nbcss.xengine.core.SoundEffect;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.block.SoundEffectType;
import net.minecraft.world.level.block.state.BlockBase;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialMapColor;
import org.bukkit.block.data.BlockData;

import java.util.function.ToIntFunction;

public class BlockSettings implements XBlockSettings {
    private final BlockBase.Info info;
    private BlockSettings(BlockBase.Info info){
        this.info = info;
    }

    public BlockBase.Info getInfo() {
        return info;
    }

    @Override
    public BlockSettings noCollision(){
        info.a();
        return this;
    }

    @Override
    public BlockSettings nonOpaque(){
        info.b();
        return this;
    }

    @Override
    public BlockSettings slipperiness(float slipperiness){
        info.a(slipperiness);
        return this;
    }

    @Override
    public BlockSettings velocityMultiplier(float velocityMultiplier){
        info.b(velocityMultiplier);
        return this;
    }

    @Override
    public BlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier){
        info.c(jumpVelocityMultiplier);
        return this;
    }

    @Override
    public BlockSettings sounds(XSoundEffectGroup group){
        info.a(((SoundEffect) group).getSound());
        return this;
    }

    @Override
    public BlockSettings luminance(ToIntFunction<XBlockState> luminance){
        info.a(value -> luminance.applyAsInt(new BlockStateContainer(value)));
        return this;
    }

    @Override
    public BlockSettings strength(float hardness, float resistance){
        info.a(hardness, resistance);
        return this;
    }

    @Override
    public BlockSettings breakInstantly() {
        info.c();
        return this;
    }

    @Override
    public BlockSettings strength(float strength) {
        info.d(strength);
        return this;
    }

    @Override
    public BlockSettings ticksRandomly() {
        info.d();
        return this;
    }

    @Override
    public BlockSettings dynamicBounds() {
        info.e();
        return this;
    }

    @Override
    public BlockSettings dropsNothing() {
        info.f();
        return this;
    }

    @Override
    public BlockSettings dropsLike(XBlock source) {
        info.a(((BlockContainer) source).getBlock());
        return this;
    }

    @Override
    public BlockSettings air() {
        info.g();
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
        info.a(predicate::test);
        return this;
    }

    @Override
    public BlockSettings suffocates(XBlock.StatePredicate predicate) {
        info.b(predicate::test);
        return this;
    }

    @Override
    public BlockSettings blockVision(XBlock.StatePredicate predicate) {
        info.c(predicate::test);
        return this;
    }

    @Override
    public BlockSettings postProcess(XBlock.StatePredicate predicate) {
        info.d(predicate::test);
        return this;
    }

    @Override
    public BlockSettings emissiveLighting(XBlock.StatePredicate predicate) {
        info.e(predicate::test);
        return this;
    }

    @Override
    public BlockSettings requiresTool() {
        info.h();
        return this;
    }

    @Override
    public BlockSettings mapColor(XMapColor color) {
        info.a(((MapColor) color).getColor());
        return this;
    }

    @Override
    public BlockSettings hardness(float hardness) {
        info.e(hardness);
        return this;
    }

    @Override
    public BlockSettings resistance(float resistance) {
        info.f(resistance);
        return this;
    }

    public static BlockSettings of(Material material){
        return new BlockSettings(BlockBase.Info.a(material));
    }

    public static BlockSettings of(XBlockMaterial material){
        return of(((BlockMaterial) material).asMaterial());
    }
}
