package lesson5.classwork.animals;

public class Dolphin extends Animal {
    boolean isSmart;
    boolean isPlayful;
    public Dolphin(String name, boolean isPet, boolean isPlayful, boolean isSmart) {
        super(name, isPet);
        this.isPlayful = isPlayful;
        this.isSmart = isSmart;
    }

    public boolean isFriendly() {
        return isPlayful || isSmart;
    }

    @Override
    public void greet() {
        System.out.println("*water splash*");
    }

    public void perform_jump() {
        if (isPlayful) {
            System.out.println("*Jumps*");
        } else if (isSmart) {
            System.out.println("I will jump... for food.");
        } else {
            System.out.println("No.");
        }
    }
}
