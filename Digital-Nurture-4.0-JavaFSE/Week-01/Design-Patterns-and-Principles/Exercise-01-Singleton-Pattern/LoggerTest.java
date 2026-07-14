package com.pattern.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void testSingletonInstance() {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertNotNull("Logger instance should not be null", logger1);
        assertSame("Both references should point to the same instance", logger1, logger2);

        logger1.log("Testing singleton pattern - first call");
        logger2.log("Testing singleton pattern - second call");
    }
}