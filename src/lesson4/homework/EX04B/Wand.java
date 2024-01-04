package lesson4.homework.EX04B;

import java.util.Objects;

public class Wand {

    private String woodType;
    private String core;

    public Wand(String woodType, String core) {
        this.woodType = woodType;
        this.core = core;
    }

    public static void checkWand(Wand wand) throws InvalidWandException {
        if (wand == null || wand.core == null || wand.woodType == null) {
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
        return String.format("%s, %s", this.woodType, this.core);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wand o)) {
            return false;
        }

        return this.core.equals(o.core) && this.woodType.equals(o.woodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(woodType, core);
    }
}
