package lesson5.classwork.animals;

public class Dog extends Animal{
    public Dog(String name, boolean isPet) {
        super(name, isPet);
    }

    public void roll() {
        System.out.println("roll");
    }
    public void speak() {
        System.out.println("Bark!");
    }
}
