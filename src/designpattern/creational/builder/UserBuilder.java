package designpattern.creational.builder;

class User1 {
    private String name;
    private int age;
    private String email;
    private String phone;

    private User1(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    // Does each User has its own inner static builder class?
    // No, the static nested Builder class is a single class shared by all User instances, not a separate class per instance.
    // While there is only one Builder class, you can create multiple instances of the Builder, each independent from each other.
    /*
    User.Builder builder1 = new User.Builder();
    User.Builder builder2 = new User.Builder();

    User user1 = builder1.name("Alice").age(30).build();
    User user2 = builder2.name("Bob").age(25).build();

    Above code is thread-safe (if user1 and user are concurrently created), because builder1 and builder2 are different
    objects (instances) of the same static nested class Builder. Setting name/age into different builder objects
    concurrently does not cause concurrency issues.
     */

    public static class Builder {
        // initialized only once, not accidentally forgotten
        // never changed after construction (immutability)
        /*
        // If we need to make name truly required (non-null) need to add below check
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }
         */
        private final String name; // required
        private int age;
        private String email;
        private String phone;

        // You must pass required field "name" when calling the builder, or the code won’t compile.
        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User1 build() {
            return new User1(this);
        }
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, email='%s', phone='%s'}", name, age, email, phone);
    }
}


public class UserBuilder {
    public static void main(String[] args) {
        User1 user = new User1.Builder("Alice")
                .age(30)
                .email("alice@example.com")
                .phone("1234567890")
                .build();

        System.out.println(user);
    }
}

