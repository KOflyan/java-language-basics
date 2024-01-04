package lesson4.classwork;

import java.time.LocalDateTime;

public class Transaction {
    final double amount;
    final LocalDateTime date;

    public Transaction(double amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%,.2f€", amount);
    }
}
