package com.twotoasters.servos.util.butterknife;

import android.view.View;

import butterknife.ButterKnife.Setter;

public class EnabledSetter implements Setter<View, Boolean> {
    @Override
    public void set(View view, Boolean value, int index) {
        view.setEnabled(value);
    }
}
