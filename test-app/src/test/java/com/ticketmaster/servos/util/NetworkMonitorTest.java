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
