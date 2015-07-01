/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort extends BaseSort {
    private static final String TAG = QuickSort.class.getSimpleName();

    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        List<E> copy = getCopy(list);
        if (copy.size() <= 1) {
            return copy;
        }
        List<E> left = new ArrayList<E>();
        List<E> right = new ArrayList<E>();
        for (int i = 1; i < copy.size(); i++) {
            if (copy.get(i).compareTo(copy.get(0)) < 0) {
                left.add(copy.get(i));
            } else {
                right.add(copy.get(i));
            }
        }
        List<E> result = sort(left);
        result.add(copy.get(0));
        result.addAll(sort(right));
        return result;
    }

    public static <E extends Comparable<? super E>> void printDiff(List<E> list) {
        printDiff(TAG, list, sort(list));
    }
}

