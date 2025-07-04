package designpattern.creational.factorymethod.doc;

// Concrete products
public class PdfApp extends DocumentApp {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
