package com.twotoasters.servos.util.anim;

import android.animation.IntEvaluator;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/**
 * Allows you to easily create an object animator that will change the height of a view.
 *
 * Example: ObjectAnimator.ofObject(new HeightEvaluator(view), currentHeight, newHeight);
 */
public class HeightEvaluator extends IntEvaluator {

    private View view;

    public HeightEvaluator(@NonNull View view) {
        this.view = view;
    }

    @NonNull
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int val = super.evaluate(fraction, startValue, endValue);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = val;
        view.setLayoutParams(params);
        return val;
    }
}
