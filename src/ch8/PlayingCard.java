package ch8;

public class PlayingCard {
	
	private Suit suit;
	private Rank rank;
	
	public PlayingCard(Suit suit, Rank rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public Rank getRank(){
		return this.rank;
	}
	
	public boolean isSameRank(PlayingCard otherCard){
		return this.getRank() == otherCard.getRank();
	}
	
	@Override
	public String toString(){
		return this.getRank().getName() + " of " + this.getSuit().getName();
	}

}
