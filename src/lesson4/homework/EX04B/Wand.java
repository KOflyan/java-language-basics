package lesson4.homework.EX04B;


public class Wand {

    private String woodType;
    private String core;

    public Wand(String woodType, String core) {
        this.woodType = woodType;
        this.core = core;
    }

    public static void checkWand(Wand wand) throws InvalidWandException {}


    public String getWoodType() {
        return null;
    }

    public void setWoodType(String woodType) {}

    public String getCore() {
        return null;
    }

    public void setCore(String core) {}

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
