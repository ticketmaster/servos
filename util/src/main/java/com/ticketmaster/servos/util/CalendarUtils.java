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
package com.ticketmaster.servos.util;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class CalendarUtils {
    private CalendarUtils() { }

    /**
     * Returns ordinal form of the day of month.
     * 1 -> 1st
     * 2 -> 2nd
     *
     * @param date
     * @return ordinal day of month
     */
    public static String getOrdinalDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return getOrdinalDayOfMonth(cal);
    }

    public static String getOrdinalDayOfMonth(Calendar cal) {
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return String.valueOf(dayOfMonth) + getDayOfMonthSuffix(dayOfMonth);
    }

    private static String getDayOfMonthSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    /**
     * Is it today?
     *
     * @param date
     * @throws java.lang.RuntimeException if date is null
     * @return true if given date is today
     */
    public static boolean isToday(@NonNull Date date) {
        return isSameDay(date, new Date());
    }

    /**
     * Are the given dates on the same day?
     *
     * @param date1
     * @param date2
     * @throws java.lang.RuntimeException if either arg is null
     * @return
     */
    @NonNull
    public static boolean isSameDay(@NonNull Date date1, @NonNull Date date2) {
        Preconditions.checkNotNull(date1);
        Preconditions.checkNotNull(date2);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        return isSameDay(calendar1, calendar2);
    }

    /**
     * Are the given calendars on the same day?
     *
     * @param calendar1
     * @param calendar2
     * @throws java.lang.RuntimeException if either arg is null
     * @return
     */
    @NonNull
    public static boolean isSameDay(@NonNull Calendar calendar1, @NonNull Calendar calendar2) {
        Preconditions.checkNotNull(calendar1);
        Preconditions.checkNotNull(calendar2);
        return (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR))
                && (calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR));
    }

}
