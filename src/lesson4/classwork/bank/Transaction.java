package lesson4.classwork.bank;

import java.util.Date;

public class Transaction {

    private String description;
    private final Date executionDate;

    public Transaction(String description) {
        this.description = description;
        this.executionDate = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("(%s): %s", this.executionDate, this.description);
    }
}
