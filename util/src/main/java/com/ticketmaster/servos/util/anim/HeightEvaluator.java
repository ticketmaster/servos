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
package com.ticketmaster.servos.util.anim;

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
