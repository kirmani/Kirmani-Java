/*
 * Log.java
 * Copyright (C) 2015 Sean Kirmani <sean@kirmani.io>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.util.logging;

import io.kirmani.util.CallerFinder;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;

    private static final Map<Integer, Level> LOG_LEVEL_MAP = new HashMap<>();
    static {
        LOG_LEVEL_MAP.put(VERBOSE, Level.FINEST);
        LOG_LEVEL_MAP.put(DEBUG, Level.FINE);
        LOG_LEVEL_MAP.put(INFO, Level.INFO);
        LOG_LEVEL_MAP.put(WARN, Level.WARNING);
        LOG_LEVEL_MAP.put(ERROR, Level.SEVERE);
        LOG_LEVEL_MAP.put(ASSERT, Level.SEVERE);
    }

    private static Logger logger = Logger.getLogger(CallerFinder
            .findCallerOf(Log.class).getClassName());
    static {
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new LogFormatter());
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }

    private Log() {}

    public static void d(String tag, String message) {
        if (isLoggable(tag, DEBUG)) {
            logger.log(LOG_LEVEL_MAP.get(DEBUG), message);
        }
    }

    public static void e(String tag, String message) {
        if (isLoggable(tag, ERROR)) {
            logger.log(LOG_LEVEL_MAP.get(ERROR), message);
        }
    }

    public static void i(String tag, String message) {
        if (isLoggable(tag, INFO)) {
            logger.log(LOG_LEVEL_MAP.get(INFO), message);
        }
    }

    public static void v(String tag, String message) {
        if (isLoggable(tag, VERBOSE)) {
            logger.log(LOG_LEVEL_MAP.get(VERBOSE), message);
        }
    }

    public static void w(String tag, String message) {
        if (isLoggable(tag, WARN)) {
            logger.log(LOG_LEVEL_MAP.get(WARN), message);
        }
    }

    public static boolean isLoggable(String tag, int level) {
        return logger.isLoggable(LOG_LEVEL_MAP.get(level));
    }
}

