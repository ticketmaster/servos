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
package com.ticketmaster.servos.util.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import com.squareup.picasso.Transformation;

/**
 * This Picasso transform can convert your source bitmap image into a rounded rect.
 */
public class RoundedBitmapTransform implements Transformation {

    private Resources res;
    private float cornerRadius;

    protected RoundedBitmapTransform(Resources res) {
        this.res = res;
    }

    public RoundedBitmapTransform(Resources res, @DimenRes int cornerRadiusResId) {
        this(res, res.getDimension(cornerRadiusResId));
    }

    public RoundedBitmapTransform(Resources res, float cornerRadius) {
        this.res = res;
        this.cornerRadius = cornerRadius;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(res, source);
        drawable.setCornerRadius(getCornerRadius(source));
        Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), source.getConfig());
        Canvas canvas = new Canvas(output);
        drawable.setAntiAlias(true);
        drawable.setBounds(0, 0, source.getWidth(), source.getHeight());
        drawable.draw(canvas);
        if (source != output) {
            source.recycle();
        }
        return output;
    }

    @Override
    public String key() {
        return String.format("roundedRectBg[cornerRadius=%.1f]", cornerRadius);
    }

    protected float getCornerRadius(@NonNull Bitmap source) {
        return cornerRadius;
    }
}
