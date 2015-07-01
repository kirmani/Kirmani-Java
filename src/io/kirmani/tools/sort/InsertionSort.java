/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class InsertionSort implements Sortable {
    public <E extends Comparable<? super E>> void sort(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j - 1).compareTo(list.get(j)) > 0) {
                swap(list, j, j - 1);
                j--;
            }
        }
    }

    private <E> void swap(List<E> list, int startIndex, int swapIndex) {
        E temp = list.get(startIndex);
        list.set(startIndex, list.get(swapIndex));
        list.set(swapIndex, temp);
    }
}

