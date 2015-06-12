package com.ticketmaster.servos.util.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.annotation.Nullable;

import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

/**
 * This drawable can be used as a Picasso Target and will do a fade transition when image is loaded.
 * You can also load stuff yourself with the startTransitionToBitmap or startTransitionToDrawable.
 * Remember you must set a target, get it to pass verifyDrawable and call draw on it.
 */
public class FadeInTarget extends TransitionDrawable implements Target {

    private static final int ALPHA_INDEX_0 = 0;
    private static final int ALPHA_INDEX_1 = 0xFF;

    private boolean fade;

    private final int transitionDuration;
    int currentIndex = 0;

    public FadeInTarget() {
        // There are null checks on the drawables.
        super(new Drawable[]{createDrawableFromBitmap(null), createDrawableFromBitmap(null)});
        transitionDuration = Resources.getSystem()
                .getInteger(android.R.integer.config_mediumAnimTime);
        // Id's are View.NO_ID by default.
        setId(0, 0);
        setId(1, 1);
        setCrossFadeEnabled(true);
    }

    public boolean hasValidDrawable() {
        return !(getDrawable(currentIndex) instanceof EmptyDrawable);
    }

    // Drawing methods.

    public void setBounds(RectF bounds) {
        Rect rect = new Rect(
                Math.round(bounds.left),
                Math.round(bounds.top),
                Math.round(bounds.right),
                Math.round(bounds.bottom));
        setBounds(rect);
    }

    @Override
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        getDrawable(0).setBounds(getBounds());
        getDrawable(1).setBounds(getBounds());
    }

    // Transition methods

    public void startTransitionToBitmap(@Nullable Bitmap bitmap) {
        startTransitionToDrawable(createDrawableFromBitmap(bitmap));
    }

    public void startTransitionToDrawable(@Nullable Drawable drawable) {
        if (drawable == null) drawable = new EmptyDrawable();

        if (fade) {
            setDrawableAndStartTransition(drawable);
        } else {
            setDrawableAtCurrentIndex(drawable);
        }
    }

    private void setDrawableAtCurrentIndex(Drawable drawable) {
        setDrawableByLayerId(currentIndex, drawable);
        invalidateSelf();
    }

    private void setDrawableAndStartTransition(Drawable drawable) {
        setDrawableByLayerId(getIndexOfNextBitmap(), drawable);

        if (currentIndex == 0) {
            super.startTransition(transitionDuration);
        } else {
            super.reverseTransition(transitionDuration);
        }
        currentIndex = getIndexOfNextBitmap();
    }

    @Override
    @Deprecated
    /** This class uses different transition methods,
     *  see startTransitionToBitmap or startTransitionToDrawable **/
    public void startTransition(int durationMillis) {
        throw new RuntimeException("Use startTransitionToBitmap or startTransitionToDrawable instead");
    }

    @Override
    @Deprecated
    /** This class uses different transition methods,
     *  see startTransitionToBitmap or startTransitionToDrawable **/
    public void reverseTransition(int duration) {
        throw new RuntimeException("Use startTransitionToBitmap or startTransitionToDrawable instead");
    }

    @Override
    public void resetTransition() {
        // This will be a cut, nothing we can do without rewriting TransitionDrawable.
        if (currentIndex == 1) {
            // Put current drawable into zero position so super.resetTransition can do its thing.
            Drawable currentDrawable = getDrawable(1);

            setDrawableByLayerId(1, new EmptyDrawable());
            setDrawableByLayerId(0, currentDrawable);

            currentIndex = 0;
        }
        // Must call for internal state tracking.
        super.resetTransition();
    }

    private int getIndexOfNextBitmap() {
        return currentIndex == 0 ? 1 : 0;
    }

    // Util methods

    /**
     * @return a Drawable, this may not be a BitmapDrawable if the Bitmap is null.
     */
    private static Drawable createDrawableFromBitmap(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return new EmptyDrawable();
        } else {
            Drawable drawable = new BitmapDrawable(Resources.getSystem(), bitmap);
            drawable.setBounds(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            return drawable;
        }
    }

    private static class EmptyDrawable extends ColorDrawable {
        public EmptyDrawable() {
            super(Color.TRANSPARENT);
        }
    }

    // Picasso Stuff.

    @Override
    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from) {
        fade = from != LoadedFrom.MEMORY;
        startTransitionToBitmap(bitmap);
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        fade = true;
        startTransitionToDrawable(errorDrawable);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        fade = false;
        startTransitionToDrawable(placeHolderDrawable);
    }
}
