/*
 * SorterTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util.sort;

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
        List<Integer> list = Arrays.asList(arr);
        assertEquals("List should be returned as sorted.", true, BaseSort.isSorted(list));
    }

    @Test
    public void testIsNotSorted() {
        Integer[] arr = {0, -5, -12, 1000, 56, 4, 3, 1};
        List<Integer> list = Arrays.asList(arr);
        assertEquals("List should not be returned as sorted.", false, BaseSort.isSorted(list));
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
        testSort(list, MergeSort.sort(list));
    }

    @Test
    public void testQuickSort() {
        List<Integer> list = getRandomUnsortedList();
        testSort(list, QuickSort.sort(list));
    }

    private void testSort(List<Integer> list, List<Integer> sortedList) {
        assertEquals("sort() returned an array of different length.", list.size(),
                sortedList.size());
        assertEquals("sort() didn't return a permutation of same elements of the original list.",
                true, isPermutation(list, sortedList));
        assertEquals("sort() didn't return the sorted list.", true, BaseSort.isSorted(sortedList));
        assertNotSame("sort() changed the original array.", sortedList, list);
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

    private boolean isPermutation(List<Integer> list1, List<Integer> list2) {
        return list1.containsAll(list2) && list2.containsAll(list1);
    }

    private <E> void printList(List<E> list) {
        for (E item : list) {
            System.out.println(item.toString());
        }
    }
}

