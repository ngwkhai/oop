package oop.HW3.singleton;

public class TextGraphics {
     private char[][] grid = new char[10][10];
     private TextGraphics() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public static TextGraphics getInstance() {
        return new TextGraphics();
    }
    public void init(int width, int height) {
        grid = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public void drawPoint(char c, int x, int y) {
        grid[x][y] = c;
    }
    public void drawLine(char c, int x1, int y1, int x2, int y2) {
        grid[x1][y1] = c;
        grid[x2][y2] = c;

        while (x1 != x2 && y1 != y2) {
            if (Math.abs(x1 - x2) > Math.abs(y1 - y2)) {
                if (x1 < x2) {
                    x1++;
                } else {
                    x1--;
                }
            } else if (Math.abs(y1 - y2) > Math.abs(x1 - x2)) {
                if (y1 < y2) {
                    y1++;
                } else {
                    y1--;
                }
            } else {
                if (x1 < x2) {
                    x1++;
                } else {
                    x1--;
                }
                if (y1 < y2) {
                    y1++;
                } else {
                    y1--;
                }
            }
            grid[x1][y1] = c;
        }
    }
    public void fillRectPoint(char c, int x, int y, int width, int height) {
        for (int i = x; i < x + height; i++) {
            for (int j = y; j < y + width; j++) {
                grid[i][j] = c;
            }
        }
    }
    public void render() {
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
    public char[][] getGrid() {
         return grid;
    }
    public static void main(String[] args) {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1,1);
        graphics.drawLine('*', 1,1, 2, 9);
        graphics.fillRectPoint('o', 5, 5, 3, 2);
        graphics.render();
    }
}
