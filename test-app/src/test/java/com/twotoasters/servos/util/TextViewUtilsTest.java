package com.twotoasters.servos.util;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertEquals;

/**
 * Created by curtismartin on 4/3/14.
 */

@RunWith(ServosRobolectricTestRunner.class)
public class TextViewUtilsTest {

    TextView textView;

    @Before
    public void setUp() throws Exception {
        textView = new TextView(Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get());
    }

    @Test
    public void itShouldTrimText() {
        String withSpaces = " test ";
        String trimmed = "test";
        textView.setText(withSpaces);
        assertEquals(TextViewUtils.getText(textView), trimmed);
    }

}
