package fr.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.java.common.Coordinates;
import fr.java.interfaces.DecisionMaker;

/**
 * Console input-based implementation of decision maker.
 * 
 * @author jocelynomel
 * 
 */
public class ConsoleDecisionMaker implements DecisionMaker
{

	@Override
	public Coordinates getCoordinates()
	{
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			line = br.readLine();
			if (line == null)
				throw new IOException();
		}
		catch (IOException e)
		{
			return null;
		}
		try
		{
			int x = Integer.parseInt(line.substring(0, line.indexOf("-")));
			int y = Integer.parseInt(line.substring(line.indexOf("-") + 1));
			return new Coordinates(x, y);
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
