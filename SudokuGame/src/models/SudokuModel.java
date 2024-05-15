package models;

public class SudokuModel {
    SudokuGenerator sudokuGenerator;
    public SudokuModel() {
        sudokuGenerator = new SudokuGenerator();
    }
    public void makeNewGame() {
        sudokuGenerator.makeNewGame();
    }
    public SudokuGenerator getSudokuGenerator() {
        return sudokuGenerator;
    }
    public static void main(String[] args) {
        SudokuModel s = new SudokuModel();
        s.makeNewGame();
    }
}
