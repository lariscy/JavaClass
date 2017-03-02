package ch5;

import java.util.Random;

public class Die {
	
	private int currentValue;
	private int numOfSides;
	private final Random r = new Random();
	
	public static void main(String[] args){
		Die me = new Die(6);
		for (int i = 0; i<50; i++){
			System.out.println(me.roll());
		}
	}
	
	public Die(){
		this(6);
	}
	
	public Die(int numOfSides){
		this.setNumOfSides(numOfSides);
	}
	
	public int roll(){
		this.setCurrentValue(this.r.nextInt(this.numOfSides) + 1); 
		return this.getCurrentValue();
	}

	public int getCurrentValue() {
		return this.currentValue;
	}

	private void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public int getNumOfSides() {
		return this.numOfSides;
	}

	private void setNumOfSides(int numOfSides) {
		this.numOfSides = numOfSides;
	}

}
