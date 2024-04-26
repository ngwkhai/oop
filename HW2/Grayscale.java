package oop.HW2;
import oop.Picture;
import java.awt.Color;

public class Grayscale {
    public void main(String[] args) {
        Picture pic = new Picture(args[0]);
        for (int col = 0; col < pic.width(); col++) {
            for (int row = 0; row < pic.height(); row++) {
                Color color = pic.get(col, row);
                Color gray = Luminance.toGray(color);
                pic.set(col, row, gray);
            }
        }
        pic.show();
    }
}
