/*
 * Sorter.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Sorter {
    public static <E extends Comparable<? super E>> void bubblesort(List<E> list) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int index = 0; index < list.size() - 1; index++) {
                if (list.get(index).compareTo(list.get(index + 1)) > 0) {
                    E temp = list.get(index);
                    list.set(index, list.get(index + 1));
                    list.set(index + 1, temp);
                    done = false;
                }
            }
        }

    }

    public static <E extends Comparable<? super E>> void bubblesort(E[] array) {
        bubblesort(Arrays.asList(array));
    }

    public static <E extends Comparable<? super E>> E[] getBubblesort(E[] array) {
        E[] copy = getCopy(array);
        bubblesort(copy);
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

