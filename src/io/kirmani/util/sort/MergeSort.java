/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort extends BaseSort {
    private static final String TAG = MergeSort.class.getSimpleName();

    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        // Base case. A list of zero or one elements is sorted, by definition.
        if (list.size() <= 1) {
            return list;
        }

        // Recursive case. First, *divide* the list into equal sized-sublists.
        List<E> left = new ArrayList<>();
        List<E> right = new ArrayList<>();
        int middle = list.size() / 2;
        for (int index = 0; index < middle; index++) {
            left.add(list.get(index));
        }
        for (int index = middle; index < list.size(); index++) {
            right.add(list.get(index));
        }

        // Recursively sort both sublists.
        left = sort(left);
        right = sort(right);

        // Then merge the now-sorted sublists.
        return merge(left, right);
    }

    private static <E extends Comparable<? super E>> List<E> merge(List<E> left, List<E> right) {
        List<E> result = new ArrayList<E>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }
        return result;
    }

    public static <E extends Comparable<? super E>> void printDiff(List<E> list) {
        printDiff(TAG, list, sort(list));
    }
}
