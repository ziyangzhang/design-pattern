package designpattern.creational.factorymethod.doc;

// Concrete products
public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}
