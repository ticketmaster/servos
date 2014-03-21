package com.twotoasters.servos;

import android.app.Application;

public class Servos {

    private static Application application;

    private Servos() { /* no-op */ }

    /**
     * Call this method to initialize the Servos library
     *
     * Example:
     * public class MyApplication extends Application {
     *     public void onCreate() {
     *         Servos.init(this);
     *     }
     * }
     * @param application the Application which Servos will use to pass a Context
     */
    public static void init(Application application) {
        Servos.application = application;
    }

    public static Application getApplication() {
        if (application == null) {
            throw new IllegalStateException("Programmer error: must first call Servos.init(this) from your Application.onCreate()");
        }
        return application;
    }
}