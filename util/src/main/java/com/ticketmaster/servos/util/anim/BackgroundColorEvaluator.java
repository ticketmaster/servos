/*
 * Copyright (C) 2015 Ticketmaster
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
package com.ticketmaster.servos.util.anim;

import android.animation.ArgbEvaluator;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Allows you to easily create an object animator that will change the background color of a view.
 *
 * Example: ValueAnimator.ofObject(new BackgroundColorEvaluator(view), currentColor, newColor);
 */
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
