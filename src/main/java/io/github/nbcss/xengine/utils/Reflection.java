package io.github.nbcss.xengine.utils;

import org.bukkit.Bukkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

    public static <T> T handle(Class<T> cast,
                               Object craft){
        try{
            return cast.cast(method(craft.getClass(), "getHandle").invoke(craft));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Field field(Class<?> target,
                              String fieldName){
        try{
            Field field = target.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Method method(Class<?> target,
                                String methodName,
                                Class<?>... args){
        try{
            Method method = target.getDeclaredMethod(methodName, args);
            method.setAccessible(true);
            return method;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> Constructor<T> constructor(Class<T> target, Class<?>... args){
        try{
            Constructor<T> constructor = target.getDeclaredConstructor(args);
            constructor.setAccessible(true);
            return constructor;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Class<?> asClass(String name){
        try{
            return Class.forName(name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String bukkitVersion(){
        return Bukkit.getServer().getClass().getPackage().getName()
                .replace(".", ",").split(",")[3];
    }

    public static Class<?> bukkitClass(String packageName,
                                       String className){
        try{
            String version = bukkitVersion() + ".";
            StringBuilder name = new StringBuilder("org.bukkit.craftbukkit.");
            name.append(version);
            if(packageName != null)
                name.append(packageName).append(".");
            name.append(className);
            return Class.forName(name.toString());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Method bukkitMethod(String packageName,
                                      String className,
                                      String methodName,
                                      Class<?>... args){
        return method(bukkitClass(packageName, className), methodName, args);
    }

    public static Field bukkitField(String packageName,
                                    String className,
                                    String fieldName){
        return field(bukkitClass(packageName, className), fieldName);
    }

    @SuppressWarnings("unchecked")
    public static <T> Constructor<T> bukkitConstructor(String packageName,
                                                       String className,
                                                       Class<?>... args){
        return (Constructor<T>) constructor(bukkitClass(packageName, className), args);
    }

    public static Object get(Field field, Object target){
        try{
            return field.get(target);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void set(Field field, Object target, Object value){
        try{
            field.set(target, value);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Object invoke(Method method, Object target, Object... args){
        try{
            return method.invoke(target, args);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T newInstance(Constructor<T> constructor, Object... args){
        try{
            return constructor.newInstance(args);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
