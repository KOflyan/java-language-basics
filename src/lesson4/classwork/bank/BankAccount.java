package lesson4.classwork.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccount {
    private final String iban;
    private double balance = 0;

    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public BankAccount(String iban) {
        this.iban = iban;
    }

    public void deposit(double amount) {
        this.balance += amount;

        this.registerTransaction(true, amount);
    }

    public void withdraw(double amount) throws CannotWithdrawAmountException {

        if (amount > this.balance) {
            throw new CannotWithdrawAmountException();
        }


        this.balance -= amount;

        this.registerTransaction(false, amount);
    }

    private void registerTransaction(
            boolean isDeposit,
            double amount
    ) {
        String sign = isDeposit ? "+" : "-";

        Transaction transaction =
                new Transaction(String.format("%s%s$", sign, amount));

        this.transactions.add(transaction);
    }

    public double getBalance() {
        return this.balance;
    }

    public void transfer(BankAccount toBankAccount, double amount) throws CannotWithdrawAmountException {
        this.withdraw(amount);
        toBankAccount.deposit(amount);


        System.out.printf(
                "Transferred %s amount from %s to %s\n",
                amount,
                this.iban,
                toBankAccount.iban
        );
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.iban, this.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.iban);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount account) {
            return this.iban.equals(account.iban);
        }

        return false;
    }

    public static void main(String[] args) throws CannotWithdrawAmountException {
        BankAccount johnBankAccount = new BankAccount("iban-12345", 1_000);
        BankAccount aliceBankAccount = new BankAccount("iban-54321");

        Person john = new Person("John", 32, johnBankAccount);
        Person alice = new Person("Alice", 28, aliceBankAccount);

        System.out.println(john.getBankAccount());
        System.out.println(alice.getBankAccount());

        john.getBankAccount().transfer(alice.getBankAccount(), 200);

        System.out.println(alice.getBankAccount());

        System.out.println(alice.getBankAccount().getTransactions());
        System.out.println(john.getBankAccount().getTransactions());

        alice.getBankAccount().withdraw(500); // should throw
    }
}
