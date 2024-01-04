package lesson4.homework.EX04B;


public class Wizard {

    private String name;
    private Wand wand;

    public Wizard(String name) {
        this.name = name;
        this.wand = null;
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
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wizard wizard) {
            return wizard.name.equals(name) && wizard.wand.equals(wand);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int nameHash = name == null ? 1 : name.hashCode();
        int wandHash = wand == null ? 1 : wand.hashCode();
        return nameHash*wandHash;
    }
}
