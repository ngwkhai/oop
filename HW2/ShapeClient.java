package oop.HW2;

public class ShapeClient {
    public static void main(String[] args) {
        Shape a = new Shape("0 0 0 1 1 1 1 0");
        Shape b = new Shape("10 10 10 11 11 11 11 10");
        Shape c = new Shape("0.5 0.5 0.5 -10 1.5 0");
        Shape d = new Shape("0.5 0.5 0.75 0.75 0.75 0.2");

        System.out.println("a crosses b:" + a.cross(b));
        System.out.println("a crosses c:" + a.cross(c));
        System.out.println("a crosses d:" + a.cross(d));

        System.out.println("a encircles b:" + a.encircle(b));
        System.out.println("a encircles c:" + a.encircle(c));
        System.out.println("a encircles d:" + a.encircle(d));
    }
}
