/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util.sort;

import io.kirmani.util.logging.Log;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSort {
    public static final String TAG = BaseSort.class.getSimpleName();

    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        return null;
    }

    public static <E extends Comparable<? super E>> List<E> getCopy(List<E> list) {
        return new ArrayList<E>(list);
    }

    public static <E extends Comparable<? super E>> boolean isSorted(List<E> list) {
        for (int index = 0; index < list.size() - 1; index++) {
            if (list.get(index).compareTo(list.get(index + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<? super E>> boolean isSorted(E[] array) {
        return isSorted(Arrays.asList(array));
    }

    public static <E> void printDiff(String sortName, List<E> before, List<E> after) {
        Log.i(TAG, String.format("List Before Sorting (%s)", sortName));
        for (E item : before) {
            Log.i(TAG, item.toString());
        }
        Log.i(TAG, String.format("List After Sorting (%s)", sortName));
        for (E item : after) {
            Log.i(TAG, item.toString());
        }
    }
}
