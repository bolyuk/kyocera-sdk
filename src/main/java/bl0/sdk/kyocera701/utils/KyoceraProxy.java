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
                        targetMethod = target.getClass().getDeclaredMethod(method.getName(), convertArgTypes(method.getParameterTypes()));
                        targetMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException("Method not found in target class: " + method.getName(), e);
                    }
                    return targetMethod.invoke(target, convertArgs(method.getParameterTypes(), args));
                });
    }

    private static Object[] convertArgs(Class<?>[] rawTypes, Object[] args) {
        if (args == null) return null;

        Object[] newArgs = new Object[args.length];

        for (int i = 0; i < args.length; i++) {
            Object original = args[i];
            if (original == null) {
                newArgs[i] = null;
                continue;
            }

            String name = rawTypes[i].getCanonicalName();
            if (name != null && name.startsWith("bl0.")) {
                try {
                    Class<?> targetInterface = resolveClassName(name.substring(4));
                    newArgs[i] = bind(original, targetInterface);
                } catch (Exception e) {
                    throw new RuntimeException("Argument cannot be converted from class: " + name, e);
                }
            } else {
                newArgs[i] = original;
            }
        }

        return newArgs;
    }

    private static Class<?>[] convertArgTypes(Class<?>[] args) {
        if (args == null) return null;

        Class<?>[] newArgTypes = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            String name = args[i].getCanonicalName();
            if (name != null && name.startsWith("bl0.")) {
                try {
                    newArgTypes[i] = resolveClassName(name.substring(4));
                } catch (Exception e) {
                    throw new RuntimeException("ArgType cannot be converted from class: " + name, e);
                }
            } else {
                newArgTypes[i] = args[i];
            }
        }

        return newArgTypes;
    }

    private static Class<?> resolveClassName(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            int lastDot = name.lastIndexOf('.');
            if (lastDot != -1) {
                String modified = name.substring(0, lastDot) + "$" + name.substring(lastDot + 1);
                try {
                    return Class.forName(modified);
                } catch (ClassNotFoundException ignored) {
                }
            }
            throw new RuntimeException("Can't resolve class: " + name, e);
        }
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