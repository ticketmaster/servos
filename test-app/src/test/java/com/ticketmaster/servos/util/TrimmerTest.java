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

import android.widget.TextView;

import com.ticketmaster.servos.ServosRobolectricTestRunner;
import com.ticketmaster.servos.tests.MainActivity;

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
