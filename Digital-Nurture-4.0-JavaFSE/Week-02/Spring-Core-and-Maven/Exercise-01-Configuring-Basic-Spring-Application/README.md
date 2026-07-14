# Spring XML Configuration

## Objective
This exercise demonstrates basic Spring configurations. It declares core beans in an XML context.

## Files
*   `applicationContext.xml` – XML schema declaring Spring IoC bean definitions
*   `BookRepository.java` – Data access repository bean class
*   `BookService.java` – Business service bean class
*   `LibraryManagementTest.java` – Integration test validating Spring Context loads and runs
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I defined BookRepository and BookService beans inside applicationContext.xml and loaded the application context.

## How to Run
```bash
mvn clean test
```

## Result
Spring loads the context, instantiates the repository and service beans, and verifies they are active.

## What I Learned
I learned how Spring IoC manages bean creation through XML configurations.
