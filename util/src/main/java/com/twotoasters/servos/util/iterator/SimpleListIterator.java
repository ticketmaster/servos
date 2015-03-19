package com.twotoasters.servos.util.iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * Makes a merged copy of your lists and iterates through them.
 */
public class SimpleListIterator<T> implements Iterator<T>, Iterable<T> {

    List<T> list;
    int size;
    int position;

    @SafeVarargs
    public SimpleListIterator(List<T> seedList, List<T>... listArray) {
        if (listArray == null || listArray.length == 0) throw new NullPointerException("You must add at least two list.");

        list = new ArrayList<>(seedList);
        for (List<T> singleList : listArray) {
            if (singleList == null) continue;
            list.addAll(singleList);
        }

        size = list.size();
    }

    @Override
    public Iterator<T> iterator() {
        failFast();

        return this;
    }

    @Override
    public boolean hasNext() {
        failFast();

        return list.size() != position;
    }

    @Override
    public T next() {
        failFast();

        return list.get(position++);
    }

    @Override
    /** Will not remove from your original list only the merged list. **/
    public void remove() {
        failFast();

        list.remove(position);
        --size;
    }

    public List<T> getMergedList() {
        return list;
    }

    private void failFast() {
        if (size != list.size()) throw new ConcurrentModificationException();
    }
}
