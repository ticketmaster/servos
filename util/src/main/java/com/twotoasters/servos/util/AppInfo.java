package com.twotoasters.servos.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.twotoasters.servos.Servos;

public final class AppInfo {

    public static final int VERSION_CODE_NOT_FOUND = -1;

    private AppInfo() { }

    /**
     * @see com.twotoasters.servos.util.AppInfo#getVersionName(android.content.Context)
     */
    public static String getVersionName() {
        return getVersionName(Servos.getApplication());
    }

    /**
     * Retrieves the app version name or null if the package was not found.
     *
     * @param context the Context reference to use. Safe to pass Application Context
     * @return the version name for the application or null
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo();
        return packageInfo != null ? packageInfo.versionName : null;
    }

    /**
     * @see com.twotoasters.servos.util.AppInfo#getVersionCode(android.content.Context)
     */
    public static int getVersionCode() {
        return getVersionCode(Servos.getApplication());
    }

    /**
     * Retrieves the app version code or VERSION_CODE_NOT_FOUND if the package was not found.
     *
     * @param context the Context reference to use. Safe to pass Application Context
     * @return the version code for the application or VERSION_CODE_NOT_FOUND
     */
    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.versionCode : VERSION_CODE_NOT_FOUND;
    }

    /**
     * @see com.twotoasters.servos.util.AppInfo#getPackageInfo(android.content.Context)
     */
    public static PackageInfo getPackageInfo() {
        return getPackageInfo(Servos.getApplication());
    }

    /**
     * Retrieves the app version info or null if the package was not found.
     *
     * @param context the Context reference to use. Safe to pass Application Context
     * @return an object containing package version info or null
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
