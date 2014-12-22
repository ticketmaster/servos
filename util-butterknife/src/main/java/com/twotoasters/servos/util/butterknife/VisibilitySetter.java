package com.twotoasters.servos.util.butterknife;

import android.view.View;

import butterknife.ButterKnife.Setter;

public class VisibilitySetter implements Setter<View, Integer> {
    @Override
    public void set(View view, Integer value, int index) {
        view.setVisibility(value);
    }
}
