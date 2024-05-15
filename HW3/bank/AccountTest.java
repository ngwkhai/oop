package oop.HW3.bank;

public class AccountTest {
    public static void main(String[] args) {
        BankAccount fee = new AccountFee();
        fee.deposit(100);
        fee.withdraw(50);
        fee.endMonth();

        BankAccount dime = new AccountNickleDime();
        dime.deposit(100);
        dime.withdraw(50);
        dime.endMonth();

        BankAccount gam = new AccountGambler();
        gam.deposit(100);
        gam.withdraw(50);
        gam.endMonth();
    }
}
