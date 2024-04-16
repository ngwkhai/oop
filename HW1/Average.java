package oop.HW1;
import oop.StdIn;
import oop.StdOut;
public class Average {
    public static void main(String[] args) {
        int count = 0;
        double sum = 0.0;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        double average = sum / count;

        StdOut.println("Average is " + average);
    }
}