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
        assertEquals("arr should be sorted.", true, BaseSort.isSorted(arr));
    }

    @Test
    public void testIsNotSorted() {
        Integer[] arr = {0, -5, -12, 1000, 56, 4, 3, 1};
        assertEquals("arr should not be sorted.", false, BaseSort.isSorted(arr));
    }

    @Test
    public void testBubbleSort() {
        List<Integer> list = getRandomUnsortedList();
        testSort(list, BubbleSort.sort(list));
    }

    @Test
    public void testSelectionSort() {
        List<Integer> list = getRandomUnsortedList();
        testSort(list, SelectionSort.sort(list));
    }

    @Test
    public void testInsertionSort() {
        List<Integer> list = getRandomUnsortedList();
        testSort(list, InsertionSort.sort(list));
    }

    @Test
    public void testMergeSort() {
        List<Integer> list = getRandomUnsortedList();
        testSort(list, InsertionSort.sort(list));
    }

    private void testSort(List<Integer> list, List<Integer> sortedList) {
        assertEquals("sort() didn't return the sorted list.",
            true, BaseSort.isSorted(sortedList));
        assertNotSame("sort() changed the original array.",
            sortedList, list);
    }

    private List<Integer> getRandomList() {
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(random.nextInt());
        }
        return list;
    }

    private List<Integer> getRandomUnsortedList() {
        List<Integer> list = getRandomList();
        while (BaseSort.isSorted(list)) {
            list = getRandomList();
        }
        return list;
    }

    private <E> void printList(List<E> list) {
        for (E item : list) {
            System.out.println(item.toString());
        }
    }
}

