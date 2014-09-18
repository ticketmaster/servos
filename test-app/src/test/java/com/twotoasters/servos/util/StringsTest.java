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
}
