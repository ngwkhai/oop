package oop.Expression;

public class Main {
    public static void main(String[] args) {
        Expression num1 = new Numeral(1);
        Expression num2 = new Numeral(2);
        Expression num3 = new Square(num2);
        Expression num4 = new Addition(num1, num3);
        System.out.println(num4.toString() + " = " + num4.evaluate());
    }

}
