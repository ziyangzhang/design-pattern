package designpattern.creational.factorymethod.doc;

public class Client {
    public static void main(String[] args) {
        DocumentApp app1 = new WordApp();
        DocumentApp app2 = new PdfApp();

        app1.openDocument();  // Output: Opening a Word document.
        app2.openDocument();  // Output: Opening a PDF document.
    }
}
