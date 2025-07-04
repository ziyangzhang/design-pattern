package designpattern.creational.factorymethod.doc;

// Concrete creators (subclasses override the factory method)
public class WordApp extends DocumentApp {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
