package ultimate;

public class ultimateBoard extends printBoard {

	private int boardSpace;
	//this gets the ultimate board
	public miniBoards getBoard(int row, int col) {
		return ultimateBoard[row][col];
	}

	//holds values in array for checking.
	
	public ultimateBoard() {
		ultimateBoard = new miniBoards[3][3];
		maxRow = 3;
		maxCol = 3;
		boardSpace = 9;
		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				ultimateBoard[row][col] = new miniBoards();
			}
		}
	}
	public boolean fullBoard() {
		//for loop runs through to check if board is full.

		for (int row = 0; row < 3; row ++) {
			for (int col = 0; col < 3; col++) {

				//if the board is not full, then return false.
				if (!ultimateBoard[row][col].fullBoard()) {
					return false;
				}
			}
		}
		//If the boards are full, return true.
		return true;
	}
}
