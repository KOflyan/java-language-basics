package lesson5.classwork.packagecenter;

public class Customer {
    /**
     * Customer priority.
     * 0 < priority < 1000
     */
    private int priority;
    /**
     * Customer name.
     */
    private String name;
    /**
     * Customer address.
     */
    private String address;
    public Customer(int priority, String name, String address) {
        this.priority = priority;
        this.name = name;
        this.address = address;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static boolean isValid(Customer c) {
        return c != null &&
                c.address != null && !c.address.isEmpty() &&
                c.name != null && !c.name.isEmpty() &&
                c.priority >= 0 && c.priority <= 1000;
    }
}
