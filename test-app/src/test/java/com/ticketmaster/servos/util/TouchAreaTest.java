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
package com.ticketmaster.servos.util;

import android.graphics.Rect;
import android.view.View;

import com.ticketmaster.servos.ServosRobolectricTestRunner;
import com.ticketmaster.servos.tests.MainActivity;
import com.ticketmaster.servos.tests.R;
import com.ticketmaster.servos.util.LayoutUtils.TouchAreaSizer;

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
                // This little sizer demonstrates that you can reduce,
                // as well as expand the touch area of a view.
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
