package io.github.nbcss.xengine.utils;

import org.bukkit.Bukkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

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
            Constructor<T> constructor = target.getConstructor(args);
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

    public static Class<?> bukkitClass(String packageName,
                                       String className){
        try{
            String version = Bukkit.getServer().getClass().getPackage().getName()
                    .replace(".", ",").split(",")[3] + ".";
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

    public static Object get(Field field, Object target){
        try{
            return field.get(target);
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
}
