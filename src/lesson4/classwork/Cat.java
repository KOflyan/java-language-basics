package lesson4.classwork;

import java.util.Objects;

public class Cat {
    private String name;
    private String owner;

    private String sweater;

    public Cat(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void roll() {
        System.out.println("*rolling*");
    }

    public void greet() {
        System.out.println("meow!");
    }

    public void speak() {
        System.out.println("I cannot!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat cat) {
            return this.name.equals(cat.name)
                    && this.owner.equals(cat.owner);
        }

        return false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.owner);
    }
}
