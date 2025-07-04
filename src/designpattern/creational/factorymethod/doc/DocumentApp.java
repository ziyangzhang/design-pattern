package designpattern.creational.factorymethod.doc;

// Creator (abstract class)
public abstract class DocumentApp {
    // Factory Method
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();  // Factory Method is called here
        doc.open();                       // Common operation
    }
}