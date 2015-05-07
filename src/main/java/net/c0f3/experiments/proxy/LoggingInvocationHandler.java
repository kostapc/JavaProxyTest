package net.c0f3.experiments.proxy;

import java.lang.reflect.Method;

/**
 * kostapc on 27.03.15.
 */
public class LoggingInvocationHandler implements TestInvocationHandler {

    Object underlying;

    @Override
    public void setObject(Object object) {
        underlying = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        StringBuilder sb = new StringBuilder();
        sb.append(method.getName()).append(" called");

        Object ret = method.invoke(underlying, args);
        if (ret != null) {
            sb.append(" -> ").append(ret);
        }
        System.out.println(sb);
        return ret;
    }


}
