/*
 * Copyright (C) 2015 Ticketmaster
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
