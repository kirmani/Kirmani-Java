/*
 * SorterTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
        Integer[] arr = getRandomArr();
        List<Integer> list = Arrays.asList(arr);
        Sorter.bubblesort(arr);
        assertEquals("bubblesort() on array failed.", true, Sorter.isSorted(arr));
        Sorter.bubblesort(list);
        assertEquals("bubblesort() on list failed.", true, Sorter.isSorted(list));
    }

    @Test
    public void testGetBubbleSort() {
        Integer[] arr = getRandomArr();
        boolean initalSortedState = Sorter.isSorted(arr);
        Integer[] sortedArr = Sorter.getBubblesort(arr);
        assertEquals("getBubblesort() didn't return sorted array.", true, Sorter.isSorted(sortedArr));
        assertEquals("getBubblesort() changed original array.", initalSortedState,
                Sorter.isSorted(arr));
    }

    private Integer[] getRandomArr() {
        Random random = new Random();
        Integer[] result = new Integer[SIZE];
        for (int index = 0; index < result.length; index++) {
            result[index] = random.nextInt();
        }
        return result;
    }
}

