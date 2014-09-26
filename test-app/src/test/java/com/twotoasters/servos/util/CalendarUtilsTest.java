package com.twotoasters.servos.util;

import android.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

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
}
