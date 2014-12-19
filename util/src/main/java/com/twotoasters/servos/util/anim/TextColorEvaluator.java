package com.twotoasters.servos.util.anim;

import android.animation.ArgbEvaluator;
import android.support.annotation.NonNull;
import android.widget.TextView;

public class TextColorEvaluator extends ArgbEvaluator {

    private TextView textView;

    public TextColorEvaluator(@NonNull TextView textView) {
        this.textView = textView;
    }

    @NonNull
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Integer color = (Integer) super.evaluate(fraction, startValue, endValue);
        textView.setTextColor(color);
        return color;
    }
}
