package com.twotoasters.servos.util;

import android.support.annotation.NonNull;

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
        return valueOrDefault(value, "");
    }

    /**
     * Return the given string if it is not null, otherwise return the given default.
     *
     * @param value The string that should be checked
     * @param defaultValue The default to use if the value is null
     * @return defaultValue if value is null, else the given string
     */
    public static String valueOrDefault(String value, @NonNull String defaultValue) {
        return (value == null) ? defaultValue : value;
    }

}
