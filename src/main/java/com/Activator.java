package com;

/**
 * Activator class : Trigger point
 * 
 * @author ranjankumar
 */
public class Activator {

	public static void main(String[] args) {

		String chequerBoardSize = ConfigurationLoader.configurationLoader().getProperty("chequerBoardSize", "10");
		System.out.println(
				"************************************************ Activating Weird Pawn Problem ************************************************");
		System.out.println("chequerBoardSize->" + chequerBoardSize);

		PawnSolver pawnSolver = new PawnSolver(Integer.parseInt(chequerBoardSize));
		System.out.println(pawnSolver.solvePawnProblem());

		System.out.println(
				"************************************************ Terminating Weird Pawn Problem ************************************************");
	}
}
