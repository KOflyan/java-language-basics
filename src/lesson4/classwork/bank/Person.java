package lesson4.classwork.bank;

public class Person {
    private String name;
    private int age;
    private BankAccount bankAccount = null;

    public Person(String name, int age, BankAccount bankAccount) {
        this.name = name;
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
