/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class InsertionSort extends BaseSort {
    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        List<E> copy = getCopy(list);
        for (int i = 0; i < copy.size(); i++) {
            int j = i;
            while (j > 0 && copy.get(j - 1).compareTo(copy.get(j)) > 0) {
                swap(copy, j, j - 1);
                j--;
            }
        }
        return copy;
    }

    private static <E extends Comparable<? super E>> void swap(List<E> list, int startIndex, int swapIndex) {
        E temp = list.get(startIndex);
        list.set(startIndex, list.get(swapIndex));
        list.set(swapIndex, temp);
    }
}

