# Singleton Pattern Logger

## Objective
This exercise demonstrates the Singleton design pattern. The logger class allows only one object to be created and returns the same object whenever it is requested.

## Files
*   `Logger.java` – Logger class implementing Singleton pattern
*   `LoggerTest.java` – Unit test verifying the Singleton implementation
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
The constructor is private so that the class cannot be instantiated from outside. A static method returns the single logger instance.

## How to Run
```bash
mvn clean test
```

## Result
The application retrieves two logger instances and asserts that both references point to the exact same object in memory.

## What I Learned
I learned how a private constructor and a static instance can be used to control object creation.
