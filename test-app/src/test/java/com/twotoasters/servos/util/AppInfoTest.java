package com.twotoasters.servos.util;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(ServosRobolectricTestRunner.class)
public class AppInfoTest {

    private Context context;

    @Before
    public void setup() {
        context = Robolectric.application;
    }

    @Test
    public void itShouldGetVersionName() {
        assertThat(AppInfo.getVersionName(context)).isEqualTo("1.0.0");
    }

    @Test
    public void itShouldGetVersionCode() {
        assertThat(AppInfo.getVersionCode(context)).isEqualTo(1);
    }
}
