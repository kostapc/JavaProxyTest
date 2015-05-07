package net.c0f3.experiments.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * kostapc on 27.03.15.
 */
public class GenericProxyFactory {

    public static <T> T getProxy(final T object, Class<? extends TestInvocationHandler> handlerClass) throws TestProxyException {
        TestInvocationHandler handler;
        if(object.getClass().getInterfaces().length==0) {
            throw new TestProxyException();
        }
        try {
            Constructor constructor = handlerClass.getConstructor();
            handler = (TestInvocationHandler) constructor.newInstance();
            handler.setObject(object);
        } catch (
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e
        ) {
            throw new TestProxyException(e);
        }
        return (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                handler
        );
    }
}
