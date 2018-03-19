import java.awt.*;


public class CondMazeLab extends Maze {

	public void step() {
		if (puss.isFacingGully()) {
			puss.jump();
		}
		else if (puss.isFacingWall()) {
			puss.right();
			if (puss.isFacingWall()) {
				puss.right();
				puss.right();
			}
		}
		else {
			if (puss.isFacingMud()) {
				puss.putOnBoots();
			}
			else if (puss.isFacingDog()) {
				puss.startTipToe();
			}
			puss.forward();
			//puss.stopTipToe();
			//puss.takeOffBoots();
		}
		// ADD YOUR CODE HERE
		// to make PussInBoots take a SINGLE STEP.
		//
		// Note: NO LOOPING STATEMENTS ARE NEEDED!
		//
		// The code we've provided repeatedly calls
		// this method to make PussInBoots take multiple
		// steps through the maze.
	}		

	public CondMazeLab() {
		super(true);
	}

	public static void main(String[] args) {
		CondMazeLab myMaze = new CondMazeLab();	
	}
}
