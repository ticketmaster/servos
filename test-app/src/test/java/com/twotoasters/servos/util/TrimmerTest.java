package com.twotoasters.servos.util;

import android.widget.TextView;

import com.twotoasters.servos.ServosRobolectricTestRunner;
import com.twotoasters.servos.tests.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertEquals;

@RunWith(ServosRobolectricTestRunner.class)
public class TrimmerTest {

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
        assertEquals(Trimmer.on(textView).trim(), trimmed);
    }
}
