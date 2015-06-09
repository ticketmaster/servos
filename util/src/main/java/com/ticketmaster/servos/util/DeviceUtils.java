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

import android.os.Build;

public final class DeviceUtils {

    private DeviceUtils() { }

    public static boolean isEmulator() {
        switch (Build.PRODUCT) {
            case "google_sdk":              // fall through
            case "sdk":                     // fall through
            case "sdk_google_phone_x86":    // fall through
            case "sdk_phone_x86":           // fall through
            case "sdk_x86":                 // fall through
            case "vbox86p":     return true;
            default:            return false;
        }
    }
}
