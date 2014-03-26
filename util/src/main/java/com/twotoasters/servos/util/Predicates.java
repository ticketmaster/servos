package com.twotoasters.servos.util;

import java.util.ArrayList;
import java.util.Collection;

public final class Predicates {
    private Predicates() { }

    public interface IPredicate<T> { boolean apply(T type); }

    /**
     * Returns true if all elements in the collection satisfy the predicate.
     * @param target
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> boolean all(Collection<T> target, IPredicate<T> predicate) {
        for (T element : target) {
            if (!predicate.apply(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if any element in the collection satisfies the predicate.
     * @param target
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> boolean any(Collection<T> target, IPredicate<T> predicate) {
        for (T element : target) {
            if (predicate.apply(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the first element satisfying the predicate when it is known to exist.
     * @param target
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> target, IPredicate<T> predicate) {
        for (T element : target) {
            if (predicate.apply(element)) {
                return element;
            }
        }
        throw new RuntimeException("Expected element to exist");
    }

    /**
     * Return the fist element satisfying the predicate, or the defaultValue if none found.
     * @param target
     * @param predicate
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> target, IPredicate<T> predicate, T defaultValue) {
        for (T element : target) {
            if (predicate.apply(element)) {
                return element;
            }
        }
        return defaultValue;
    }

    /**
     * Returns a new collection with all elements for which the given predicate returns true.
     * @param target
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> Collection<T> filter(Collection<T> target, IPredicate<T> predicate) {
        Collection<T> result = new ArrayList<T>();
        for (T element : target) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

}
