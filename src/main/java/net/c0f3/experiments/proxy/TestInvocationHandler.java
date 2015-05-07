package net.c0f3.experiments.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * kostapc on 27.03.15.
 */
public interface TestInvocationHandler extends InvocationHandler {
    public void setObject(Object object);
}
