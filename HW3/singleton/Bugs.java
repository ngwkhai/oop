package oop.HW3.singleton;
import java.util.Random;
public class Bugs{
    TextGraphics mapbug = TextGraphics.getInstance();
    public Bugs(int n, int w, int h) {
        Random rand = new Random();
        mapbug.init(w, h);
        char[] bug = new char[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            if (x > 26) {
                x = x % 26;
            }
            bug[i] = (char) (x + 'a');
        }
        for (int i = 0; i < n; i++) {
            boolean check = true;
            int x = rand.nextInt(15);
            int y = rand.nextInt(15);
            while (check) {
                x = rand.nextInt(15);
                y = rand.nextInt(15);
                if (mapbug.getGrid()[x][y] == ' ') {
                    check = false;
                }
            }
            mapbug.drawPoint(bug[i], x, y);
        }

    }
    public static void main(String[] args) {
        Bugs bugs = new Bugs(5, 15, 15);
        int step = 1;
        while (step > 0) {
            bugs.mapbug.render();
            step--;
        }
    }
}
