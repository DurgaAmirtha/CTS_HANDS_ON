package com.pattern.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document: Loading layout and text styles.");
    }
}