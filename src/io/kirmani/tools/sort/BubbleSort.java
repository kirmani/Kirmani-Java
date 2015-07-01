/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class BubbleSort implements Sortable {
    public <E extends Comparable<? super E>> void sort(List<E> list) {
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
}

