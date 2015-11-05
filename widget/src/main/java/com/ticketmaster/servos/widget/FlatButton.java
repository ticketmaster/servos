package com.ticketmaster.servos.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

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

/**
 * FlatButton mimics the behavior of a standard Button with the borderless style applied to it, but with a key difference. Rather
 * than forcing a transparent background, it uses colorButtonNormal from your theme to color its background, just like any other
 * Button. Ripple is included for Lollipop and above, and anything below gets the normal selection highlight. This can be overridden
 * by specifying selectableItemBackground in your theme.
 */
public class FlatButton extends AppCompatButton {

    public FlatButton(Context context) {
        super(context);
        init(context);
    }

    public FlatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FlatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        int[] attrs = new int[] { R.attr.colorButtonNormal, R.attr.selectableItemBackground };
        TypedArray a = context.obtainStyledAttributes(attrs);
        Drawable background = a.getDrawable(0);
        Drawable highlight = a.getDrawable(1);
        a.recycle();

        LayerDrawable ld = new LayerDrawable(new Drawable[] { background, highlight });
        setBackgroundDrawable(ld);
    }

}
