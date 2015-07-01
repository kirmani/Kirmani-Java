/*
 * CallerFinder.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util;

public class CallerFinder {
	private CallerFinder() {}

    public static StackTraceElement findCallerOf(Class<?>... classesToFind) {
        return findCallerOf(new Throwable(), classesToFind);
    }

    public static StackTraceElement findCallerOf(Throwable t, Class<?>... classesToFind) {
        StackTraceElement[] stack = t.getStackTrace();
        StackTraceElement prevElement = null;
        for (int i = stack.length - 1; i >= 0; i--) {
            StackTraceElement element = stack[i];
            String className = element.getClassName();
            for (Class<?> classToFind : classesToFind) {
                if (className.equals(classToFind.getName())) {
                    return prevElement;
                }
            }
            prevElement = element;
        }
        return null;
    }
}
