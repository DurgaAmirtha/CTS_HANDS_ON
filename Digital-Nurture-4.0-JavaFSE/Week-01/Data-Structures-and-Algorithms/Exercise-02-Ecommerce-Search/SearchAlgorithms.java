package com.dsa.search;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String targetName) {
        if (products == null || targetName == null) return null;
        for (Product product : products) {
            if (product != null && targetName.equalsIgnoreCase(product.getProductName())) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String targetName) {
        if (sortedProducts == null || targetName == null) return null;
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            // Calculate mid index safely to prevent integer overflow
            int mid = low + (high - low) / 2;
            Product midProduct = sortedProducts[mid];

            if (midProduct == null) {
                return null;
            }

            int comparison = targetName.compareToIgnoreCase(midProduct.getProductName());

            if (comparison == 0) {
                return midProduct;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}