package com.ticketmaster.servos.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

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
        setBackground(ld);
    }

}
