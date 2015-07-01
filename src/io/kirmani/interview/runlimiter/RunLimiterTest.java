/*
 * RunLimiterTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.interview.runlimiter;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunLimiterTest {
    private static final long NANO_IN_SEC = 1000000000;

    @Test
    public void testNothing() {}

    @Test
    public void testMeetsSpecInFirstSecond() {
        int[] timesExecuted = new int[] {0};
        int[] timesTrue = new int[] {0};
        long[] startTime = new long[] {now()};
        executeOverInterval(100, NANO_IN_SEC, timesExecuted, timesTrue, startTime);
        assertEquals("CanExec() should have executed 100 times.", 100, timesTrue[0]);
    }

    @Test
    public void testMeetsSpecAfterFirstSecond() {
        int[] timesExecuted = new int[] {0};
        int[] timesTrue = new int[] {0};
        long[] startTime = new long[] {now()};
        executeOverInterval(10, NANO_IN_SEC * 1 / 10, timesExecuted, timesTrue, startTime);
        assertEquals("CanExec() should have executed 10 times at this point.",
                10, timesExecuted[0]);
        assertEquals("CanExec() should have been true 10 times at this point.",
                10, timesTrue[0]);
        executeOverInterval(10, NANO_IN_SEC * 9 / 10, timesExecuted, timesTrue, startTime);
        assertEquals("CanExec() should have still executed 10 times at this point.",
                10, timesExecuted[0]);
        assertEquals("CanExec() should have still been true 10 times at this point.",
                10, timesTrue[0]);
        executeOverInterval(100, NANO_IN_SEC, timesExecuted, timesTrue, startTime);
        assertEquals("CanExec() should have been executed 100 times at this point.",
                100, timesExecuted[0]);
        assertEquals("CanExec() should have been true 100 times at this point.",
                100, timesTrue[0]);
        executeOverInterval(190, NANO_IN_SEC * 12 / 10, timesExecuted, timesTrue, startTime);
        assertEquals("CanExec() should have been executed 190 times at this point.",
                190, timesExecuted[0]);
        /* assertEquals("CanExec() should have been true 100 times at this point.",
                100, timesTrue[0]); */
    }

    private void executeOverInterval(int endTimesExecuted, long endTime /* nanoseconds */,
            int[] timesExecuted, int[] timesTrue, long[] startTime) {
        assertEquals("timesExecuted must be of length 1", 1, timesExecuted.length);
        assertEquals("timesTrue must be of length 1", 1, timesTrue.length);
        assertEquals("startTime must be of length 1", 1, startTime.length);
        int startTimesExecuted = timesExecuted[0];
        while (now() - startTime[0] < endTime) {
            if (timesExecuted[0] < endTimesExecuted) {
                if (RunLimiter.canExec()) {
                    timesTrue[0]++;
                }
                timesExecuted[0]++;
            }
        }
        assertEquals("The executions did not complete in time.",
                endTimesExecuted, timesExecuted[0]);
    }

    private long now() {
        return System.nanoTime();
    }
}

