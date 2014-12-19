package com.twotoasters.servos.util.anim;

import android.animation.ArgbEvaluator;
import android.support.annotation.NonNull;
import android.view.View;

public class BackgroundColorEvaluator extends ArgbEvaluator {

    private View view;

    public BackgroundColorEvaluator(@NonNull View view) {
        this.view = view;
    }

    @NonNull
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Integer color = (Integer) super.evaluate(fraction, startValue, endValue);
        view.setBackgroundColor(color);
        return color;
    }
}
