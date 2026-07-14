package com.pattern.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document: Initializing spreadsheet grid and formulas.");
    }
}