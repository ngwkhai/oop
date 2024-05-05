package controller;

import models.SudokuModel;
import views.SudokuGame;

public class SudokuController implements Controller {
	SudokuModel model;
	SudokuGame view;
	public SudokuController (SudokuModel model) {
		this.model = model;
		view = new SudokuGame(this, model);
	}
	@Override
	public void makeNewGame() {
		model.makeNewGame();
	}

}