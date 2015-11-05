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
package com.ticketmaster.servos.util;

import com.ticketmaster.servos.ServosRobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ServosRobolectricTestRunner.class)
public class DensityUtilsTest {

    private static final float TEST_DENSITY_MULTIPLIER = 1.5f; // HDPI

    @Before
    public void setup() {
        Robolectric.setDisplayMetricsDensity(TEST_DENSITY_MULTIPLIER);
    }

    @Test
    public void itShouldCorrectlyConvertPxToDp() {
        assertThat(DensityUtils.pxToDp(12)).isEqualTo(8);
    }

    @Test
    public void itShouldCorrectlyConvertDpToPx() {
        assertThat(DensityUtils.dpToPx(8)).isEqualTo(12);
    }
}
