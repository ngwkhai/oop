package oop.HW3.bank;

public class BankAccount {
    private double current = 0;
    private int NumTransaction = 0;
    public void charge() {
    }
    public void deposit(double amount) {
        current += amount;
        NumTransaction++;
    }
    public void withdraw(double amount) {
        current -= amount;
        NumTransaction++;
    }
    public BankAccount() {
        current = 0;
    }
    public BankAccount(double initBalance) {
        current = initBalance;
    }
    public void endMonth() {
        charge();
        System.out.println("Current balance: " + current);
        System.out.println("Total transactions: " + NumTransaction);
        NumTransaction = 0;
    }
}
