package lesson4.homework.EX04B;

import java.util.Objects;

public class Wizard {
    private final String name;
    private Wand wand = null;

    public Wizard(String name) {
        this.name = name;
    }

    public Wizard(String name, Wand wand) throws InvalidWandException {
        Wand.checkWand(wand);
        this.name = name;
        this.wand = wand;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) throws InvalidWandException {
        Wand.checkWand(wand);
        this.wand = wand;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wizard o)) {
            return false;
        }

        return this.name.equals(o.name) && this.wand.equals(o.wand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, wand);
    }
}
