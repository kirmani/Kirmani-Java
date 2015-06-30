/*
 * SorterTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

public class SorterTest {
    private static final int SIZE = 10000;

    @Test
    public void testIsSorted() {
        Integer[] arr = {-12, -5, 0, 1, 3, 4, 56, 1000};
        assertEquals("arr should be sorted.", true, Sorter.isSorted(arr));
    }

    @Test
    public void testIsNotSorted() {
        Integer[] arr = {0, -5, -12, 1000, 56, 4, 3, 1};
        assertEquals("arr should not be sorted.", false, Sorter.isSorted(arr));
    }

    @Test
    public void testBubblesort() {
        Random random = new Random();
        Integer[] arr = new Integer[SIZE];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = random.nextInt();
        }
        Sorter.bubblesort(arr);
        assertEquals("bubblesort() failed.", true, Sorter.isSorted(arr));
    }
}

