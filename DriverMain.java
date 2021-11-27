package ultimate;

import java.util.Scanner;
/*
	Rose Hami
	CS 2336.OW1
	Professor Borazjany
	4/29/21

	Analysis: The program is designed to mimic the Ultimate Tic Tac Toe game using Java. This game is
			  fairly simple to follow along. It has 9 boards, with each of those boards there is a 
			  mini board that is inside of each square. The aim of the game is this: play tic tac toe, 
			  but in order to win, you have to win 3 mini boards in the correct order (vertical, 
			  horizontal, or diagonal. just like in regular tic tac toe. One thing that is important to
			  note is that the board you play on next is determined by the computers' previous move.
			  This way it keeps the game fun, yet a bit challenging at times to beat the computer.

	Design: During the semester we learned how to code a tic tac toe game, but much simpler than this. 
			My code is designed by using a combination of loops and child/parent classes by using the 
			extends keyword. DriverMain starts the code, ultimateGame gets info from user and sets their
			input (X or O) and then the computer sets their piece. The code runs in a loop & calls the 
			designated functions in order to fill the board and declare a winner. The loop stops
			once a winner has been determined.
*/
public class DriverMain {

	public static void main(String[] args) {
		//starts run 
		ultimateGame game = new ultimateGame();
		game.start();
	}
}
