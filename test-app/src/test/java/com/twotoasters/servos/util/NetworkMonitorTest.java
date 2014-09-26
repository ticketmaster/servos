package com.twotoasters.servos.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class NetworkMonitorTest {

    @Mock NetworkInfo connected;
    @Mock NetworkInfo disconnected;
    NetworkMonitor network;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(connected.isConnected()).thenReturn(true);
        when(disconnected.isConnected()).thenReturn(false);
        network = new NetworkMonitor(Robolectric.application);
    }

    @Test
    public void itShouldReportOnline() {
        Robolectric.shadowOf(getConnectivityManager()).setActiveNetworkInfo(connected);
        assertTrue(network.isOnline());
    }

    @Test
    public void itShouldReportOffline() {
        Robolectric.shadowOf(getConnectivityManager()).setActiveNetworkInfo(disconnected);
        assertFalse(network.isOnline());
    }

    private ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) Robolectric.application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
