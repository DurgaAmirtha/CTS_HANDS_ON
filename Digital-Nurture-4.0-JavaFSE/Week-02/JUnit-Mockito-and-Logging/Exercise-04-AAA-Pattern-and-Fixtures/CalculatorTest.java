package com.junit.fixtures;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up test fixture: instantiating Calculator.");

        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down test fixture: cleaning up Calculator.");
        calculator = null;
    }

    @Test
    public void testAdd() {

        int number1 = 10;
        int number2 = 20;

        int result = calculator.add(number1, number2);

        assertEquals("10 + 20 should equal 30", 30, result);
    }

    @Test
    public void testSubtract() {

        int number1 = 50;
        int number2 = 20;

        int result = calculator.subtract(number1, number2);

        assertEquals("50 - 20 should equal 30", 30, result);
    }
}