package fr.java;

import fr.java.common.Coordinates;
import fr.java.common.InvalidCoordinatesException;
import fr.java.common.TicTacToeMark;
import fr.java.common.TurnInfo;
import fr.java.common.TurnResultEnum;
import fr.java.interfaces.Display;

/**
 * Tic-tac-toe game. Display and decision are externalized
 * through interfaces.
 * 
 * @author jocelynomel
 * 
 */
public class TicTacToe
{
	/**
	 * Tic-tic-toe board.
	 */
	private TicTacToeMark[][] cells;

	private Player[] players;

	/**
	 * Creation of a new two-players game.
	 * 
	 * @param p1
	 *            first player
	 * @param p2
	 *            second player
	 */
	public TicTacToe(Player p1, Player p2)
	{
		this.cells = new TicTacToeMark[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				this.cells[i][j] = TicTacToeMark.EMPTY;

		this.players = new Player[2];
		this.players[0] = p1;
		this.players[1] = p2;
	}

	/**
	 * Game loop.
	 */
	public void start()
	{
		for (int turn = 0; turn < 9; turn++)
		{
			Coordinates coords = null;

			TicTacToeMark mark = TicTacToeMark.X;
			if (turn % 2 == 1)
				mark = TicTacToeMark.O;

			int pNum = turn % 2;
			Display display = this.players[pNum].getDisplay();
			display.displayMessage("Player " + (pNum + 1) + " turn");
			while (true)
			{
				display.displayMessage("Coordinates? (eg: 1-1)");
				coords = this.players[pNum].getDecisionMaker().getCoordinates();
				try
				{
					if (coords == null)
						throw new InvalidCoordinatesException();
					this.setMarkAt(coords, mark);
				}
				catch (InvalidCoordinatesException e)
				{
					display.displayMessage("Invalid coordinates, retry");
					continue;
				}
				break;
			}

			TurnInfo turnInfo = null;

			if (this.checkVictory(mark))
				turnInfo = new TurnInfo(pNum + 1, coords, TurnResultEnum.WON);
			else if (turn == 8)
				turnInfo = new TurnInfo(pNum + 1, coords, TurnResultEnum.DRAW);
			else
				turnInfo = new TurnInfo(pNum + 1, coords, TurnResultEnum.NOT_FINISHED);

			this.players[0].getDisplay().displayTurn(turnInfo, this.cells);
			this.players[1].getDisplay().displayTurn(turnInfo, this.cells);

			if (turnInfo.getStatus() != TurnResultEnum.NOT_FINISHED)
				return;
		}
	}

	/**
	 * Checks if a player has won.
	 * 
	 * @param mark
	 *            the mark associated to the player
	 * @return <tt>true</tt> if the player has won, <tt>false</tt> if not.
	 */
	private boolean checkVictory(TicTacToeMark mark)
	{
		for (int i = 0; i < 3; i++)
		{
                        //columns
			if ((this.cells[i][0] == this.cells[i][1]) && (this.cells[i][1] == this.cells[i][2]))
				if (this.cells[i][0] == mark)
					return true;
                        //rows
			if ((this.cells[0][i] == this.cells[1][i]) && (this.cells[1][i] == this.cells[2][i]))
				if (this.cells[0][i] == mark)
					return true;
		}
		if ((this.cells[0][0] == this.cells[1][1]) && (this.cells[1][1] == this.cells[2][2]))
			if (this.cells[0][0] == mark)
				return true;
		if ((this.cells[0][2] == this.cells[1][1]) && (this.cells[1][1] == this.cells[2][0]))
			if (this.cells[0][2] == mark)
				return true;
		return false;
	}

	/**
	 * Checks if coordinates are not out of bounds.
	 * 
	 * @param c
	 *            the coordinates
	 * @return <tt>true</tt> ic coordinates are valid, <tt>false</tt> if they
	 *         are out of bounds.
	 */
	private boolean checkCoordinates(Coordinates c)
	{
		return ((c.getX() >= 1) && (c.getX() <= 3) && (c.getY() >= 1) && (c.getY() <= 3));
	}

	/**
	 * Places a mark at given coordinates.
	 * 
	 * @param c
	 *            the coordinates
	 * @param mark
	 *            the mark
	 * @throws InvalidCoordinatesException
	 *             if coordinates are out of bounds or if there is already a
	 *             mark at given coordinates
	 */
	private void setMarkAt(Coordinates c, TicTacToeMark mark) throws InvalidCoordinatesException
	{
		if (!this.checkCoordinates(c))
			throw new InvalidCoordinatesException();

		if (this.cells[c.getX() - 1][c.getY() - 1] != TicTacToeMark.EMPTY)
			throw new InvalidCoordinatesException();

		this.cells[c.getX() - 1][c.getY() - 1] = mark;
	}
}
