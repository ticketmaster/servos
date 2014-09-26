package com.twotoasters.servos.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkMonitor {
    ConnectivityManager connectivityManager;

    public NetworkMonitor(Context context) {
        this((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
    }

    public NetworkMonitor(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    public boolean isOnline() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
