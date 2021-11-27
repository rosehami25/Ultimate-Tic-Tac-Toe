package ultimate;

public class printBoard extends checkUltimateBoard{
    private String getString(int player){

		//this switch statement sets 0, 1, and 2 to their respected characters for correct output.

        String result = " ";
        switch(player){
            case 0:
                result = "*";
                break;
            case 1:
                result =  "X";
                break;
            case 2:
                result =  "O";
                break;

        }
        return result;
    }
    
	//this function prints the board.

    public void print() {
		for (int row = 0; row < 9; row++) {
			if (row%3 == 0){
				System.out.println();
			}
			for (int col = 0; col < 9; col++) {
				if (col%3 == 0) {
					if (row%3 == 0) {
						
						//Prints what Board is being played on
						System.out.print(String.format("%3s%-11s%s", "|","Board " + (row/3) + " " + (col/3) ,
												getString(ultimateBoard[row/3][col/3].placeholder(row%3, col%3))));
					}
					else if (row % 3 == 1) {
						//if winner exists, print. if winner does not exist, print regularly

						if (ultimateBoard[row/3][col/3].findWinner() != 0) {
							System.out.print(String.format("%3s%-11s%s", "|", getString(ultimateBoard[row/3][col/3].findWinner()) + " won" 
                                    ,getString(ultimateBoard[row/3][col/3].placeholder(row%3, col%3))));
						}
						else {
							System.out.print(String.format("%3s%12s", "|", getString(ultimateBoard[row/3][col/3].placeholder(row%3, col%3))));
						}
					}
					else {
						//If there is no result from the if statment, print regularly.
						System.out.print(String.format("%3s%12s", "|", getString(ultimateBoard[row/3][col/3].placeholder(row%3, col%3))));
					}
				}
				else {
					System.out.print(String.format("%4s", getString(ultimateBoard[row/3][col/3].placeholder(row%3, col%3))));
				}
				if (col == 8) {
					
					System.out.print(String.format("%3s", "|"));
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
