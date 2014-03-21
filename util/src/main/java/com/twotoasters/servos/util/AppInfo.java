package com.twotoasters.servos.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class AppInfo {

    public static final int VERSION_CODE_NOT_FOUND = -1;

    private AppInfo() { }

    /**
     * Retrieves the app version name or null if the package was not found.
     *
     * @param context an activity or application context
     * @return the version code for the application or VERSION_CODE_NOT_FOUND
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.versionName : null;
    }

    /**
     * Retrieves the app version code or VERSION_CODE_NOT_FOUND if the package was not found.
     *
     * @param context an activity or application context
     * @return the version code for the application or VERSION_CODE_NOT_FOUND
     */
    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.versionCode : VERSION_CODE_NOT_FOUND;
    }

    /**
     * Retrieves the app version info.
     *
     * @param context an activity or application context
     * @return an object containing package version info
     */
    public static PackageInfo getPackageInfo(Context context) {
        if (context != null) {
            PackageManager pm = context.getPackageManager();
            if (pm != null) {
                String packageName = context.getPackageName();
                if (packageName != null) {
                    try {
                        return pm.getPackageInfo(packageName, 0);
                    } catch (NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
