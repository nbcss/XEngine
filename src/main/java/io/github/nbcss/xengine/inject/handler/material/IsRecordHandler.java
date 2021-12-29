package io.github.nbcss.xengine.inject.handler.material;

import io.github.nbcss.xengine.api.XMaterial;
import io.github.nbcss.xengine.core.MaterialContainer;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;
import org.bukkit.Material;

public class IsRecordHandler implements XMessageProcessor {
    @Override
    public String getChannel() {
        return "Material.isRecord";
    }

    @Override
    public void handle(XMessage message) {
        Material material = (Material) message.getValue(0);
        XMaterial type = MaterialContainer.get(material);
        if(type != null){
            message.setValue(1, type.getData().isRecord());
        }
    }
}
