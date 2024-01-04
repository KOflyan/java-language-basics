package lesson5.classwork.packagecenter;

public class PremiumPackage extends Package{
    private int priority;
    public PremiumPackage(int priority, String packageNumber, int width, int height) {
        super(packageNumber, width, height);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
