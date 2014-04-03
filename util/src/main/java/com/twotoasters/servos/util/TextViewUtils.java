package com.twotoasters.servos.util;

import android.widget.TextView;

/**
 * Created by curtismartin on 4/3/14.
 */
public final class TextViewUtils {

    private TextViewUtils() { }

    /**
     * Returns the trimmed contents of a TextView as a String.
     * @param view The TextView
     * @return The trimmed text
     */
    public static String getText(TextView view) {
        if (view != null && view.getText() != null) {
            return view.getText().toString().trim();
        } else {
            return null;
        }
    }

}
