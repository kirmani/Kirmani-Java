/*
 * RunLimiter.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.interview.runlimiter;

import java.lang.System;
import java.util.LinkedList;
import java.util.Queue;

public class RunLimiter {
	private static final int LIMIT = 100;
    private static final long NANO_IN_SEC = 1000000000;

    private long mStartTime;
    private int mCount;

    private Queue<Long> mTimes;

    public RunLimiter() {
        mStartTime = 0;
        mCount = 0;
        mTimes = new LinkedList<Long>();
    }

    public boolean canExec() {
        long currentTime = now();
        if (mTimes.size() == 0) {
            mTimes.add(currentTime);
            return true;
        }
        while (currentTime - mTimes.peek() >= NANO_IN_SEC) {
            mTimes.remove();
        }
        if (mTimes.size() >= LIMIT) {
            return false;
        }
        mTimes.add(currentTime);
        return true;
        /*
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
        */
    }

    private static long now() {
        return System.nanoTime();
    }
}

