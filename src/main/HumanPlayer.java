package main;
import java.util.Scanner;

import userInterface.view.MouseHandler;

/**
 * A human Player Subclass. Contains methods to take user input and turn it into a Location.
 * @author james
 *
 */
public class HumanPlayer extends Player {
	private Scanner scanner = new Scanner(System.in);
	MouseHandler handler;

	/**
	 * Constructor method to call the Player super's constructor given some parameters.
	 * @param aColour The Colour of the HumanPlayer to be made.
	 * @param board The instance of the Board.
	 */
	public HumanPlayer(Colour aColour,Board board) {
		super(aColour,board);
		isHuman = true;
	}
	
	public void setStart(Location start){
		if(start.inBounds() == false){
			System.out.println("That is an invalid location.");
		} else if (board.checkSquare(start) == null) {
			System.out.println("There is no piece there.");
		} else if (board.checkSquare(start).getColour() != this.playerColour) {
			System.out.println("That is not your piece to move.");
		}
		
		currentStart = start;
	}
	
	public void setEnd(Location end){
		if(end.inBounds() == false){
			System.out.println("That is an invalid location.");
		} else if (board.checkSquare(end) != null) {
			System.out.println("That square is already occupied.");
		}
		currentEnd = end;
	}

}