package com.pattern.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document: Rendering page elements and fonts.");
    }
}