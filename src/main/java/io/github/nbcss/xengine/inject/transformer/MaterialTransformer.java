package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.Transform;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

@Transform(Material.class)
public class MaterialTransformer {
    private int id;

    @Inject(InjectionType.INSERT)
    public boolean isBlock(){
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isBlock";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isEdible(){
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isEdible";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isRecord() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isRecord";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isSolid() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isSolid";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isAir() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isAir";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isTransparent() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isTransparent";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isFlammable() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isFlammable";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isBurnable() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isBurnable";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isFuel() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isFuel";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isOccluding() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isOccluding";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean hasGravity() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.hasGravity";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isItem() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isItem";
            Object[] values = {this, true};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isInteractable() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.isInteractable";
            Object[] values = {this, false};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (boolean) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getHardness() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.getHardness";
            Object[] values = {this, 1.0F};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (float) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getBlastResistance() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.getBlastResistance";
            Object[] values = {this, 1.0F};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (float) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getSlipperiness() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.getSlipperiness";
            Object[] values = {this, 0.6F};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (float) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public Material getCraftingRemainingItem() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.getCraftingRemainingItem";
            Object[] values = {this, null};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (Material) values[1];
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public EquipmentSlot getEquipmentSlot() {
        if(this.id < 0) {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            String[] signature = {"java.lang.String", "[Ljava.lang.Object;"};
            String name = "Minecraft:XEngine=Transformer", channel = "Material.getEquipmentSlot";
            Object[] values = {this, null};
            try{
                ObjectName objectName = new ObjectName(name);
                Object[] parameters = {channel, values};
                server.invoke(objectName, "dispatch", parameters, signature);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return (EquipmentSlot) values[1];
        }
        throw null;
    }
}
