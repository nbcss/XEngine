package me.yamakaja.runtimetransformer.annotation;

/**
 * Created by Yamakaja on 19.05.17.
 */
public enum InjectionType {
    /**
     * Insert code at the beginning of the method
     */
    INSERT,

    /**
     * Overwrite method
     */
    OVERRIDE,

    /**
     * Append at end of method
     */
    APPEND
}
