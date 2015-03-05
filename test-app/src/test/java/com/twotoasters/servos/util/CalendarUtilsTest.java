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

import android.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(RobolectricTestRunner.class)
public class CalendarUtilsTest {

    @Test
    public void itShouldReturnOrdinalDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        Pair<Integer, String>[] ordinalTests = new Pair[] {
                Pair.create(1, "1st"),
                Pair.create(2, "2nd"),
                Pair.create(3, "3rd"),
                Pair.create(4, "4th"),
                Pair.create(11, "11th"),
                Pair.create(21, "21st"),
                Pair.create(22, "22nd"),
                Pair.create(23, "23rd"),
                Pair.create(24, "24th")
        };

        for (Pair<Integer, String> ordinalTest : ordinalTests) {
            cal.set(Calendar.DAY_OF_MONTH, ordinalTest.first);
            assertThat(CalendarUtils.getOrdinalDayOfMonth(cal)).isEqualTo(ordinalTest.second);
            assertThat(CalendarUtils.getOrdinalDayOfMonth(cal.getTime())).isEqualTo(ordinalTest.second);
        }
    }

    @Test
    public void itShouldKnowToday() {
        assertThat(CalendarUtils.isToday(new Date())).isTrue();
        Calendar tomorrow = Calendar.getInstance(Locale.US);
        tomorrow.add(Calendar.DAY_OF_YEAR, 1);
        assertThat(CalendarUtils.isToday(tomorrow.getTime())).isFalse();
    }

    @Test
    public void itShouldThrowOnNullArgs() {
        Date date = null;
        Calendar calendar = null;

        try {
            CalendarUtils.isToday(date);
            fail("Failed to throw");
        } catch (RuntimeException e) { }

        try {
            CalendarUtils.isSameDay(date, date);
            fail("Failed to throw");
        } catch (RuntimeException e) { }

        try {
            CalendarUtils.isSameDay(calendar, calendar);
            fail("Failed to throw");
        } catch (RuntimeException e) { }

    }
}
