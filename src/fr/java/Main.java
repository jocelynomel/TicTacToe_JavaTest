package fr.java;

import fr.java.interfaces.DecisionMaker;
import fr.java.interfaces.Display;

public class Main
{
	public static void main(String[] args)
	{
		Display d1 = new VoidDisplay();
		Display d2 = new ConsoleDisplay();

		DecisionMaker dm1 = new RandomDecisionMaker();
		DecisionMaker dm2 = new ConsoleDecisionMaker();

		Player p1 = new Player(d1, dm1);
		Player p2 = new Player(d2, dm2);

		new TicTacToe(p1, p2).start();
	}
}
