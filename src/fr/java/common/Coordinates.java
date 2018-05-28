package fr.java.common;

/**
 * 
 * A (immutable) couple of coordinates.
 * 
 * @author jocelynomel
 * 
 */
public class Coordinates
{
	/**
	 * x-axis coordinate.
	 */
	private final int x;

	/**
	 * y-axis coordinate.
	 */

	private final int y;

	/**
	 * 
	 * Creates a new couple of coordinates, given x-axis and y-axis values.
	 * 
	 * @param x
	 *            x-axis value
	 * @param y
	 *            y-axis value
	 */
	public Coordinates(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}

	/**
	 * Two coordinates are equivalent if they share the same values for both
	 * x-axis and y-axis.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (this.x != other.x)
			return false;
		if (this.y != other.y)
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "(" + this.x + "," + this.y + ")";
	}
}
