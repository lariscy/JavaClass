package cl12;

import java.util.Random;

public class Die {
	
	private int currentValue;
	private int numberOfSides;
	private Random random;
	
	public static final int DEFAULT_NUM_OF_SIDES = 6;
	
	public Die() {
		this(Die.DEFAULT_NUM_OF_SIDES);
	}
	
	public Die(int numOfSides){
		this.setCurrentValue(0);
		this.setNumberOfSides(numOfSides);
		this.setRandom(new Random());
	}
	
	public int roll(){
		this.setCurrentValue(this.getRandom().nextInt(this.getNumberOfSides()) + 1);
		return this.getCurrentValue();
	}
	
	public int getCurrentValue(){
		return this.currentValue;
	}
	
	private void setCurrentValue(int currentValue){
		this.currentValue = currentValue;
	}
	
	public int getNumberOfSides(){
		return this.numberOfSides;
	}
	
	private void setNumberOfSides(int numberOfSides){
		this.numberOfSides = numberOfSides;
	}
	
	private Random getRandom(){
		return this.random;
	}
	
	private void setRandom(Random random){
		this.random = random;
	}

}
