package oop.HW2;

import java.util.Scanner;

public class TetrisGrid {
    private static boolean grid[][];
    private static int row, col;
    public static void getGrid() {
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }
    public static void clearRows() {
        for (int y = 0; y < col; y++) {
            int cnt = 0;
            for (int x = 0; x < row; x++) {
                if (grid[x][y]) {
                    cnt++;
                }
            }
            if (cnt == row) {
                for (int i = 0; i < row; i++) {
                    for (int j = y; j < col - 1; j++) {
                        grid[i][j] = grid[i][j + 1];
                    }
                }
                col--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        grid = new boolean[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                grid[x][y] = sc.nextBoolean();
            }
        }
        clearRows();
        getGrid();
    }
}
