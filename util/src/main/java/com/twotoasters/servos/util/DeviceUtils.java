package com.twotoasters.servos.util;

import android.os.Build;

public final class DeviceUtils {

    private DeviceUtils() { }

    public static boolean isEmulator() {
        switch (Build.PRODUCT) {
            case "sdk_phone_x86":   // fall through
            case "google_sdk":      // fall through
            case "sdk":             // fall through
            case "sdk_x86":         // fall through
            case "vbox86p":     return true;
            default:            return false;
        }
    }
}
