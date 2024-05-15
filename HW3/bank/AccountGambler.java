package oop.HW3.bank;
import java.util.Random;
public class AccountGambler extends BankAccount{
    Random rand = new Random();
    public AccountGambler(double amount) {
        super(amount);
    }
    public AccountGambler() {
    }
    public void withdraw(double amount) {
        double a = rand.nextDouble();
        if (a <= 0.49) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount * 2);
        }
    }
}
