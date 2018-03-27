# weird-pawn-problem

Approach:
* Create a solution matrix of the same structure as chequerBoard.
* Start from 0,0 and index = 0. (index will represent the no of cells has been covered as a result of  pawn movement)
* Check current cell is not already used if not then mark that cell (start with 0 and keep incrementing it, it will show us the path for the pawn based on condition).
* Check if index = N*N-1, means Pawn has covered all the cells. return true and print the solution matrix.
* Now try to solve rest of the problem recursively by making index +1. Check all 8 directions. (Pawn can move to 8 cells from its current position as mentioned in the problem.) Refer the problem statement for detail.
* If none of the 8 recursive calls return true, BACKTRACK and undo the changes ( put 0 to corresponding cell in solution matrix) and return false.

Steps To run the code:

1. Configure the chequer board size , say 7, in the config.properties
2. Run Activator.java class
3. Output will be shown as “POSSIBLE” or “NOT POSSIBLE” for the current board size .

Assumptions:
  1. Took (0,0) as initial position of pawn for the current also.

https://github.com/ranjankumar03/weird-pawn-problem.git
