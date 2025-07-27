package bl0.sdk.kyocera701.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class KyoceraProxy {
    @SuppressWarnings("unchecked")
    public static <T> T bind(final Object target, Class<T> iface) {
        return (T) Proxy.newProxyInstance(
                iface.getClassLoader(),
                new Class<?>[]{iface},
                (proxy, method, args) -> {
                    Method targetMethod;
                    try {
                        targetMethod = target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                        targetMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException("Method not found in target class: " + method.getName(), e);
                    }
                    return targetMethod.invoke(target, args);
                });
    }

    public static <T> T bindByName(Class<T> iface, String name) {
        try {
            return bind(Class.forName(name).newInstance(), iface);
        } catch (Exception e) {
            throw new RuntimeException("Can't bind class " + name, e);
        }
    }

    public static <T> T bindWithConstructor(Class<T> iface, String implClassName, Class<?>[] ctorTypes, Object[] ctorArgs) {
        try {
            Class<?> impl = Class.forName(implClassName);
            Constructor<?> ctor = impl.getConstructor(ctorTypes);
            Object real = ctor.newInstance(ctorArgs);
            return bind(real, iface);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create proxy for " + implClassName, e);
        }
    }
}