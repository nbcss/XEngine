package io.github.nbcss.xengine.inject.transformer;

import me.yamakaja.runtimetransformer.agent.Agent;
import me.yamakaja.runtimetransformer.annotation.Inject;
import me.yamakaja.runtimetransformer.annotation.InjectionType;
import me.yamakaja.runtimetransformer.annotation.Transform;
import me.yamakaja.runtimetransformer.comm.Message;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

@Transform(Material.class)
public class MaterialTransformer {
    private int id;

    @Inject(InjectionType.INSERT)
    public boolean isBlock(){
        if(this.id < 0) {
            Message message = new Message("Material.isBlock", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isEdible(){
        if(this.id < 0) {
            Message message = new Message("Material.isEdible", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isRecord() {
        if(this.id < 0) {
            Message message = new Message("Material.isRecord", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isSolid() {
        if(this.id < 0) {
            Message message = new Message("Material.isSolid", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isAir() {
        if(this.id < 0) {
            Message message = new Message("Material.isAir", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isTransparent() {
        if(this.id < 0) {
            Message message = new Message("Material.isTransparent", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isFlammable() {
        if(this.id < 0) {
            Message message = new Message("Material.isFlammable", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isBurnable() {
        if(this.id < 0) {
            Message message = new Message("Material.isBurnable", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isFuel() {
        if(this.id < 0) {
            Message message = new Message("Material.isFuel", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isOccluding() {
        if(this.id < 0) {
            Message message = new Message("Material.isOccluding", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean hasGravity() {
        if(this.id < 0) {
            Message message = new Message("Material.hasGravity", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isItem() {
        if(this.id < 0) {
            Message message = new Message("Material.isItem", this, true);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public boolean isInteractable() {
        if(this.id < 0) {
            Message message = new Message("Material.isInteractable", this, false);
            Agent.getInstance().getHandler().handle(message);
            return (boolean) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getHardness() {
        if(this.id < 0) {
            Message message = new Message("Material.getHardness", this, 1.0F);
            Agent.getInstance().getHandler().handle(message);
            return (float) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getBlastResistance() {
        if(this.id < 0) {
            Message message = new Message("Material.getBlastResistance", this, 1.0F);
            Agent.getInstance().getHandler().handle(message);
            return (float) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public float getSlipperiness() {
        if(this.id < 0) {
            Message message = new Message("Material.getSlipperiness", this, 0.6F);
            Agent.getInstance().getHandler().handle(message);
            return (float) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public Material getCraftingRemainingItem() {
        if(this.id < 0) {
            Message message = new Message("Material.getCraftingRemainingItem", this, null);
            Agent.getInstance().getHandler().handle(message);
            return (Material) message.getValue(1);
        }
        throw null;
    }

    @Inject(InjectionType.INSERT)
    public EquipmentSlot getEquipmentSlot() {
        if(this.id < 0) {
            Message message = new Message("Material.getEquipmentSlot", this, null);
            Agent.getInstance().getHandler().handle(message);
            return (EquipmentSlot) message.getValue(1);
        }
        throw null;
    }
}
