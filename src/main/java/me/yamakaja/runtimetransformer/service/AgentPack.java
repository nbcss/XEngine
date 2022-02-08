package me.yamakaja.runtimetransformer.service;

import com.google.common.collect.Maps;
import me.yamakaja.runtimetransformer.XMessage;
import me.yamakaja.runtimetransformer.XMessageProcessor;

import java.util.List;
import java.util.Map;

public class AgentPack implements AgentPackMBean {
    private final Map<String, XMessageProcessor> handlers = Maps.newHashMap();
    private final Class<?>[] transformers;
    public AgentPack(List<XMessageProcessor> processors, Class<?>[] transformers){
        this.transformers = transformers;
        for (XMessageProcessor processor : processors) {
            handlers.put(processor.getChannel(), processor);
        }
    }

    @Override
    public Class<?>[] getTransformers() {
        return transformers;
    }

    @Override
    public void dispatch(String channel, Object[] values) {
        XMessageProcessor processor = handlers.get(channel);
        if(processor != null) {
            XMessage message = new XMessage(channel, values);
            processor.handle(message);
        }else{
            System.err.println("Received message for channel " + channel + " but no handler process it");
        }
    }
}
