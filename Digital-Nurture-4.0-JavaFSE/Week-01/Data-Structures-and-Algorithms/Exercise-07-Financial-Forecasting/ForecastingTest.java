package com.dsa.forecasting;

import org.junit.Test;
import static org.junit.Assert.*;

public class ForecastingTest {

    @Test
    public void testFutureValueCalculation() {
        double pv = 1000.0;
        double rate = 0.05;
        int years = 10;

        double expected = pv * Math.pow(1 + rate, years);

        double recursiveResult = Forecasting.calculateFutureValue(pv, rate, years);
        double iterativeResult = Forecasting.calculateFutureValueIterative(pv, rate, years);

        assertEquals(expected, recursiveResult, 0.001);
        assertEquals(expected, iterativeResult, 0.001);

        System.out.println("Present Value: $" + pv);
        System.out.println("Growth Rate: " + (rate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println("Forecasted Future Value (Recursive): $" + recursiveResult);
        System.out.println("Forecasted Future Value (Iterative): $" + iterativeResult);
    }

    @Test
    public void testBaseCase() {
        double pv = 1500.0;
        double result = Forecasting.calculateFutureValue(pv, 0.08, 0);
        assertEquals(pv, result, 0.0);
    }
}