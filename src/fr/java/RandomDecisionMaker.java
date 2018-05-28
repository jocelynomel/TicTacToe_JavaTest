package fr.java;

import java.util.Random;

import fr.java.common.Coordinates;
import fr.java.interfaces.DecisionMaker;

/**
 * Random-based implementation of decision maker
 * 
 * @author jocelynomel
 * 
 */
public class RandomDecisionMaker implements DecisionMaker
{
	/**
	 * RNG.
	 */
	private final Random random;

	
	public RandomDecisionMaker()
	{
		this.random = new Random();
	}

	@Override
	public Coordinates getCoordinates()
	{
		int x = this.random.nextInt(3);
		int y = this.random.nextInt(3);
		return new Coordinates(x + 1, y + 1);
	}
}
