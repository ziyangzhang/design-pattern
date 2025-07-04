package designpattern.creational.builder;

// telescoping constructor anti-pattern, where multiple constructors with different parameters are used,
// making the code hard to read and maintain.
// Suppose you have a User class with optional fields.
// Python supports flexible number of parameters and default value. So this is not really a problem in Python

class User {
    private String name;
    private int age;
    private String email;
    private String phone;

    public User(String name) {
        this(name, 0);
    }

    public User(String name, int age) {
        this(name, age, null);
    }

    public User(String name, int age, String email) {
        this(name, age, email, null);
    }

    public User(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}

/*

# Name has default value
# *hobbies: Variable Positional Arguments, collects extra positional args into a tuple
# **details: Variable Keyword Arguments, collects extra keyword args into a dict
def describe_person(name="Unknown", *hobbies, **details):
    print(f"Name: {name}")
    print("Hobbies:", hobbies)
    print("Details:", details)

describe_person("Bob", "reading", "cycling", age=25, city="NYC")


 */
