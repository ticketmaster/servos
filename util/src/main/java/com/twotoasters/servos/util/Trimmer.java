package com.twotoasters.servos.util;

import android.widget.TextView;

/**
 * Helper class that returns a trimmed String representation of a TextView's contents.
 * Usage: String trimmed = Trimmer.on(TextView).trim();
 */
public final class Trimmer {

    public static Trimmer on(TextView v) {
        return new Trimmer(v);
    }

    TextView v;

    private Trimmer(TextView v) {
        this.v = v;
    }

    public String trim() {
        CharSequence cs = (v != null) ? v.getText() : null;
        return (cs != null) ? cs.toString().trim() : null;
    }

}
