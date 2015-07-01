/*
 * SorterTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
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
    public void testBubbleSortOnArray() {
        testSort(new BubbleSort(), true);
    }

    @Test
    public void testBubbleSortOnList() {
        testSort(new BubbleSort(), false);
    }

    @Test
    public void testGetBubbleSortOnArray() {
        testGetSort(new BubbleSort(), true);
    }

    @Test
    public void testGetBubbleSortOnList() {
        testGetSort(new BubbleSort(), false);
    }

    @Test
    public void testSelectionSortOnArray() {
        testSort(new SelectionSort(), true);
    }

    @Test
    public void testSelectionSortOnList() {
        testSort(new SelectionSort(), false);
    }

    @Test
    public void testGetSelectionSortOnArray() {
        testGetSort(new SelectionSort(), true);
    }

    @Test
    public void testGetSelectionSortOnList() {
        testGetSort(new SelectionSort(), false);
    }

    @Test
    public void testInsertionSortOnArray() {
        testSort(new InsertionSort(), true);
    }

    @Test
    public void testInsertionSortOnList() {
        testSort(new InsertionSort(), false);
    }

    @Test
    public void testGetInsertionSortOnArray() {
        testGetSort(new InsertionSort(), true);
    }

    @Test
    public void testGetInsertionSortOnList() {
        testGetSort(new InsertionSort(), false);
    }

    private void testSort(Sortable sorter, boolean isArray) {
        String simpleName = sorter.getClass().getSimpleName();
        Integer[] arr = getRandomUnsortedArr();
        List<Integer> list = Arrays.asList(arr);
        if (isArray) {
            Sorter.sort(sorter, arr);
            assertEquals(String.format("sort() for %s on array failed.", simpleName),
                    true, Sorter.isSorted(arr));
        } else {
            Sorter.sort(sorter, list);
            assertEquals(String.format("sort() for %s on list failed.", simpleName),
                    true, Sorter.isSorted(list));
        }
    }

    private void testGetSort(Sortable sorter, boolean isArray) {
        String simpleName = sorter.getClass().getSimpleName();
        Integer[] arr = getRandomUnsortedArr();
        Integer[] originalArr = new Integer[SIZE];
        System.arraycopy(arr, 0, originalArr, 0, SIZE);
        List<Integer> list = Arrays.asList(arr);
        List<Integer> originalList = new ArrayList<>(list);
        if (isArray) {
            Integer[] sortedArr = Sorter.getSortedArray(sorter, arr);
            assertEquals(String.format("getSort() for %s didn't return sorted array.", simpleName),
                    true, Sorter.isSorted(sortedArr));
            assertNotSame(String.format("getSort() for %s changed original array.", simpleName),
                    originalArr, arr);
        } else {
            List<Integer> sortedList = Sorter.getSortedList(sorter, list);
            assertEquals(String.format("getSort() for %s didn't return the sorted list.", simpleName),
                    true, Sorter.isSorted(sortedList));
            assertNotSame(String.format("getSort() for %s changed the original array.", simpleName),
                    originalList, list);
        }
    }

    private Integer[] getRandomArr() {
        Random random = new Random();
        Integer[] result = new Integer[SIZE];
        for (int index = 0; index < result.length; index++) {
            result[index] = random.nextInt();
        }
        return result;
    }

    private Integer[] getRandomUnsortedArr() {
        Integer[] result = getRandomArr();
        while (Sorter.isSorted(result)) {
            result = getRandomArr();
        }
        return result;
    }
}

