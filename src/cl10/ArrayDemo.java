package cl10;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
	
	private static Scanner keyboard;
	private static int[] grade;
	
	public static void main(String[] args){
		keyboard = new Scanner(System.in);
		
		System.out.print("Enter the number of grades: ");
		grade = new int[keyboard.nextInt()];
		
		inputGrades(grade);
		
		keyboard.close();
	}

	private static void inputGrades(int[] grade) {
		System.out.println("Enter the grades.");
		for (int i=0; i<grade.length; i++){
			System.out.print("Grade #"+i+": ");
			grade[i]=keyboard.nextInt();
		}
	}
	
	private static void outputGrades(int[] grades){
		Arrays.asList(grades).stream().forEach(System.out::println);
	}

}
