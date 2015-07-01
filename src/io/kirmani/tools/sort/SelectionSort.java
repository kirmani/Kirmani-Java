/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class SelectionSort extends BaseSort {
    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        List<E> sortedList = getCopy(list);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).compareTo(sortedList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(sortedList, i, minIndex);
            }
        }
        return sortedList;
    }

    private static <E extends Comparable<? super E>> void swap(List<E> list, int startIndex, int swapIndex) {
        E temp = list.get(startIndex);
        list.set(startIndex, list.get(swapIndex));
        list.set(swapIndex, temp);
    }
}

