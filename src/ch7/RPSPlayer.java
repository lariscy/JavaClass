package ch7;

public class RPSPlayer {
	
	public static enum Choices {
		ROCK, PAPER, SCISSORS;
	}
	
	private String name;
	private Choices selectedOption;
	private int score;
	
	public RPSPlayer(String name){
		this(name, 0);
	}
	
	public RPSPlayer(String name, int score){
		this.setname(name);
		this.setScore(score);
	}
	
	private void setname(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setSelectedOption(Choices selectedOption){
		this.selectedOption = selectedOption;
	}
	
	public Choices getSelectedOption(){
		return this.selectedOption;
	}
	
	private void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void incScore(){
		this.setScore(this.getScore() + 1);
	}
	
	public void decScore(){
		this.setScore(this.getScore() - 1);
	}

}
