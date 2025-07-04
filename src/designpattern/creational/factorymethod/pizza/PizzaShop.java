package designpattern.creational.factorymethod.pizza;

// Product Interface
interface Pizza {
    void prepare();
}

// Concrete Products
class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a delicious pepperoni pizza!");
    }
}

class VeggiePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a fresh veggie pizza!");
    }
}

class ChickenPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a spicy chicken pizza!");
    }
}

// Chef class — handles pizza preparation directly
class PizzaChef {
    public void servePizza(String type) {
        Pizza pizza;

        // Direct object creation based on type
        if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza();
        } else if (type.equalsIgnoreCase("chicken")) {
            pizza = new ChickenPizza();
        } else {
            System.out.println("Sorry, we don't have that type of pizza.");
            return;
        }

        pizza.prepare();
        System.out.println("Pizza is served!\n");
    }
}

// Client
public class PizzaShop {
    public static void main(String[] args) {
        PizzaChef chef = new PizzaChef();

        chef.servePizza("pepperoni");
        chef.servePizza("veggie");
        chef.servePizza("chicken");
        chef.servePizza("hawaiian"); // Not supported
    }
}


/*
- You must modify this PizzaChef every time a new pizza is added (tight coupling).
- Violates Open/Closed Principle (not open for extension, only modification).
- Less reusable, harder to maintain, and not scalable.
 */