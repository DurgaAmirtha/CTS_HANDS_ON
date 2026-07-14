# Spring Data JPA CRUD

## Objective
This exercise demonstrates basic database operations using Spring Data JPA and H2 database.

## Files
*   `application.properties` – H2 database and port property setups
*   `Country.java` – JPA Country database entity mapper
*   `CountryNotFoundException.java` – Entity missing custom runtime exception class
*   `CountryRepository.java` – JPA Country database repository interface
*   `CountryService.java` – Transactional database query handling service
*   `data.sql` – SQL seeding queries script
*   `OrmLearnApplication.java` – Spring Boot application core setup
*   `OrmLearnApplicationTests.java` – JPA CRUD transaction integration test
*   `pom.xml` – Maven configuration file containing project dependencies

## Approach
I created a JPA entity with annotations, extended JpaRepository, and configured an in-memory H2 connection.

## How to Run
```bash
mvn clean test
```

## Result
The application boots, seeds data from data.sql, and runs CRUD queries using JPA.

## What I Learned
I learned how Spring Data JPA reduces database boilerplates.
