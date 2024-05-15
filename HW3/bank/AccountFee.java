package oop.HW3.bank;

public class AccountFee extends BankAccount{
    static double CHARGE = 5;
    @Override
    public void charge() {
        withdraw(CHARGE);
    }
    public AccountFee(double amount) {
        super(amount);
    }
    public AccountFee() {
    }
}
