package homework.proj11;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.12.2017
 * @dueDate 4.13.2017
 * @description Travel Mileage Calculator
 */
public class TMRTextDriver {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TMRTextView textView = new TMRTextView(keyboard);
        textView.play();
        keyboard.close();
    } // end main
    
} // end class
