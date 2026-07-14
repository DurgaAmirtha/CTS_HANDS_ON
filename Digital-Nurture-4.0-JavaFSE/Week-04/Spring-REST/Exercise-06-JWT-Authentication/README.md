# JWT REST API Security

## Objective
This exercise secures REST API endpoints using role-based controls and JWT tokens.

## Files
*   `application.properties` – H2 database and port property setups
*   `AuthenticationController.java` – Controller handling security tokens and authentication checks
*   `Country.java` – JPA Country database entity mapper
*   `country.xml` – Spring XML resource seeding country database records
*   `CountryController.java` – Controller mapping REST routes for countries metadata
*   `CountryNotFoundException.java` – Entity missing custom runtime exception class
*   `CountryService.java` – Transactional database query handling service
*   `HelloController.java` – Controller mapping hello REST routes
*   `JwtAuthorizationFilter.java` – Security filter parsing Bearer headers validation tokens
*   `pom.xml` – Maven configuration file containing project dependencies
*   `SecurityConfig.java` – Web security configuration bean definition mappings
*   `SpringLearnApplication.java` – Spring Boot main starter configuration class
*   `SpringLearnApplicationTests.java` – Integration tests validating web server boots successfully

## Approach
I implemented basic authentication for token exchange and a custom JWT filter to authorize subsequent requests.

## How to Run
```bash
mvn clean test
```

## Result
The application issues JWT tokens for valid requests and authorizes subsequent API calls.

## What I Learned
I learned how to build and secure REST APIs using custom filters and tokens in Spring Boot.
