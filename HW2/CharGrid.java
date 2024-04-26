package oop.HW2;

import java.util.Scanner;

public class CharGrid {
    private char[][] grid;

    public int charArea(char ch) {
        int x1 = grid.length + 1, y1 = grid[0].length + 1, x2 = -1, y2 = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ch) {
                    if (x1 > i) x1 = i;
                    if (y1 > j) y1 = j;
                    if (x2 < i) x2 = i;
                    if (y2 < j) y2 = j;
                }
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new char[4][4];
        for (int i = 0; i < 3; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 4; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        char ch = sc.next().charAt(0);
        System.out.println(charArea(ch));
    }
}
