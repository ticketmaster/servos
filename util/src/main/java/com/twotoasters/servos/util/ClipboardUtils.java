package com.twotoasters.servos.util;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION_CODES;

import com.twotoasters.servos.Servos;

public final class ClipboardUtils {

    private static final boolean IS_AT_LEAST_HC = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    private ClipboardUtils() { }

    /**
     * This will copy text to the device's clipboard.
     *  @param text the string to be copied to the clipboard
     * @param description a user-visible label for the copied text
     */
    @TargetApi(VERSION_CODES.HONEYCOMB)
    public static void copyText(String text, String description) {
        Application application = Servos.getApplication();
        if (application == null) {
            return;
        }

        if (IS_AT_LEAST_HC) {
            ClipData clip = ClipData.newPlainText(description, text);
            ClipboardManager clipboard = (ClipboardManager) application.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(clip);
        } else {
            android.text.ClipboardManager cm = (android.text.ClipboardManager) application.getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(text);
        }
    }
}
