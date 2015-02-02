package com.twotoasters.servos.util;

import com.twotoasters.servos.ServosRobolectricTestRunner;

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
