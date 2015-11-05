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

import java.lang.reflect.Array;
import java.util.List;

public final class ArrayUtils {
    private ArrayUtils() { }

    public static long[] toPrimitives(Long... objects) {
        long[] primitives = new long[objects.length];
        for (int i = 0; i < objects.length; i++)
            primitives[i] = objects[i];
        return primitives;
    }

    public static long[] toPrimitives(List<Long> objects) {
        return toPrimitives(objects.toArray(new Long[objects.size()]));
    }

    public static <T> T[] combineArrays(Class<T> clazz, T[]... arrays) {
        int length = 0;

        for (T[] array : arrays) {
            if (array == null) continue;
            length += array.length;
        }

        T[] finalArray = (T[]) Array.newInstance(clazz, length);

        int i = 0;
        for (T[] array : arrays) {
            if (array == null) continue;
            System.arraycopy(array, 0, finalArray, i, array.length);
            i += array.length;
        }

        return finalArray;
    }
}
