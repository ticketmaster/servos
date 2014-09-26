package com.twotoasters.servos.util;

import org.junit.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTest {

    @Test
    public void itShouldConvertLongsToPrimitives() {
        long[] pi = ArrayUtils.toPrimitives(3L, 1L, 4L, 1L, 5L, 9L, 2L);
        assertThat(pi).containsExactly(3, 1, 4, 1, 5, 9, 2);

        long[] e = ArrayUtils.toPrimitives(Arrays.asList(2L, 7L, 1L, 8L, 2L, 8L, 1L, 8L, 2L, 8L));
        assertThat(e).containsExactly(2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
    }
}
