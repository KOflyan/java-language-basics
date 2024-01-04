package lesson4.homework.EX04B;


public class Wand {

    private String woodType;
    private String core;

    public Wand(String woodType, String core) {
        this.woodType = woodType;
        this.core = core;
    }

    public static void checkWand(Wand wand) throws InvalidWandException {
        if (wand == null || wand.woodType == null || wand.core == null) {
            throw new InvalidWandException();
        }
    }


    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", woodType, core);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Wand wand) {
            return wand.woodType.equals(woodType) && wand.core.equals(core);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return woodType.hashCode() * core.hashCode();
    }
}
