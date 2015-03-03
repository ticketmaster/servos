package com.twotoasters.servos.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

public class LayoutUtils {
    private LayoutUtils() { }

    /**
     * Given a view's hit rect, return a new touchable area.
     */
    public interface TouchAreaSizer {
        Rect adjustTouchableArea(Rect r);
    }

    /**
     * Adjust the touchable area of the delegate view.
     * This is typically done for tiny views in order to make them
     * tappable without making the user crazy. But, it can be used
     * the other way too; to reduce the tappable area of a large view.
     *
     * @param view delegate view
     * @param sizer how to size the new touchable area
     *
     * @throws java.lang.ClassCastException if the view's parent cannot be cast to View
     */
    public static void adjustTouchableArea(final View view, final TouchAreaSizer sizer) {
        adjustTouchableArea(view, (View) view.getParent(), sizer);
    }

    /**
     * Adjust the touchable area of the delegate view.
     * This is typically done for tiny views in order to make them
     * tappable without making the user crazy. But, it can be used
     * the other way too; to reduce the tappable area of a large view.
     *
     * @param view delegate view
     * @param container the delegate's parent container
     * @param sizer how to size the new touchable area
     */
    public static void adjustTouchableArea(final View view, final View container, final TouchAreaSizer sizer) {
        container.post(new Runnable() {
            @Override
            public void run() {
                Rect r = new Rect();
                view.getHitRect(r);
                container.setTouchDelegate(new TouchDelegate(sizer.adjustTouchableArea(r), view));
            }
        });
    }

    /**
     * Simplest sizer ever; makes no change to the view's touchable area.
     */
    public static class IdentitySizer implements TouchAreaSizer {
        @Override
        public Rect adjustTouchableArea(Rect r) {
            return r;
        }
    }

    /**
     * This sizer adds additional padding to the original view bounds.
     */
    public static class ExtraPadding implements TouchAreaSizer {
        int padding;

        public ExtraPadding(int padding) {
            this.padding = padding;
        }

        @Override
        public Rect adjustTouchableArea(Rect r) {
            Rect adjusted = new Rect(r);
            adjusted.top -= padding;
            adjusted.left -= padding;
            adjusted.right += padding;
            adjusted.bottom += padding;
            return adjusted;
        }
    }
}
