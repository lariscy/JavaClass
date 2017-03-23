package ch8;

public enum Rank {
	
	DEUCE("Deuce"), TREY("Trey"), FOUR("Four"), 
	FIVE("Five"), SIX("Six"), SEVEN("Seven"), 
	EIGHT("Eight"), NINE("Nine"), TEN("Ten"), 
	JACK("Jack"), QUEEN("Queen"), KING("King"), 
	ACE("Ace");
	
	private final String name;
	
	private Rank(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
