package com.twotoasters.servos;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;

public class ServosRobolectricTestRunner extends RobolectricTestRunner {

    public ServosRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
        System.setProperty("robolectric.logging", "stdout");
    }
}
