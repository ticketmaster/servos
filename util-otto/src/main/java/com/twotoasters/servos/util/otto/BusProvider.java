package com.twotoasters.servos.util.otto;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with
 * a more efficient means such as through injection directly into interested classes.
 */
public final class BusProvider {

    private static final MainPostingBus BUS = new MainPostingBus();

    private BusProvider() {
        // no op
    }

    public static MainPostingBus getInstance() {
        return BUS;
    }

    public static void register(Object... objects) {
        for (Object obj : objects) {
            BUS.register(obj);
        }
    }

    public static void unregister(Object... objects) {
        for (Object obj : objects) {
            BUS.unregister(obj);
        }
    }

    public static void post(Object event) {
        BUS.post(event);
    }
}
