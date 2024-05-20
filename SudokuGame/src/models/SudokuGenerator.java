package models;

import java.util.Random;

public class SudokuGenerator {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;
    private int[][] board = new int[SIZE][SIZE];

    public SudokuGenerator() {
    }
    public void creatBroad() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = random.nextInt(9);
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != EMPTY) {
                    int temp = board[i][j];
                    board[i][j] = EMPTY;
                    if (isValid(i, j, temp)) {
                        board[i][j] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void makeNewGame() {
        creatBroad();
        generateBoard();
        printBoard();
    }

    public void generateBoard() {
        solveBoard(0, 0);
    }

    private boolean solveBoard(int row, int col) {
        if (row == SIZE) {
            row = 0;
            if (++col == SIZE) {
                return true;
            }
        }
        if (board[row][col] != EMPTY) {
            return solveBoard(row + 1, col);
        }
        for (int num = 1; num <= SIZE; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solveBoard(row + 1, col)) {
                    return true;
                }
            }
        }
        board[row][col] = EMPTY;
        return false;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow + i][boxCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    public void copyBoard(int[][] state) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = state[i][j];
            }
        }
    }
    public int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuGenerator sudoku = new SudokuGenerator();
        sudoku.makeNewGame();
        sudoku.printBoard();
    }
}

