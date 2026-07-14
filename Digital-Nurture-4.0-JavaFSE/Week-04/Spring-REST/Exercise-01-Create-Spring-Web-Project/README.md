# Create Spring Boot Web Project

## Objective
This exercise bootstraps a basic Spring Boot MVC web application.

## Files
*   `application.properties` – H2 database and port property setups
*   `pom.xml` – Maven configuration file containing project dependencies
*   `SpringLearnApplication.java` – Spring Boot main starter configuration class
*   `SpringLearnApplicationTests.java` – Integration tests validating web server boots successfully

## Approach
I created a Spring Boot application class using web starter configurations in pom.xml.

## How to Run
```bash
mvn clean test
```

## Result
Spring Boot launches the Tomcat web server and starts the application context successfully.

## What I Learned
I learned how Spring Boot handles autoconfigurations for web projects.
