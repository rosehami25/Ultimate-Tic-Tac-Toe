package ultimate;

public class miniBoards extends checkMiniBoards{
	private int boardSpace;
	
	public miniBoards() {
		//delcaring variables
		miniBoard = new placeholderClass[3][3];
		rowMax = 3;
		colMax = 3;
		winner = 0;
		boardSpace = 9;
		for (int row = 0; row < rowMax; row++) {
			for (int col = 0; col < colMax; col++) {
				//Assigns "-" to all contents of miniBoard
				miniBoard[row][col] = new placeholderClass();
			}
		}
	}
	
	//this function places move into miniBoard array
	public void move(int row, int col, int placeholder) {
		miniBoard[row][col].setPlaceholder(placeholder);
		boardSpace--;
	}
	//this function checks if the spot is available on the miniBoard
	public boolean checkAvailability(int row, int col) {
		return miniBoard[row][col].available();
	}

	//returns the placeholder in the array
	public int placeholder(int row, int col) {
		return miniBoard[row][col].getPlaceholder();
	}
	//this function returns if the board is full or not.
	public boolean fullBoard() {
		if (boardSpace == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	

	

	
	
	
}