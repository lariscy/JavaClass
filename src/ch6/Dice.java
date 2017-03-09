package ch6;

import ch5.Die;

public class Dice {
	
	private Die die1;
	private Die die2;
	
	public static void main(String[] args){
		
	}
	
	public Dice(){
		this(6);
	}
	
	public Dice(int numOfSides){
		this.die1 = new Die(numOfSides);
		this.die2 = new Die(numOfSides);
	}
	
	public void roll(){
		this.die1.roll();
		this.die2.roll();
	}
	
	public int getCurrentValue(){
		return (this.die1.getCurrentValue() + this.die2.getCurrentValue());
	}

}
