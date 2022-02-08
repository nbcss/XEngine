package me.yamakaja.runtimetransformer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TransformByCraft {
    String name() default "TransformByCraft";
    /**
     * @return The string representation of the transformation craftbukkit target as returned by {@link Class#getName()}
     */
    String value();
}
