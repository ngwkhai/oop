package oop.HW3.bank;

public class AccountNickleDime extends BankAccount {
    private static int wdNumTransaction = 0;
    public void charge() {
        withdraw(0.5 * wdNumTransaction);
    }
    public void withdraw(double amount) {
        super.deposit(amount);
        wdNumTransaction++;
    }
    public AccountNickleDime(double amount) {
        super(amount);
    }
    public AccountNickleDime() {
    }
}
