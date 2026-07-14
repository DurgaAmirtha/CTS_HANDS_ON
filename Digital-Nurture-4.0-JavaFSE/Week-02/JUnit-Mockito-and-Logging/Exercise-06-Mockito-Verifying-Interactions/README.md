# Mockito Interaction Verification

## Objective
This exercise demonstrates interaction checks. It verifies that methods on mocked dependencies are invoked.

## Files
*   `ExternalApi.java` – Dependency interface mapping
*   `MyService.java` – Target service class invoking dependency APIs
*   `MyServiceTest.java` – Unit tests utilizing mocked interfaces and stubs
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I used Mockito's verify method to verify that dependency interactions are executed correctly.

## How to Run
```bash
mvn clean test
```

## Result
The test logs show that external calls were triggered correctly during execution.

## What I Learned
I learned that verifying interactions is key when testing void methods or actions with side effects.
