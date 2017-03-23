package ch8;

import java.awt.Color;

public enum Suit {
	
	HEARTS("Hearts", Color.RED),
	DIAMONDS("Diamonds", Color.BLUE),
	CLUBS("Clubs", Color.GREEN),
	SPADES("Spades", Color.BLACK),
	STARS("Stars", Color.YELLOW);
	
	private final String name;
	private final Color color;
	
	private Suit(String name, Color color){
		this.name = name;
		this. color = color;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Color getColor(){
		return this.color;
	}

}
