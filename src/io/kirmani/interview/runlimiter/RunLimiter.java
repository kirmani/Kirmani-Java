/*
 * RunLimiter.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.interview.runlimiter;

import java.lang.System;

public class RunLimiter {
	private static final int LIMIT = 1000;
    private static final long NANO_IN_SEC = 1000000000;

    private static long startTime = 0;
    private static int count = 0;

    public static boolean canExec() {
        long currentTime = now();
        if (currentTime - startTime < NANO_IN_SEC) {
            if (count >= LIMIT) {
                return false;
            }
            count++;
        } else {
            count = 1;
            startTime = currentTime;
        }
        return true;
    }

    private static long now() {
        return System.nanoTime();
    }
}

