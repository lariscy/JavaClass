package ch3;

import java.util.Scanner;

public class PrintAsterisks {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("how many: ");
		int num = s.nextInt();
		
		switch (num){
			case 3:
				System.out.print("*");
			case 2:
				System.out.print("*");
			case 1:
				System.out.print("*");
		}
		
		s.close();
		
	}

}
