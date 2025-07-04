package designpattern.creational.factorymethod.pizza;

// Product Interface
interface Pizza1 {
    void prepare();
}

// Concrete Products
class PepperoniPizza1 implements Pizza1 {
    public void prepare() {
        System.out.println("Preparing a delicious pepperoni pizza!");
    }
}

class VeggiePizza1 implements Pizza1 {
    public void prepare() {
        System.out.println("Preparing a fresh veggie pizza!");
    }
}

class ChickenPizza1 implements Pizza1 {
    public void prepare() {
        System.out.println("Preparing a spicy chicken pizza!");
    }
}

// Abstract Creator (Factory)
abstract class PizzaChef1 {
    // Factory Method
    public abstract Pizza makePizza();

    // Common logic using the factory method
    public void servePizza() {
        Pizza pizza = makePizza();
        pizza.prepare();
        System.out.println("Pizza is served!\n");
    }
}

// Concrete Creators
class PepperoniChef extends PizzaChef1 {
    public Pizza makePizza() {
        return new PepperoniPizza();
    }
}

class VeggieChef extends PizzaChef1 {
    public Pizza makePizza() {
        return new VeggiePizza();
    }
}

class ChickenChef extends PizzaChef1 {
    public Pizza makePizza() {
        return new ChickenPizza();
    }
}

// Client
public class PizzaShopFactory {
    public static void main(String[] args) {
        PizzaChef1 chef1 = new PepperoniChef();
        chef1.servePizza();

        PizzaChef1 chef2 = new VeggieChef();
        chef2.servePizza();

        PizzaChef1 chef3 = new ChickenChef();
        chef3.servePizza();
    }
}
