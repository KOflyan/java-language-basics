package lesson5.classwork.animals;

public class Animal {
    String name;
    boolean isPet;

    public Animal(String name, boolean isPet) {
        this.name = name;
        this.isPet = isPet;
    }

    public void speak() {
        System.out.println("I cannot!");
    }

    public void greet() {
        System.out.printf("%s greets you!", name);
    }

    public boolean isFriendly() {
        return isPet;
    }
}
