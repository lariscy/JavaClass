package ch7;

import java.util.Random;

public class RPSComputerPlayer extends RPSPlayer {
	
	private Random rand;

	public RPSComputerPlayer(){
		this("Computer");
	}
	
	public RPSComputerPlayer(String name) {
		super(name);
		this.rand = new Random();
	}
	
	public Choices shoot(){
		switch(this.rand.nextInt(3)){
			case 0:
				this.setSelectedOption(Choices.ROCK);
				break;
			case 1:
				this.setSelectedOption(Choices.PAPER);
				break;
			case 2:
				this.setSelectedOption(Choices.SCISSORS);
				break;
		}
		return this.getSelectedOption();
	}

}
