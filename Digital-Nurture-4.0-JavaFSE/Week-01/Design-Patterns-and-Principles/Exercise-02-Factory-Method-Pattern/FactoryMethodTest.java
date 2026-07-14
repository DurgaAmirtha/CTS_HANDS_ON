package com.pattern.factory;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryMethodTest {

    @Test
    public void testWordDocumentFactory() {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull("Document should not be null", doc);
        assertTrue("Document should be an instance of WordDocument", doc instanceof WordDocument);
        doc.open();
    }

    @Test
    public void testPdfDocumentFactory() {
        DocumentFactory factory = new PdfDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull("Document should not be null", doc);
        assertTrue("Document should be an instance of PdfDocument", doc instanceof PdfDocument);
        doc.open();
    }

    @Test
    public void testExcelDocumentFactory() {
        DocumentFactory factory = new ExcelDocumentFactory();
        Document doc = factory.createDocument();
        assertNotNull("Document should not be null", doc);
        assertTrue("Document should be an instance of ExcelDocument", doc instanceof ExcelDocument);
        doc.open();
    }
}