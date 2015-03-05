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

import com.twotoasters.servos.ServosRobolectricTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ServosRobolectricTestRunner.class)
public class StringsTest {

    public static final String[] EMPTY_STRINGS = new String[] {null, ""};
    public static final String[] NON_EMPTY_STRINGS = new String[] {"a", "an", "the"};

    @Test
    public void testEmptyStrings() {
        for (String string : EMPTY_STRINGS) {
            assertThat(Strings.isEmpty(string)).isTrue();
        }
    }

    @Test
    public void testNonEmptyStrings() {
        for (String string : NON_EMPTY_STRINGS) {
            assertThat(Strings.isEmpty(string)).isFalse();
        }
    }

    @Test
    public void testValueStrings() {
        for (String string : NON_EMPTY_STRINGS) {
            assertThat(Strings.valueOrEmpty(string)).isEqualTo(string);
        }

        assertThat(Strings.valueOrEmpty(null)).isEqualTo("");
    }

    @Test
    public void testDefaultStrings() {
        assertThat(Strings.valueOrDefault("anything", "something else")).isEqualTo("anything");
        assertThat(Strings.valueOrDefault(null, "something")).isEqualTo("something");
    }
}
