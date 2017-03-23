package ch8;

public class Main {
	
	public static void main(String[] args){
		PlayingCard card;
		for (Suit s : Suit.values()){
			for (Rank r : Rank.values()){
				card = new PlayingCard(s, r);
				System.out.println(card);
			}
		}
	}

}
