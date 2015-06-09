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

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION_CODES;

public final class ClipboardUtils {

    private static final boolean IS_AT_LEAST_HC = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    private ClipboardUtils() { }

    /**
     * This will copy text to the device's clipboard.
     *
     * @param context an application or activity context
     * @param text the string to be copied to the clipboard
     * @param description a user-visible label for the copied text
     */
    @TargetApi(VERSION_CODES.HONEYCOMB)
    public static void copyText(Context context, String text, String description) {
        if (IS_AT_LEAST_HC) {
            ClipData clip = ClipData.newPlainText(description, text);
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(clip);
        } else {
            android.text.ClipboardManager cm = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(text);
        }
    }
}
