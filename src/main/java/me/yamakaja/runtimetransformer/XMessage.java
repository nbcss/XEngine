package me.yamakaja.runtimetransformer;

import me.yamakaja.runtimetransformer.comm.Message;

public class XMessage {
    //private final Object[] values;
    private final Message message;

    public XMessage(Message message){
        //this.values = values;
        this.message = message;
    }

    public Object getValue(int i){
        return message.getValue(i);
    }

    public void setValue(int i, Object value){
        //this.values[i] = value;
        message.setValue(i, value);
    }
}
