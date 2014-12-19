package com.twotoasters.servos.util;

import java.util.List;

public final class ListUtils {

    private ListUtils() { }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}