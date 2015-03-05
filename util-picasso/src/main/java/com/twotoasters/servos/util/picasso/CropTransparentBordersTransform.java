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
