package com.dsa.forecasting;

public class Forecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {

        if (years == 0) {
            return presentValue;
        }

        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }

        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}