// BadBrain.java
/**
 A joke implementation based on DefaultBrain --
 plays very, very badly by recommending the
 opposite of the real brain.
*/
package oop.HW3.HWTetris_junit5;
public class BadBrain extends DefaultBrain {
	public double rateBoard(Board board) {
		double score = super.rateBoard(board);
		return(10000 - score);
	}
}
