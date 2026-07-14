# Financial Forecasting

## Objective
This exercise calculates the future value of an investment using a recursive method.

## Files
*   `Forecasting.java` – Future value computation class
*   `ForecastingTest.java` – JUnit tests verifying growth output predictions
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
The method applies the growth rate for each remaining year until it reaches the base case.

## How to Run
```bash
mvn clean test
```

## Result
The program calculates the forecasted value recursively and compares it with an iterative loop calculation.

## What I Learned
I learned how recursion works using a base condition and repeated method calls.
