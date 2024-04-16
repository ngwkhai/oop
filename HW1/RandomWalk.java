package oop.HW1;
import oop.StdDraw;
import oop.StdOut;

public class RandomWalk {
    public static int x = 0, y = 0;
    public static int steps = 0;
    public static void sett() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x, y, 0.45);
//            double r = Math.random();
//            if      (r < 0.25) x--;
//            else if (r < 0.50) x++;
//            else if (r < 0.75) y--;
//            else if (r < 1.00) y++;
        steps++;
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledSquare(x, y, 0.45);
        StdDraw.show();
        StdDraw.pause(40);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        for (int m = 0; m <= n; m++) {
            for (;y <= m; y++) {
                sett();
            }
            for (;x >= -m; x--) {
                sett();
            }
            for (;y >= -m; y--) {
                sett();
            }
            for (;x <= m; x++) {
                sett();
            }
        }
        StdOut.println("Total steps = " + steps);
    }

}