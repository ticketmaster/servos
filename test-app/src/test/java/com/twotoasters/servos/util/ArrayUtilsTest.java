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
