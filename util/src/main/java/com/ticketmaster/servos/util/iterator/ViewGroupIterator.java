package com.ticketmaster.servos.util.iterator;

import android.view.View;
import android.view.ViewGroup;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ViewGroupIterator implements Iterable<View>, Iterator<View> {

    private ViewGroup viewGroup;
    private int size;
    private int currentIndex;

    @Override
    public Iterator<View> iterator() {
        return this;
    }

    public ViewGroupIterator(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        size = viewGroup.getChildCount();
    }

    @Override
    public boolean hasNext() {
        failFast();

        if (viewGroup != null && currentIndex != viewGroup.getChildCount()) {
            return true;
        }

        viewGroup = null;
        return false;
    }

    @Override
    public View next() {
        failFast();
        if (viewGroup == null)
            throw new IllegalStateException("This iterator has already been used.");

        return viewGroup.getChildAt(currentIndex++);
    }

    @Override
    public void remove() {
        failFast();
        viewGroup.removeViewAt(currentIndex);
        --size;
    }

    private void failFast() {
        if (viewGroup != null && viewGroup.getChildCount() != size)
            throw new ConcurrentModificationException("Your viewGroup size has change while iterating.");
    }
}
