/*
 * Sortable.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.tools.sort;

import java.util.List;

public interface Sortable {
    <E extends Comparable<? super E>> void sort(List<E> list);
}
