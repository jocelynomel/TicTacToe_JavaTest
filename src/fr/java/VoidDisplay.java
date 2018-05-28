package fr.java;

import fr.java.common.TicTacToeMark;
import fr.java.common.TurnInfo;
import fr.java.interfaces.Display;

/**
 * Void implementation of display (does nothing)
 * 
 * @author jocelynomel
 * 
 */
public class VoidDisplay implements Display
{

	@Override
	public void displayMessage(String string)
	{
	}

	@Override
	public void displayTurn(TurnInfo turnInfo, TicTacToeMark[][] board)
	{
	}
}
