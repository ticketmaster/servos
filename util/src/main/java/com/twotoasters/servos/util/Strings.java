package com.twotoasters.servos.util;

public final class Strings {

    private Strings() { }

    /**
     * Checks if a string is null or empty.
     *
     * @param text The string that should be checked
     * @return true if the string is null or empty
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

}
