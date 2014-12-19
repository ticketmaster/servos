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
