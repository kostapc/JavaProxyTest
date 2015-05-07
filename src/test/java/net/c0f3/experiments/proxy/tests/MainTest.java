package net.c0f3.experiments.proxy.tests;

import net.c0f3.experiments.proxy.*;
import org.junit.Test;

/**
 * kostapc on 26.03.15.
 */
public class MainTest {
    @Test
    public void mainTest() throws TestProxyException {
        System.out.println("test started...");
        AnObject anObject = new AnObject();
        AnObjectInterface s = GenericProxyFactory.getProxy(anObject, LoggingInvocationHandler.class);
        System.out.println("run source object");
        s.someMethod();
        System.out.println("DONE");
    }
}
