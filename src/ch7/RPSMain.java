package ch7;

import ch7.RPSPlayer.Choices;

public class RPSMain {
	
	public static void main(String[] args){
		RPSComputerPlayer p1 = new RPSComputerPlayer("Computer 1");
		RPSComputerPlayer p2 = new RPSComputerPlayer("Computer 2");
		
		do {
			System.out.print(p1.getName()+": rolls ");
			System.out.println(p1.shoot());
			System.out.print(p2.getName()+": rolls ");
			System.out.println(p2.shoot());
			
			switch (p1.getSelectedOption()){
				case ROCK:
					switch(p2.getSelectedOption()){
						case ROCK:
							// no change
							break;
						case PAPER:
							p2.incScore();
							break;
						case SCISSORS:
							p1.incScore();
							break;
					}
					break;
				case PAPER:
					switch(p2.getSelectedOption()){
					case ROCK:
						p1.incScore();
						break;
					case PAPER:
						// no change
						break;
					case SCISSORS:
						p2.incScore();
						break;
					}
					break;
				case SCISSORS:
					switch(p2.getSelectedOption()){
					case ROCK:
						p2.incScore();
						break;
					case PAPER:
						p1.incScore();
						break;
					case SCISSORS:
						// no change
						break;
					}
					break;
			}
			
			System.out.println(p1.getName()+": "+p1.getScore()+", "+p2.getName()+": "+p2.getScore());
			
		} while (p1.getScore() < 5 && p2.getScore() < 5);
		
		if (p1.getScore() >= 5){
			System.out.println(p1.getName() + " wins");
		} else {
			System.out.println(p2.getName() + " wins");
		}
	}

}
