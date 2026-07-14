package com.dsa.search;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class EcommerceSearchTest {

    @Test
    public void testSearchAlgorithms() {

        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Smartphone", "Electronics"),
            new Product("103", "Headphones", "Accessories"),
            new Product("104", "Backpack", "Luggage"),
            new Product("105", "Running Shoes", "Footwear")
        };

        Product foundLinear = SearchAlgorithms.linearSearch(products, "Headphones");
        assertNotNull("Product should be found via linear search", foundLinear);
        assertEquals("103", foundLinear.getProductId());

        Product notFoundLinear = SearchAlgorithms.linearSearch(products, "Smartwatch");
        assertNull("Non-existent product should return null", notFoundLinear);

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        Product foundBinary = SearchAlgorithms.binarySearch(sortedProducts, "Headphones");
        assertNotNull("Product should be found via binary search", foundBinary);
        assertEquals("103", foundBinary.getProductId());

        Product notFoundBinary = SearchAlgorithms.binarySearch(sortedProducts, "Smartwatch");
        assertNull("Non-existent product should return null in binary search", notFoundBinary);

        long startLinear = System.nanoTime();
        SearchAlgorithms.linearSearch(products, "Running Shoes");
        long durationLinear = System.nanoTime() - startLinear;

        long startBinary = System.nanoTime();
        SearchAlgorithms.binarySearch(sortedProducts, "Running Shoes");
        long durationBinary = System.nanoTime() - startBinary;

        System.out.println("Linear Search execution time: " + durationLinear + " ns");
        System.out.println("Binary Search execution time: " + durationBinary + " ns");
    }
}