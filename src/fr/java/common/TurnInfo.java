package fr.java.common;

/**
 * Representation of a turn.
 * 
 * @author jocelynomel
 * 
 */
public class TurnInfo
{
	private final int playerNumber;

	/**
	 * The coordinates where mark has been placed.
	 */
	private final Coordinates coords;

	/**
	 * End of turn status (in progress, won, draw).
	 */
	private final TurnResultEnum status;


	public TurnInfo(int playerNumber, Coordinates coords, TurnResultEnum status)
	{
		this.playerNumber = playerNumber;
		this.coords = coords;
		this.status = status;
	}

	public int getPlayerNumber()
	{
		return this.playerNumber;
	}

	public Coordinates getCoords()
	{
		return this.coords;
	}

	public TurnResultEnum getStatus()
	{
		return this.status;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "" + this.playerNumber + " " + this.coords.getX() + "-" + this.coords.getY() + " " + this.status;
	}
}
