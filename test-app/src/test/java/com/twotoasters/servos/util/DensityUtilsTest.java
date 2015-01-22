package com.twotoasters.servos.util;

import android.content.res.Resources;

import com.twotoasters.servos.ServosRobolectricTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ServosRobolectricTestRunner.class)
public class DensityUtilsTest {

    private final int DP_CONSTANT = 160; //dp is based on density of a 160 dpi screen

    @Test
    public void itShouldCorrectlyCalculateDpFromPixels() {
        int dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        assertThat(DensityUtils.pxToDp(1)).isEqualTo(1 / (dpi / DP_CONSTANT));
    }

    @Test
    public void itShouldCorrectlyCalculatePixelsFromDp() {
        int dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        assertThat(DensityUtils.dpToPx(1)).isEqualTo(dpi / DP_CONSTANT);
    }

}
