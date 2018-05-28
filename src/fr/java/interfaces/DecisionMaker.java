package fr.java.interfaces;

import fr.java.common.Coordinates;

/**
 * General contract for retrieving coordinates where to play.
 * 
 * @author jocelynomel
 * 
 */
public interface DecisionMaker
{
	/**
	 * @return the choisen coordinates for the mark
	 */
	public Coordinates getCoordinates();

}
