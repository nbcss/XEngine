package me.yamakaja.runtimetransformer.service;

public interface AgentPackMBean {
    Class<?>[] getTransformers();
    void dispatch(String channel, Object[] values);
}
