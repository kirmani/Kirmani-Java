/*
 * Sorter.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sorter {
    public static <E extends Comparable<? super E>> void sort(Sortable sorter, List<E> list) {
        sorter.sort(list);
    }

    public static <E extends Comparable<? super E>> void sort(Sortable sorter, E[] array) {
        sorter.sort(Arrays.asList(array));
    }

    public static <E extends Comparable<? super E>> List<E> getSortedList(Sortable sorter,
            List<E> list) {
        List<E> copy = new ArrayList<E>(list);
        sort(sorter, copy);
        return copy;
    }

    public static <E extends Comparable<? super E>> E[] getSortedArray(Sortable sorter, E[] array) {
        E[] copy = getCopy(array);
        sort(sorter, copy);
        return copy;
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

    public static <E extends Comparable<? super E>> E[] getCopy(E[] array) {
        @SuppressWarnings("unchecked")
        E[] copy = (E[]) Array.newInstance(array.getClass().getComponentType(), array.length);
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
