package ultimate;

//**Both checkMiniBoards and checkUltimateBoards are essentially identical. this one checks for the winner of smaller boards within the ultimate board**

public class checkMiniBoards {
    protected int rowMax;
	protected int colMax;
	protected placeholderClass[][] miniBoard;
    protected int winner;

	public int findWinner() {
		//if winner already declared, return same winner
		if (winner != (0)) {
			return winner;
		}
		//if the winner is not declared, find the winner.
		for (int x = 0; x < rowMax; x++) {
			for (int y = 0; y < colMax; y++) {
				if(checkRow(x, y) == 1 || checkColumn(x, y) == (1) || checkRightDiagonal(x, y) ==(1) || checkLeftDiagonal(x, y) == (1)) {
					winner = 1;
					return winner;
				}
				else if(checkRow(x, y) == 2 || checkColumn(x, y) == (2) || checkRightDiagonal(x, y) == (2) || checkLeftDiagonal(x, y)==(2) ) {
					winner = 2;
					return winner;
				}
			}
		}
		//if there is no winner, return 0
		return 0;
	}

    public int checkRow(int row, int column) {
		if (column - 1 < 0 || column + 1 == colMax) {
			//If checking in the array at these points would cause an out of bounds pointer exception, don't check the row
			return 0;
		}
		else if (miniBoard[row][column-1].getPlaceholder() == miniBoard[row][column].getPlaceholder() && miniBoard[row][column].getPlaceholder() == miniBoard[row][column+1].getPlaceholder()){ //if no invalid data 
			return miniBoard[row][column].getPlaceholder(); //winner of row returned
		}
		else {
			return 0; //no winner found
		}
	}
	
	public int checkColumn(int row, int column) {
		if (row - 1 < 0 || row + 1 == rowMax) {
			//Same as checkRow, but for column
			return 0;
		}
		else if (miniBoard[row-1][column].getPlaceholder() == miniBoard[row][column].getPlaceholder() && miniBoard[row][column].getPlaceholder() == miniBoard[row+1][column].getPlaceholder()){
			return miniBoard[row][column].getPlaceholder(); 
		}
		else {
			return 0; //no winner found
		}
	}
	public int checkLeftDiagonal(int row, int column) {
		//Check diagonal, top left to bottom right
		if (column - 1 < 0 || column + 1 == colMax || row - 1 < 0 || row + 1 == rowMax) {
			return 0;
		}
		else if (miniBoard[row-1][column-1].getPlaceholder() == miniBoard[row][column].getPlaceholder() && miniBoard[row][column].getPlaceholder() == miniBoard[row+1][column+1].getPlaceholder()){
			return miniBoard[row][column].getPlaceholder();
		}
		else {
			return 0;
		}
	}
	public int checkRightDiagonal(int row, int column) {
		//Check diagonal, top right to bottom left
		if (column - 1 < 0 || column + 1 == colMax || row - 1 < 0 || row + 1 == rowMax) {
			return 0;
		}
		else if (miniBoard[row+1][column-1].getPlaceholder() == miniBoard[row][column].getPlaceholder() && miniBoard[row][column].getPlaceholder() == miniBoard[row-1][column+1].getPlaceholder()){
			return miniBoard[row][column].getPlaceholder();
		}
		else {
			return 0;
		}
	}
}
