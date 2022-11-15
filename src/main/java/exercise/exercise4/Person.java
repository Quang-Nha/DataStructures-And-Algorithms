package exercise.exercise4;

public class Person {
    String name;
    int age;

    Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }

    public String toString() {
        return String.format("%-7s%-5d", name,age);
    }
}

