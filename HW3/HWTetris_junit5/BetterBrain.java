package oop.HW3.HWTetris_junit5;
public class BetterBrain extends DefaultBrain{
	public Brain.Move bestMove(Board board, Piece piece, int limitHeight,Brain.Move move) {
		
		//test
		return move;
		
	}
	public double rateBoard(Board board){
		double score = super.rateBoard(board);
		return (10000 - score);
	}
}
