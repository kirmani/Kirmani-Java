/*
 * BubbleSort.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public class BubbleSort extends BaseSort {
    public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
        List<E> copy = getCopy(list);
        boolean done = false;
        while (!done) {
            done = true;
            for (int index = 0; index < copy.size() - 1; index++) {
                if (copy.get(index).compareTo(copy.get(index + 1)) > 0) {
                    E temp = copy.get(index);
                    copy.set(index, copy.get(index + 1));
                    copy.set(index + 1, temp);
                    done = false;
                }
            }
        }
        return copy;
    }
}

