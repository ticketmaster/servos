package com.twotoasters.servos.util;

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
     * @return true if given date is today
     */
    public static boolean isToday(Date date) {
        return isSameDay(date, new Date());
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Preconditions.checkNotNull(date1);
        Preconditions.checkNotNull(date2);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        return isSameDay(calendar1, calendar2);
    }

    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        Preconditions.checkNotNull(calendar1);
        Preconditions.checkNotNull(calendar2);
        return (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR))
                && (calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR));
    }

}
