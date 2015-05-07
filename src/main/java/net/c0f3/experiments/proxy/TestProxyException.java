package net.c0f3.experiments.proxy;

/**
 * kostapc on 27.03.15.
 */
public class TestProxyException extends Exception {

    public TestProxyException(Exception e) {
        super(e.getMessage());
        this.setStackTrace(e.getStackTrace());
    }

    public TestProxyException() {

    }
}
