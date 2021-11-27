package ultimate;

import java.util.Scanner;

public class ultimateGame {
	public ultimateBoard board;
	public setPlayerChoices player;
	
	public void start() {
		//Creates the SuperBoard
		board = new ultimateBoard();
		//Determines who's playing X and who O
		declarePlayer();
		//The actual game
		startGame();
	}
	
	public void declarePlayer() {
		//Asks player what they want to play as. Error checks for any input that's not an x or o
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Ultimate Tic Tac Toe!");
		System.out.println();
		System.out.println("Please choose if you want to be X or O. X goes first.");
		String result = input.nextLine().toUpperCase();
		
		switch(result){
			case "X":
				player = new setPlayerChoices(1,2);
				break;
			case "O":	
				player = new setPlayerChoices(2, 1);
				break;
			default:
				System.out.println("This is not a valid option! Please choose again.");
				declarePlayer();
		}
	}
	
	public void startGame() {
		Scanner input = new Scanner(System.in);
		int row, col;
		int boardRow = -1;
		int boardCol = -1;
		boolean turn = true;

		//print blank board
		board.print();
		
		//this if statement sets turn to true if it is the players turn. if it is not, then it is false.
		if (player.getPlayer() == (1)) {
			turn = true;
		}
		else {
			turn = false;
		}
		
		//all game inputs are ran through the do loop until a winner is declared.
		do {
			if (turn == true) {
				//if it is within bounds
				if ((boardRow == -1 && boardCol == -1) || board.getBoard(boardRow, boardCol).fullBoard()){
					//this do loop runs until a valid input is made.
					do {
						System.out.println("Pick any board to play on. For example, typing 1 2 starts you on board 1 2. ");
						boardRow = input.nextInt();
						boardCol = input.nextInt();
						if (boardRow < 0 || boardCol < 0 || boardRow >= 3 || boardCol >= 3 || board.getBoard(boardRow, boardCol).fullBoard()) {
							//If invalid input
							System.out.println("This is not a valid option! Please choose again.");
						}
					} while (boardRow < 0 || boardCol < 0 || boardRow >= 3 || boardCol >= 3 || board.getBoard(boardRow, boardCol).fullBoard());
				}
				else {
					System.out.println("Board in play: " + boardRow + " " + boardCol);
				}

				//this do loop runs until a valid input is made.
				do {
					System.out.println("Choose where you want to place your mark. For example, typing 1 2 puts your mark on spot 1 2 in the mini board");
					
					row = input.nextInt();
					col = input.nextInt();
						if (row < 0 || col < 0 || row >= 3 || col >= 3 || board.getBoard(boardRow, boardCol).checkAvailability(row, col) == false) {
						System.out.println("This is not a valid move! Please choose again.");
					}
				} while (row < 0 || col < 0 || row >= 3 || col >= 3 || board.getBoard(boardRow, boardCol).checkAvailability(row, col) == false);
				//Makes the move, then changes the next board being played on based on the move
				board.getBoard(boardRow, boardCol).move(row, col, player.getPlayer());
				boardRow = row;
				boardCol = col;
				turn = false;
			}
			//this else statement runs if it is the computers turn.
			else {
				if ((boardRow == -1 && boardCol == -1) || board.getBoard(boardRow, boardCol).fullBoard()){  //bound checking
					//uses random number to decide what board the computer plays on.
					do {
						boardRow = player.randNum(3);
						boardCol = player.randNum(3);
					} while (board.getBoard(boardRow, boardCol).fullBoard());
					System.out.println("The computer selects board: " + boardRow + " " + boardCol);
				}
				
				do {
					//Generates random board to play on until one is a valid board
					row = player.randNum(3);
					col = player.randNum(3);
				} while (board.getBoard(boardRow, boardCol).checkAvailability(row, col) == false);
				
				//move is made & changes the board that is being played on to the previous move made.
				
				System.out.println("Computer moves to board: " + row + " " + col);
				board.getBoard(boardRow, boardCol).move(row, col, player.getComputer());
				boardRow = row;
				boardCol = col;
				turn = true;
			}
			board.print();
		} while(board.fullBoard() == false && board.findWinner()==(0));  //loop runs until the board is full and there is a winner declared.

		
		//winner statements.
		
		if (board.findWinner()==(1)) {
			System.out.println("Congratulations! X wins!");
		}
		else if (board.findWinner()==(2)) {
			System.out.println("Congratulations! O wins!");
		}
		else {
			System.out.println("The game ended in a tie!");
		}
	}
}
