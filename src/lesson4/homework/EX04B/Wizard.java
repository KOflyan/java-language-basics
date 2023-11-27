package lesson4.homework.EX04B;


public class Wizard {

    private String name;
    private Wand wand;

    public Wizard(String name) {
        this.name = name;
        this.wand = null;
    }

    public Wizard(String name, Wand wand) {
        this.name = name;
        this.wand = wand;
    }

    public Wand getWand() {
        return null;
    }

    public void setWand(Wand wand) throws InvalidWandException {
    }

    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return -1;
    }
}
