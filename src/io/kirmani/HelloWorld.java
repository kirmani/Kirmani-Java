/*
 * Main.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class HelloWorld {
    static Logger logger = Logger.getLogger(HelloWorld.class);

	public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Hello World");
	}
}

