# Lesson 4 exercises

1. Create a class called `Cat` which simulates a "usual" cat:
```
Cat(String name, String owner)

void roll() -- prints "*rolling*"
void greet() -- print "meow!"
void speak() -- print "I cannot!"
String getName() -- sets cat name
String setName() -- returns cat name.
String getOwner() -- returns owner name
```

2. Create a class called `BankAccount`. 
Bank account should have iban. 
In the class, define following methods:

```
public void deposit(double amount) - deposits amount to the account
public void withdraw(double amount) - withdraws amount to the account
public void getBalance() - returns the current balance
public String toString() - returns account iban
public boolean equals()
public int hashCode()
```
3. Create a class named `Person`. 
Person should have a name and age, and can have a bank account.
Add a method `transfer(BankAccount bankAccount, double amount)` to the `BankAccount` class, 
which would transfer money between bank accounts.
4. Create a class named `Transaction`.
Transaction should have a description (e.g. `-10.52$`) and execution date.
Use this class to track history of transfers between bank accounts. 
(hint: each `BankAccount` should have a list of transactions).
Create some accounts, holders, and do some transfers. Print out the data.





