package me.yamakaja.runtimetransformer;

public record XMessage(String channel, Object... values) {

    public Object getValue(int i) {
        return values[i];
    }

    public void setValue(int i, Object value) {
        this.values[i] = value;
    }

    public int size() {
        return values.length;
    }

    public void dispatch(){
        throw new RuntimeException("Only available in VM environment");
    }
}