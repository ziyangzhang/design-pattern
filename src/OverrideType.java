public class OverrideType {
    public static void main(String[] args) {
        System.out.println("Hello World");
        showLife(new Dog());

        ChinesePerson missy = new ChinesePerson("missy");
        System.out.println(missy.name);
        System.out.println(ChinesePerson.nationality);

        ChinesePerson tianyi = new ChinesePerson("tianyi");
        System.out.println(tianyi.name);
        System.out.println(ChinesePerson.nationality);

        ChinesePerson.nationality = "Earth";

        System.out.println(missy.name);
        System.out.println(ChinesePerson.nationality);

        System.out.println(tianyi.name);
        System.out.println(ChinesePerson.nationality);

        Animal a1 = new Animal();
        a1 = new Dog();
    }

    public static void showLife(Animal a) {
        Animal myA = a.getALife();
        System.out.println(myA.color);
    }
}


class Animal {
    String color;
    public Animal getALife() {
        return new Animal();
    }
}

class Dog extends Animal {
    String bark;
    public Dog getALife() {
        return new Dog();
    }
}

// class vs object/instance
class ChinesePerson {
    public ChinesePerson(String name) {
        this.name = name;
    }

    String name;
    static String nationality = "Chinese";

    public String getName() {
        return name;
    }

    public static String getNationality() {
        return nationality;
    }
}





