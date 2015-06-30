/*
 * HelloWorldTest.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani;

import static org.junit.Assert.*;

import org.junit.Test;


public class HelloWorldTest {

    @Test
    public void testNothing() {}

    @Test
    public void testWelcome() {
        assertEquals("welcome", "welcome");
    }
}

