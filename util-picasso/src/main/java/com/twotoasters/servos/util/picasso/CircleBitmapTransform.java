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
package com.twotoasters.servos.util.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.squareup.picasso.Transformation;

/**
 * This Picasso transform can convert your source bitmap image into a circle.
 */
public class CircleBitmapTransform extends RoundedBitmapTransform implements Transformation {

    private Resources res;

    public CircleBitmapTransform(Resources res) {
        super(res);
    }

    @Override
    public String key() {
        return "circleBg";
    }

    @Override
    protected float getCornerRadius(@NonNull Bitmap source) {
        return Math.min(source.getWidth(), source.getHeight()) / 2f;
    }
}
