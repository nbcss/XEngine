package me.yamakaja.runtimetransformer;

public interface XMessageProcessor {
    String getChannel();
    void handle(XMessage message);
}
