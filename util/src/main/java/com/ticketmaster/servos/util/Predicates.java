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

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public final class Predicates {
    private Predicates() { }

    public interface IPredicate<T> { boolean apply(T type); }

    /**
     * Returns true if all elements in the collection satisfy the predicate.
     * @param target source collection with elements of type T
     * @param predicate answers true/false given a collection element
     * @return true if predicate is true for all collection elements
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
     * @param target source collection with elements of type T
     * @param predicate answers true/false given a collection element
     * @return true if predicate is true for at least one collection element
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
     * @param target source collection with elements of type T
     * @param predicate answers true/false given a collection element
     * @throws java.util.NoSuchElementException if the predicate is not satisfied
     * @return element, if found
     */
    public static <T> T find(Collection<T> target, IPredicate<T> predicate) throws NoSuchElementException {
        for (T element : target) {
            if (predicate.apply(element)) {
                return element;
            }
        }
        throw new NoSuchElementException("Expected predicate to be satisfied");
    }

    /**
     * Return the first element satisfying the predicate, or the defaultValue if none found.
     * @param target source collection with elements of type T
     * @param predicate answers true/false given a collection element
     * @param defaultValue returned if no collection element found
     * @return element if found, otherwise the given defaultValue
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
     * @param target source collection with elements of type T
     * @param predicate answers true/false given a collection element
     * @return new collection with elements of type T
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
