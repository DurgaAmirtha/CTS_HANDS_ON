# Spring Setter Injection

## Objective
This exercise demonstrates Setter Dependency Injection. It injects a repository bean into a service bean.

## Files
*   `applicationContext.xml` – XML schema declaring Spring IoC bean definitions
*   `BookRepository.java` – Data access repository bean class
*   `BookService.java` – Business service bean class
*   `LibraryManagementTest.java` – Integration test validating Spring Context loads and runs
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I configured a setter method in BookService and wired the BookRepository reference using property tags in XML.

## How to Run
```bash
mvn clean test
```

## Result
Spring injects the repository into the service, allowing the service to execute repository methods successfully.

## What I Learned
I learned how XML property wiring handles setter dependency injection.
