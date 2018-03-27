package com;

import java.text.DecimalFormat;

/**
 * PawnSolver
 * @author ranjankumar
 * @version 1.0.0
 */
public class PawnSolver {

	int[][] solutionMatrix;
	int path = 0;

	/**
	 * Constructor to initialize the solution Matrix with default 0
	 * @param chequerBoardSize
	 */
	public PawnSolver(int chequerBoardSize) {
		solutionMatrix = new int[chequerBoardSize][chequerBoardSize];
		for (int i = 0; i < chequerBoardSize; i++) {
			for (int j = 0; j < chequerBoardSize; j++) {
				solutionMatrix[i][j] = 0;
			}
		}
	}

	/**
	 * solvePawnProblem
	 * @return the final state of problem
	 * Initial Indexes assumption
	 * INDEX_X = 0
	 * INDEX_Y = 0
	 */
	public String solvePawnProblem() {
		if (pathConditionIfPossible(0, 0, 0, solutionMatrix.length)) {
			printSolution();
			return "POSSIBLE";
		} else {
			return "NOT POSSIBLE";
		}
	}

	/**
	 * pathConditionIfPossible
	 * @param row
	 * @param column
	 * @param cellIndexCovered
	 * @param chequerBoardSize
	 * @return
	 */
	public boolean pathConditionIfPossible(int row, int column, int cellIndexCovered, int chequerBoardSize) {
		// check if current is not used already
		if (solutionMatrix[row][column] != 0) {
			return false;
		}
		// mark the current cell is as used
		solutionMatrix[row][column] = path++;
		
		//Solved the problem if we reached here
		if (cellIndexCovered == chequerBoardSize * chequerBoardSize - 1) {
			return true;
		}
		
		// try to solve the rest of the problem recursively
		// traverse towards WEST by 3 position
		if (canTraverse(row, column - 3, chequerBoardSize) && pathConditionIfPossible(row, column - 3, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards EAST by 3 position
		if (canTraverse(row, column + 3, chequerBoardSize) && pathConditionIfPossible(row, column + 3, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards NORTH by 3 position
		if (canTraverse(row - 3, column, chequerBoardSize) && pathConditionIfPossible(row - 3, column, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards SOUTH by 3 position
		if (canTraverse(row + 3, column, chequerBoardSize) && pathConditionIfPossible(row + 3, column, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards NORTH-WEST by 2 position
		if (canTraverse(row - 2, column - 2, chequerBoardSize) && pathConditionIfPossible(row - 2, column - 2, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards NORTH-EAST by 2 position
		if (canTraverse(row - 2, column + 2, chequerBoardSize) && pathConditionIfPossible(row - 2, column + 2, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards SOUTH-WEST by 2 position
		if (canTraverse(row + 2, column - 2, chequerBoardSize) && pathConditionIfPossible(row + 2, column - 2, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// traverse towards SOUTH-EAST by 2 position
		if (canTraverse(row + 2, column + 2, chequerBoardSize) && pathConditionIfPossible(row + 2, column + 2, cellIndexCovered + 1, chequerBoardSize)) {
			return true;
		}
		// if we reach here means nothing has worked , 
		// Need to BACKTRACK
		solutionMatrix[row][column] = 0;
		path--;
		return false;

	}

	public boolean canTraverse(int row, int column, int N) {
		if (row >= 0 && column >= 0 && row < N && column < N) {
			return true;
		}
		return false;
	}

	public void printSolution() {
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < solutionMatrix.length; i++) {
			for (int j = 0; j < solutionMatrix.length; j++) {
				System.out.print("   " + twodigits.format(solutionMatrix[i][j]));
			}
			System.out.println();
		}
	}
}
