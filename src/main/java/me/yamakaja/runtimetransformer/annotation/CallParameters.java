package me.yamakaja.runtimetransformer.annotation;

import org.objectweb.asm.Opcodes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static me.yamakaja.runtimetransformer.annotation.CallParameters.Type.VIRTUAL;

/**
 * Created by Yamakaja on 3/5/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CallParameters {

    /**
     * The method invocation type, this allows differentiation between static, virtual or special invocation
     */
    Type type() default VIRTUAL;

    /**
     * The call which owns the method
     */
    String owner() default "";

    /**
     * The name of the method
     */
    String name() default "";

    /**
     * The method signature in internal format: (Params)Return
     * That means, a method with the Java signature int getSomethingFrom(Object test) has an description of
     * <bold>(Ljava/lang/Object;)I</bold>
     */
    String desc() default "";

    /**
     * Whether or not the targeted method is an interface method
     */
    boolean itf() default false;

    public static enum Type {
        VIRTUAL(Opcodes.INVOKEVIRTUAL),
        SPECIAL(Opcodes.INVOKESPECIAL),
        STATIC(Opcodes.INVOKESTATIC);

        private int opcode;

        Type(int opcode) {
            this.opcode = opcode;
        }

        public int getOpcode() {
            return opcode;
        }

    }

}
