/*
 * Copyright (C) 2015 Two Toasters
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ticketmaster.servos.util;

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
