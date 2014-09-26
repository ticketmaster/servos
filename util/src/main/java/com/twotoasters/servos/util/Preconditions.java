package com.twotoasters.servos.util;

public final class Preconditions {
    private Preconditions() { }

    public static void check(boolean assertion) {
        check(assertion, "Assertion failed");
    }

    public static void check(boolean assertion, String message) {
        if (!assertion) {
            throw new RuntimeException(message);
        }
    }

    public static void checkNotNull(Object o) {
        checkNotNull(o, "Precondition checkNotNull() failed");
    }

    public static void checkNotNull(Object o, String message) {
        if (o == null) {
            throw new RuntimeException(message);
        }
    }
}
