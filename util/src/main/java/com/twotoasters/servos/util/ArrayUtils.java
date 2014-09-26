package com.twotoasters.servos.util;

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
}
