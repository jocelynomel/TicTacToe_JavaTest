package fr.java.interfaces;

import fr.java.common.TicTacToeMark;
import fr.java.common.TurnInfo;

/**
 * General contract for displaying in-game information
 * 
 * @author jocelynomel
 * 
 */
public interface Display
{
	public void displayMessage(String message);

	/**
	 * Displays turn (board and brief).
	 * 
	 * @param turninfo
	 *            turn info
	 * @param board
	 *            the board
	 */
	public void displayTurn(TurnInfo turninfo, TicTacToeMark[][] board);

}
