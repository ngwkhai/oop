package run;

import controller.Controller;
import controller.SudokuController;
import models.SudokuModel;

public class StartApp {
    public static void main(String[] args) {
        SudokuModel model = new SudokuModel();
        Controller controller = new SudokuController(model);
    }
}
