/*
 * Copyright (C) 2015 Two Toasters
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(RobolectricTestRunner.class)
public class PredicatesTest {

    ArrayList<Integer> numbers = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
    }};

    @Test
    public void all() {
        assertThat(Predicates.all(numbers, isZero)).isFalse();
        assertThat(Predicates.all(numbers, isEven)).isFalse();
        assertThat(Predicates.all(numbers, isOdd)).isFalse();
        assertThat(Predicates.all(numbers, isPositive)).isTrue();
        assertThat(Predicates.all(numbers, isNegative)).isFalse();
        assertThat(Predicates.all(numbers, lessThanFive)).isFalse();
    }

    @Test
    public void any() {
        assertThat(Predicates.any(numbers, isZero)).isFalse();
        assertThat(Predicates.any(numbers, isEven)).isTrue();
        assertThat(Predicates.any(numbers, isOdd)).isTrue();
        assertThat(Predicates.any(numbers, isPositive)).isTrue();
        assertThat(Predicates.any(numbers, isNegative)).isFalse();
        assertThat(Predicates.any(numbers, lessThanFive)).isTrue();
    }

    @Test public void filter() {
        assertThat(Predicates.filter(numbers, isZero)).isEmpty();
        assertThat(Predicates.filter(numbers, isEven)).contains(2, 4, 6, 8);
        assertThat(Predicates.filter(numbers, isEven)).doesNotContain(1, 3, 5, 7, 9);
        assertThat(Predicates.filter(numbers, isOdd)).contains(1, 3, 5, 7, 9);
        assertThat(Predicates.filter(numbers, isOdd)).doesNotContain(2, 4, 6, 8);
        assertThat(Predicates.filter(numbers, isPositive)).contains(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(Predicates.filter(numbers, isNegative)).isEmpty();
        assertThat(Predicates.filter(numbers, lessThanFive)).contains(1, 2, 3, 4);
        assertThat(Predicates.filter(numbers, greaterThanFive)).doesNotContain(1, 2, 3, 4, 5);
    }

    @Test
    public void defaultValueFind() {
        assertThat(Predicates.find(numbers, isZero, -1)).isEqualTo(-1);
        assertThat(Predicates.find(numbers, nothing, 100)).isEqualTo(100);
    }

    @Test
    public void expectedFind() {
        assertThat(Predicates.find(numbers, isEven)).isEqualTo(2);
        assertThat(Predicates.find(numbers, isOdd)).isEqualTo(1);
        assertThat(Predicates.find(numbers, isPositive)).isEqualTo(1);
        assertThat(Predicates.find(numbers, greaterThanFive)).isEqualTo(6);
    }

    @Test
    public void throwsWhenExpectedFindFails() {
        try {
            Predicates.find(numbers, nothing);
            fail("Expected find to throw");
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                fail("Didn't expect find  to throw " + e.toString());
            }
        }
    }

    Predicates.IPredicate<Integer> isEven = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i % 2 == 0;
        }
    };

    Predicates.IPredicate<Integer> isOdd = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i % 2 != 0;
        }
    };

    Predicates.IPredicate<Integer> isPositive = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i > 0;
        }
    };

    Predicates.IPredicate<Integer> isNegative = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i < 0;
        }
    };

    Predicates.IPredicate<Integer> isZero = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i == 0;
        }
    };

    Predicates.IPredicate<Integer> lessThanFive = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i < 5;
        }
    };

    Predicates.IPredicate<Integer> greaterThanFive = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return i > 5;
        }
    };

    Predicates.IPredicate<Integer> nothing = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return false;
        }
    };

    Predicates.IPredicate<Integer> everything = new Predicates.IPredicate<Integer>() {
        @Override
        public boolean apply(Integer i) {
            return true;
        }
    };

}
