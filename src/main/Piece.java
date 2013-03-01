package main;

/**
 * A Checkers Piece. Holds information on piece colour, and King status.
 * <p>
 * King status determines whether the piece can move bidirectionally.
 * 
 * @param king
 *            Boolean of king status
 * @param Colour
 *            enum of colour (BLACK("B")/RED("R"))
 * @author James Sullivan
 */

public class Piece {
	private boolean king = false;
	private Colour colour;

	/**
	 * Constructor using a Colour enumeration
	 * 
	 * @param aColour
	 *            A Colour enumeration
	 */
	public Piece(Colour aColour) {
		this.colour = aColour;
	}

	/**
	 * Constructor using an integer parameter to set colour Pre-Condition: int
	 * aColour is 0(BLACK) or 1(RED)
	 */
	public Piece(int aColour) {
		if (aColour == 0 || aColour == 1) {
			this.colour = Colour.values()[aColour]; // Enum.values()[ordinal]
													// will return the
													// corresponding enumeration
		} else {
			this.colour = null;
			System.out.print("Invalid colour");
		}

	}

	/**
	 * Mutator method to King-a- a piece.
	 * <p>
	 * Post-Condition: Piece becomes a King.
	 */
	public void makeKing() {
		king = true;
	}

	/**
	 * Accessor method to see King status.
	 * 
	 * @return true if the piece is a King.
	 */
	public boolean isKing() {
		return king;
	}

	/**
	 * Accessor method to return the Piece's colour.
	 * 
	 * @return Colour enumeration of the piece
	 */
	public Colour getColour() {
		return this.colour;
	}

	public String toString() {
		return colour.toString() + " is King: " + king;
	}

}