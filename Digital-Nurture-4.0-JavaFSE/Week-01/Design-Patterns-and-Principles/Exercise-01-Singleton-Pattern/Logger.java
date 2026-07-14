package com.pattern.singleton;

public class Logger {

    private static volatile Logger instance;

    private Logger() {
        System.out.println("Logger Instance Created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            // Double-checked locking to ensure thread safety
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + System.currentTimeMillis() + " : " + message);
    }
}