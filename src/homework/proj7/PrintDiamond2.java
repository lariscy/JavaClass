package homework.proj7;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.14.2017
 * @dueDate 3.16.2017
 * @description program prints a diamond based on user input
 */
public class PrintDiamond2 {
    
    private static final char[] VALID_DIAMOND_CHARS = {'*', '$'};
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int inputNum = s.nextInt();
        
        int totalRows = inputNum * 2 - 1;
        for (int row = 1; row <= totalRows; row++){
            
            // print spaces
            if ((inputNum > 1) && (row < inputNum) || (row > inputNum)){
                System.out.print(String.format("%" + Math.abs(inputNum - row) + "s", " "));
            }
            
            // print chars
            for (int j = 0; j < ((row > inputNum ? (totalRows - row + 1) : row) * 2 - 1); j++){
                System.out.print(VALID_DIAMOND_CHARS[j % VALID_DIAMOND_CHARS.length]);
            }
            
            System.out.println("");
        }
        
        s.close();
    } // end of main
    
} // end of class
