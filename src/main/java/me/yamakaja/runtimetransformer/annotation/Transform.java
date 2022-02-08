package me.yamakaja.runtimetransformer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Yamakaja on 19.05.17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Transform {
    String name() default "Transform";
    /**
     * @return The transformation target
     */
    Class<?> value();
}
