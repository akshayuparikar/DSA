public class FourQueenProblem {
	final int chessboardsize = 4;

	// check if the Queen can be places at the said ('row', 'col') location
	boolean placeTheQueenAtLocation(int arr[][], int row, int col) {
		int i, j;

		// horizontally left
		for (i = 0; i < col; i++)
			if (arr[row][i] == 1)
				return false;

		// diagonally upwards left
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (arr[i][j] == 1)
				return false;

		// diagonally downwards left
		for (i = row, j = col; j >= 0 && i < chessboardsize; i++, j--)
			if (arr[i][j] == 1)
				return false;

		return true;
	}

	// identify if the Queen can be placed at column 'col'
	boolean selectLocationforQueen(int arr[][], int col) {
		// termination condition: all 4 Queens placed successfully
		if (col >= chessboardsize)
			return true;

		// check if the Queen can be placed at the ith row of the given column
		for (int i = 0; i < chessboardsize; i++) {
			// check if the Queen can be placed at arr[i][col]
			if (placeTheQueenAtLocation(arr, i, col)) {
				
				arr[i][col] = 1;  // placed the Queen at ith row of col-th column

				if (selectLocationforQueen(arr, col + 1) == true) {
					return true;
				}

				// backtrack if the Queen can't be placed at ith row of col-th column
				arr[i][col] = 0;
			}
		}
		return false;
	}

	// Initializing the board with all zeroes, indicating empty board with no Queens on it
	boolean initializingBoard() {
		int arr[][] = { { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 },
						{ 0, 0, 0, 0 },
						{ 0, 0, 0, 0 } };

		if (selectLocationforQueen(arr, 0) == false) {
			System.out.print("Failed to place the 4 Queens on the board!");
			return false;
		}

		displayTheQueensOnTheBoard(arr);
		return true;
	}

	// display the placement of the Queens on the 4X4 chess board
	void displayTheQueensOnTheBoard(int arr[][]) {
		for (int i = 0; i < chessboardsize; i++) {
			for (int j = 0; j < chessboardsize; j++)
				System.out.print(" " + arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		FourQueenProblem Queen = new FourQueenProblem();
		Queen.initializingBoard();
	}
}

