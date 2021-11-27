package ultimate;

import java.util.Random;

public class setPlayerChoices {
	private int player;
	private int computer;
	
	//these functions set the choice of the player and computer
	//also sets the random number for computer
	public setPlayerChoices(int player, int computer) {
		this.player = player;
		this.computer = computer;
	}
	public int getPlayer() {
		return this.player;
	}
	public int getComputer() {
		return this.computer;
	}
	public int randNum(int max) {
		Random rand = new Random();
		return rand.nextInt(max);
	}
}
