/*
 * Copyright (C) 2015 Ticketmaster
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
     * @return the version name for the application or null
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
     * Retrieves the app version info or null if the package was not found.
     *
     * @param context an activity or application context
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
