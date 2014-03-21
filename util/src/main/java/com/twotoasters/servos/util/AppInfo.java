package com.twotoasters.servos.util;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.twotoasters.servos.Servos;

public final class AppInfo {

    public static final int VERSION_CODE_NOT_FOUND = -1;

    private AppInfo() { }

    /**
     * Retrieves the app version name or null if the package was not found.
     *
     * @return the version name for the application or null
     */
    public static String getVersionName() {
        PackageInfo packageInfo = getPackageInfo();
        return packageInfo != null ? packageInfo.versionName : null;
    }

    /**
     * Retrieves the app version code or VERSION_CODE_NOT_FOUND if the package was not found.
     *
     * @return the version code for the application or VERSION_CODE_NOT_FOUND
     */
    public static int getVersionCode() {
        PackageInfo packageInfo = getPackageInfo();
        return packageInfo != null ? packageInfo.versionCode : VERSION_CODE_NOT_FOUND;
    }

    /**
     * Retrieves the app version info or null if the package was not found.
     *
     * @return an object containing package version info or null
     */
    public static PackageInfo getPackageInfo() {
        Application application = Servos.getApplication();
        if (application != null) {
            PackageManager pm = application.getPackageManager();
            if (pm != null) {
                String packageName = application.getPackageName();
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
