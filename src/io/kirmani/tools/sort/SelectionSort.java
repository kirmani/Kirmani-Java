/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class SelectionSort implements Sortable {
    public <E extends Comparable<? super E>> void sort(List<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(list, i, minIndex);
            }
        }
    }

    private <E> void swap(List<E> list, int startIndex, int swapIndex) {
        E temp = list.get(startIndex);
        list.set(startIndex, list.get(swapIndex));
        list.set(swapIndex, temp);
    }
}

