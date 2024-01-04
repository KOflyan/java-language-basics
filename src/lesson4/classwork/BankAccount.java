package lesson4.classwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public final String iban;
    private double balance;
    private final List<Transaction> history;

    public BankAccount(String iban) {
        this.iban = iban;
        this.balance = 0;
        this.history = new ArrayList<>();
    }

    public void deposit(double amount) {
        history.add(new Transaction(amount, LocalDateTime.now()));
        balance += amount;
    }
    public void withdraw(double amount) {
        history.add(new Transaction(amount, LocalDateTime.now()));
        balance -= amount;
    }
    public double getBalance() { return balance; }

    public List<Transaction> getHistory() {
        return history;
    }

    public void transfer(BankAccount account, double amount) {
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount account) {
            return this.iban.equals(account.iban) && this.getBalance() == account.balance;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return iban;
    }
}

