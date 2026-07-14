package com.junit.setup;

import org.junit.Test;
import static org.junit.Assert.*;

public class SetupTest {

    @Test
    public void testJUnitIsConfigured() {
        System.out.println("JUnit environment loaded successfully!");
        assertTrue("Basic configuration assertion", true);
    }
}