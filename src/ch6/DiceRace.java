package ch6;

import java.util.Scanner;

public class DiceRace {
	
	
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter p1 name: ");
		DicePlayer p1 = new DicePlayer(s.next());
		
		System.out.print("Enter p2 name: ");
		DicePlayer p2 = new DicePlayer(s.next());
		
		Dice dice = new Dice();
		
		do {
			dice.roll();
			p2.updateScore(dice.getCurrentValue());
			
			dice.roll();
			p1.updateScore(dice.getCurrentValue());
			
			System.out.println("     S");
			for (int i = 0; i<25; i++){
				System.out.print("-");
			}
			
		} while (p1.getScore() < 100 && p2.getScore() < 100);
		
		s.close();
	}

}
