package fr.java;

import fr.java.interfaces.DecisionMaker;
import fr.java.interfaces.Display;


public class Player
{
	private final Display display;

	private final DecisionMaker decisionMaker;

	public Player(Display display, DecisionMaker decisionMaker)
	{
		super();
		this.display = display;
		this.decisionMaker = decisionMaker;
	}

	public Display getDisplay()
	{
		return this.display;
	}

	public DecisionMaker getDecisionMaker()
	{
		return this.decisionMaker;
	}
}
