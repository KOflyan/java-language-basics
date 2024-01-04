package lesson5.classwork.packagecenter;

public class Package {
    /**
     * Package number printed on page.
     */
    protected String packageNumber;
    /**
     * Package width in cm.
     */
    protected int width;
    /**
     * Package height in cm.
     */
    protected int height;
    /**
     * Package sender.
     */
    protected Customer sender;
    /**
     * Package receiver.
     */
    protected Customer receiver;

    /**
     * Package constructor.
     *
     * @param packageNumber Package number printed on package
     * @param width         Package width in cm
     * @param height        Package height in cm
     */
    public Package(String packageNumber, int width, int height) {
        this.packageNumber = packageNumber;
        this.width = width;
        this.height = height;
    }

    public String getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    protected int getTotalPriority() {
        return sender.getPriority() + receiver.getPriority();
    }
}
