package designpattern.creational.abstractfactorymethod;

// === Abstract Products ===
interface Pizza {
    void prepare();
}

interface Drink {
    void pour();
}

interface Dessert {
    void serve();
}

// === Concrete Pizzas ===
class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a pepperoni pizza");
    }
}

class VeggiePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a veggie pizza");
    }
}

class ChickenPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing a chicken pizza");
    }
}

// === Concrete Drinks ===
class Soda implements Drink {
    public void pour() {
        System.out.println("Pouring a soda");
    }
}

class Juice implements Drink {
    public void pour() {
        System.out.println("Pouring a fresh juice");
    }
}

class Lemonade implements Drink {
    public void pour() {
        System.out.println("Pouring lemonade");
    }
}

// === Concrete Desserts ===
class IceCream implements Dessert {
    public void serve() {
        System.out.println("Serving ice cream");
    }
}

class Brownie implements Dessert {
    public void serve() {
        System.out.println("Serving a brownie");
    }
}

class Cheesecake implements Dessert {
    public void serve() {
        System.out.println("Serving cheesecake");
    }
}

// === Abstract Factory ===
// Abstract Factory: MealFactory defines how to create a full meal.
interface MealFactory {
    Pizza createPizza();
    Drink createDrink();
    Dessert createDessert();
}

// === Concrete Factories ===
// Concrete Factories: Each family (pepperoni, veggie, chicken) creates a specific pizza + drink + dessert.
class PepperoniMealFactory implements MealFactory {
    // Product Families: All parts of a meal (Pizza, Drink, Dessert) are related and consistent.
    public Pizza createPizza() {
        return new PepperoniPizza();
    }
    public Drink createDrink() {
        return new Soda();
    }
    public Dessert createDessert() {
        return new IceCream();
    }
}

class VeggieMealFactory implements MealFactory {
    public Pizza createPizza() {
        return new VeggiePizza();
    }
    public Drink createDrink() {
        return new Juice();
    }
    public Dessert createDessert() {
        return new Brownie();
    }
}

class ChickenMealFactory implements MealFactory {
    public Pizza createPizza() {
        return new ChickenPizza();
    }
    public Drink createDrink() {
        return new Lemonade();
    }
    public Dessert createDessert() {
        return new Cheesecake();
    }
}

// === Client ===
public class PizzaShop {
    public static void main(String[] args) {
        // Choose a factory dynamically (could be based on user input)
        MealFactory factory = new ChickenMealFactory();

        // Build the meal
        Pizza pizza = factory.createPizza();
        Drink drink = factory.createDrink();
        Dessert dessert = factory.createDessert();

        // Serve the meal
        pizza.prepare();
        drink.pour();
        dessert.serve();
    }
}

// Extensibility: Easy to add a new factory (e.g., Hawaiian meal) without changing existing logic.
