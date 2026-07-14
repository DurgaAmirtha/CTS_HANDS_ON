# AAA Pattern and Fixtures

## Objective
This exercise implements the Arrange-Act-Assert pattern and handles JUnit setup/teardown fixtures.

## Files
*   `Calculator.java` – Basic arithmetic calculation module
*   `CalculatorTest.java` – JUnit test checking calculator math actions using AAA pattern
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I set up a calculator instance inside a @Before annotated method and structured the tests in three distinct steps (Arrange, Act, Assert).

## How to Run
```bash
mvn clean test
```

## Result
The unit tests verify addition, subtraction, multiplication, and division on the calculator instance.

## What I Learned
I learned how setup and teardown fixtures ensure each test runs on a clean state.
