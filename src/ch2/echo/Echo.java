package ch2.echo;

import java.util.Scanner;

public class Echo {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter: ");
		String inputString = scanner.next();
		System.out.println(inputString);
	}

}
