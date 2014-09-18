package com.twotoasters.servos.util;

import android.content.Context;

import com.twotoasters.servos.ServosRobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ServosRobolectricTestRunner.class)
public class AppInfoTest {

    private Context context;

    @Before
    public void setup() {
        context = Robolectric.application;
    }

    @Test
    public void itShouldGetVersionName() {
        assertThat(AppInfo.getVersionName(context)).isEqualTo("0.0.1");
    }

    @Test
    public void itShouldGetVersionCode() {
        assertThat(AppInfo.getVersionCode(context)).isEqualTo(1);
    }
}
