# E-commerce Search Comparison

## Objective
This exercise compares linear search and binary search for finding products in an e-commerce product list.

## Files
*   `EcommerceSearchTest.java` – Timing comparison test for search times
*   `pom.xml` – Maven configuration file containing project dependencies
*   `Product.java` – Product data model
*   `SearchAlgorithms.java` – Linear and Binary search algorithm functions

## Approach
Linear search checks the products one by one. Binary search checks the middle element and reduces the search range, but the product list must be sorted first.

## How to Run
```bash
mvn clean test
```

## Result
The search algorithms run on a test list of products and output the time taken in nanoseconds for each algorithm.

## What I Learned
I understood the difference between O(n) linear search and O(log n) binary search. I also learned that binary search requires sorted data.
