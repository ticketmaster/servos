package com.twotoasters.servos;

import android.app.Application;

public class Servos {

    private static Application application;

    private Servos() { /* no-op */ }

    /**
     * OPTIONAL: Set the reference to your Application object. This is only necessary if you
     * wish to call the no-Context argument convenience overloads in your app.
     *
     * Example:
     * public class MyApplication extends Application {
     *     public void onCreate() {
     *         Servos.setApplication(this);
     *     }
     * }
     * @param application the Application which Servos will use to obtain a reference to an
     *                    Application Context
     */
    public static void setApplication(Application application) {
        Servos.application = application;
    }

    /**
     * Get a reference to the Application
     *
     * Servos helper methods can obtain a reference to the Application instance, which
     * is a Context. It should only be used where it is safe to use an Application instance as a
     * Context, and where no additional flexibility could be gained by allowing the user to pass
     * their own Context.
     *
     * @return Application Context
     */
    public static Application getApplication() {
        if (application == null) {
            throw new IllegalStateException("Programmer error: must first call Servos.setApplication(this) from your Application.onCreate()");
        }
        return application;
    }
}