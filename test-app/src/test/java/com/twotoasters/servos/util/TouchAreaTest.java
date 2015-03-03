package com.twotoasters.servos.util;

import android.graphics.Rect;
import android.view.View;

import com.twotoasters.servos.ServosRobolectricTestRunner;
import com.twotoasters.servos.tests.MainActivity;
import com.twotoasters.servos.tests.R;
import com.twotoasters.servos.util.LayoutUtils.TouchAreaSizer;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

@RunWith(ServosRobolectricTestRunner.class)
public class TouchAreaTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .visible()
                .get();
    }

    @Test
    public void itShouldChangeTouchableArea() {
        View view = activity.findViewById(R.id.main_textview);

        View parent = activity.findViewById(R.id.main_container);
        Assert.assertTrue(parent.getTouchDelegate() == null);

        LayoutUtils.adjustTouchableArea(view, parent, new TouchAreaSizer() {
            @Override
            public Rect adjustTouchableArea(Rect r) {
                Rect adjusted = new Rect();
                adjusted.top += 20;
                adjusted.left += 20;
                adjusted.right -= 20;
                adjusted.bottom -= 20;
                return adjusted;
            }
        });

        Assert.assertFalse(parent.getTouchDelegate() == null);
    }
}
