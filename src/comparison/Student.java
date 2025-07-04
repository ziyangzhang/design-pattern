package comparison;

import java.util.Set;

public class Student {
    public String name;
    public int age;

    @Override
    public int hashCode() {
        return name.charAt(0);
    }

    @Override
    public boolean equals(Object obj) {
//        return this.name.equals(((Student) obj).name);
        return this.name.charAt(0) == ((Student) obj).name.charAt(0);
    }

    public String toString() {
        return String.format("Student{name='%s', age=%d}", name, age);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Missy";
        s1.age = 30;

        Student s2 = new Student();
        s2.name = "Mike";
        s2.age = 30;

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.equals(s2));


        Set<Student> set = Set.of(s1);
        System.out.println(set);

        System.out.println(set.contains(s2));
    }
}





