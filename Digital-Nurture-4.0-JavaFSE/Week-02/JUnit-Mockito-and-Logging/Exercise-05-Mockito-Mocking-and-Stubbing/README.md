# Mockito Stubbing

## Objective
This exercise demonstrates Mockito mocking and stubbing. It overrides dependency behaviors for testing.

## Files
*   `ExternalApi.java` – Dependency interface mapping
*   `MyService.java` – Target service class invoking dependency APIs
*   `MyServiceTest.java` – Unit tests utilizing mocked interfaces and stubs
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I used Mockito to mock the ExternalApi interface and stubbed its methods using when/thenReturn syntax.

## How to Run
```bash
mvn clean test
```

## Result
The tests isolate the MyService component and successfully verify its functionality with mock data.

## What I Learned
I learned how mocking database or API dependencies makes testing single components easier.
