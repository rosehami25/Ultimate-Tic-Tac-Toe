package ultimate;

//**Both checkMiniBoards and checkUltimateBoards are essentially identical. this one checks for the winner of the ultimate board**

public class checkUltimateBoard {
    protected int maxRow;
	protected int maxCol;
	protected miniBoards[][] ultimateBoard;
	
    
    public int findWinner() {
		//Checks  if there is a winner on 3 separate boards that line up
		for (int x = 0; x < maxRow; x++) {
			for (int y = 0; y < maxCol; y++) {
				if(checkRow(x, y)==(1) || checkColumn(x, y)==(1) || checkDiagonal1(x, y)==(1) || checkDiagonal2(x, y)==(1)) {
					return 1;
				}
				else if(checkRow(x, y)==(2) || checkColumn(x, y)==(2) || checkDiagonal1(x, y)==(2) || checkDiagonal2(x, y)==(2)) {
					return 2;
				}
			}
		}
		//If not, return this
		return 0;
	}
	
    public int checkRow(int row, int col) {
		if (col - 1 < 0 || col + 1 == maxCol) {
			//If checking in the array at these points would cause an out of bounds pointer exception, don't check the row
			return 0;
		}
		else if (ultimateBoard[row][col-1].findWinner() == ultimateBoard[row][col].findWinner() && 
						ultimateBoard[row][col].findWinner() == ultimateBoard[row][col+1].findWinner()){ //if no invalid data 
			return ultimateBoard[row][col].findWinner(); //winner of row returned
		}
		else {
			return 0; //no winner found
		}
	}
	
	//Same as checkRow, but for col
	public int checkColumn(int row, int col) {
		if (row - 1 < 0 || row + 1 == maxRow) {
			return 0;
		}
		else if (ultimateBoard[row-1][col].findWinner() == ultimateBoard[row][col].findWinner() && 
						ultimateBoard[row][col].findWinner() == ultimateBoard[row+1][col].findWinner()){

			return ultimateBoard[row][col].findWinner(); 
		}
		else {
			return 0; //no winner found
		}
	}

	//this function will check for diagonal winner from top left to bottom right.
	public int checkDiagonal2(int row, int col) {
		//Check diagonal, top left to bottom right
		if (col - 1 < 0 || col + 1 == maxCol || row - 1 < 0 || row + 1 == maxRow) {
			return 0;
		}
		else if (ultimateBoard[row-1][col-1].findWinner() == ultimateBoard[row][col].findWinner() && 
						ultimateBoard[row][col].findWinner() == ultimateBoard[row+1][col+1].findWinner()){
			return ultimateBoard[row][col].findWinner();
		}
		else {
			return 0;
		}
	}

	//this function checks for diagonal winner from top right to bottom left.
	public int checkDiagonal1(int row, int col) {
		if (col - 1 < 0 || col + 1 == maxCol || row - 1 < 0 || row + 1 == maxRow) {
			return 0;
		}
		else if (ultimateBoard[row+1][col-1].findWinner() == ultimateBoard[row][col].findWinner() && 
						ultimateBoard[row][col].findWinner() == ultimateBoard[row-1][col+1].findWinner()){
			return ultimateBoard[row][col].findWinner();
		}
		else {
			return 0;
		}
	}
}
