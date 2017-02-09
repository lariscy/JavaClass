package ch3;

import java.util.Scanner;

public class MovieRating {
	
	private static Scanner s;
	
	enum Ratings { G, PG, PG13, R }
	
	public static void main(String[] args){
		
		s = new Scanner(System.in);
		
		Ratings rating;
		
		System.out.print("enter age: ");
		int age = s.nextInt();
		
		if (age < 7){
			rating = Ratings.G;
		} else if (age >= 7 && age < 14){
			rating = Ratings.PG;
		} else if (age >= 14 && age < 21){
			rating = Ratings.PG13;
		} else {
			rating = Ratings.R;
		}
		
		switch (rating){
			case G:
				System.out.println("G");
				break;
			case PG:
				System.out.println("PG");
				break;
			case PG13:
				System.out.println("PG13");
				break;
			case R:
				System.out.println("R");
				break;
			default:
				System.out.println("Should never hit this");
		}
		
		s.close();
		
	} // end of main

} // end of class
