# SLF4J and Logback Logging

## Objective
This exercise demonstrates application logging. It configures Logback levels to filter messages.

## Files
*   `logback.xml` – Logback configuration defining appenders and logs hierarchy
*   `LoggingExample.java` – Standard logger output operations
*   `LoggingExampleTest.java` – Verification tests displaying logged console statements
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I added SLF4J logger calls inside the class and created a logback.xml file to specify formats and level configurations.

## How to Run
```bash
mvn clean test
```

## Result
Running tests prints logs to the console showing INFO, WARN, and ERROR messages with custom formats.

## What I Learned
I learned how Logback formats and levels filter log outputs.
