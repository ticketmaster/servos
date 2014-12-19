package com.twotoasters.servos.util.picasso;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;

import com.squareup.picasso.Transformation;

/**
 * This Picasso transform can convert your source bitmap image into an image with no transparent border pixels.
 */
public class CropTransparentBordersTransform implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        if (source == null) return null;

        int w = source.getWidth();
        int h = source.getHeight();

        if (w == 0 || h == 0) return source;

        Rect rect = new Rect(0, 0, w, h);
        boolean foundBound;

        // search for left bound from top to bottom
        foundBound = false;
        for (int c = 0; c < w && !foundBound; c++) {
            for (int r = 0; r < h && !foundBound; r++) {
                if (Color.alpha(source.getPixel(c, r)) > 0) {
                    // found non-transparent pixel
                    rect.left = c;
                    foundBound = true;
                }
            }
        }

        // search for right bound (until hit left bound) from top to bottom
        foundBound = false;
        for (int c = w - 1; c > rect.left && !foundBound; c--) {
            for (int r = 0; r < h && !foundBound; r++) {
                if (Color.alpha(source.getPixel(c, r)) > 0) {
                    // found non-transparent pixel
                    rect.right = Math.min(c + 1, w);
                    foundBound = true;
                }
            }
        }

        // search for top bound from left to right
        foundBound = false;
        for (int r = 0; r < h && !foundBound; r++) {
            for (int c = 0; c < w && !foundBound; c++) {
                if (Color.alpha(source.getPixel(c, r)) > 0) {
                    // found non-transparent pixel
                    rect.top = r;
                    foundBound = true;
                }
            }
        }

        // search for bottom bound (until hit top bound) from left to right
        foundBound = false;
        for (int r = h - 1; r > rect.top && !foundBound; r--) {
            for (int c = 0; c < w && !foundBound; c++) {
                if (Color.alpha(source.getPixel(c, r)) > 0) {
                    // found non-transparent pixel
                    rect.bottom = Math.min(r + 1, h);
                    foundBound = true;
                }
            }
        }

        Bitmap result = Bitmap.createBitmap(source, rect.left, rect.top, rect.width(), rect.height());
        if (source != result) {
            source.recycle();
        }
        return result;
    }

    @Override
    public String key() {
        return "cropTransparentBorders";
    }
}
