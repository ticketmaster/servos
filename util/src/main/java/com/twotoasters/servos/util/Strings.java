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

    /**
     * Return the given string if it is not null, otherwise return an empty string.
     *
     * @param value The string that should be checked
     * @return "" if value is null, else the given string
     */
    public static String valueOrEmpty(String value) {
        return (value == null) ? "" : value;
    }

}
