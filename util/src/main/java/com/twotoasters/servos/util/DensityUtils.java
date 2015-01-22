package com.twotoasters.servos.util;

import android.content.res.Resources;
import android.util.TypedValue;

public final class DensityUtils {

    private DensityUtils() { }

    /**
     * Converts the given amount of pixels to a dp value.
     * @param pixels The pixel-based measurement
     * @return The measurement's value in dp, based on the device's screen density
     */
    public static float pxToDp(float pixels) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixels, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * Converts the given dp measurement to pixels.
     * @param dp The measurement, in dp
     * @return The corresponding amount of pixels based on the device's screen density
     */
    public static float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
