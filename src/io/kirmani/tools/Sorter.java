/*
 * Sorter.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools;

public class Sorter {
    public static <E extends Comparable<E>> void bubblesort(E[] array) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index].compareTo(array[index + 1]) > 0) {
                    E temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    done = false;
                }
            }
        }
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index].compareTo(array[index + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}

