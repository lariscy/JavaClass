package homework.ch3;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @project P84830
 * @description Project 3 - Two option menu program
 */
public class MenuProgram {
    
    private final Scanner S = new Scanner(System.in);
    
    enum Days {
        DAY1("First"), 
        DAY2("Second"), 
        DAY3("Third"), 
        DAY4("Fourth"), 
        DAY5("Fifth"), 
        DAY6("Sixth"), 
        DAY7("Seventh"), 
        DAY8("Eighth"), 
        DAY9("Nineth"), 
        DAY10("Tenth"), 
        DAY11("Eleventh"), 
        DAY12("Twelfth");
        
        private String wordValue;
        
        Days(String wordValue){
            this.wordValue = wordValue;
        }
        
        public String getWordValue(){
            return wordValue;
        }
    }
    
    public static void main(String[] args) {
        MenuProgram me = new MenuProgram();
        me.run();
    }
    
    private void run(){
        printMenu();
        
        int menuChoice = getUserInput();
        switch (menuChoice) {
            case 1:
                doOption1();
                break;
            case 2:
                doOption2();
                break;
            default:
                System.out.println("Incorrect option. Exiting!");
                break;
        }
        
        S.close();
    }
    
    private void printMenu(){
        System.out.println("Menu Options");
        System.out.println("  1 - Course Placement");
        System.out.println("  2 - The Twelve Days of Christmas");
        System.out.print("\nChoose Option: ");
    }
    
    private void doOption1(){
        System.out.print("\nEnter Compass Reading score: ");
        int readingScore = getUserInput();
        System.out.print("\nEnter Compass Writing score: ");
        int writingScore = getUserInput();
        
        if (readingScore < 36){
            System.out.println("Unacceptable Reading Score");
            if (writingScore == 20 || writingScore == 30){
                System.out.println("Suggested Writing Class: Must complete ENG032 first");
            }
        } else if (readingScore > 35 && readingScore < 61) {
            System.out.println("Suggested Reading Class: RDG032");
            if (writingScore == 10){
                System.out.println("Suggested Writing Class: ENG032");
            } else if (writingScore == 20 || writingScore == 30){
                System.out.println("Suggested Writing Class: Must complete ENG032 first");
            }
        } else if (readingScore > 60 && readingScore < 80) {
            System.out.println("Suggested Reading Class: RDG100");
            if (writingScore == 10){
                System.out.println("Suggested Writing Class: ENG032");
            } else if (writingScore == 20){
                System.out.println("Suggested Writing Class: ENG100");
            } else if (writingScore == 30){
                System.out.println("Suggested Writing Class: Must complete RDG100 before taking ENG101");
            }
        } else if (readingScore > 79 && readingScore < 88) {
            System.out.println("Suggested Reading Class: RDG101");
            if (writingScore == 10){
                System.out.println("Suggested Writing Class: ENG032");
            } else if (writingScore == 20){
                System.out.println("Suggested Writing Class: ENG100");
            } else if (writingScore == 30){
                System.out.println("Suggested Writing Class: ENG101");
            }
        } else if (readingScore > 87) {
            System.out.println("No Reading Course Required");
            if (writingScore == 10){
                System.out.println("Suggested Writing Class: ENG032");
            } else if (writingScore == 20){
                System.out.println("Suggested Writing Class: ENG100");
            } else if (writingScore == 30){
                System.out.println("Suggested Writing Class: ENG101");
            }
        }
    }
    
    private void doOption2(){
        System.out.print("\nEnter Day (1-12): ");
        int daysChoice = getUserInput();
        Days day = getDayFromInt(daysChoice);
        
        if (day == null) {
            System.out.println("Invalid input. Exiting!");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("On the %s day of Christmas my true love sent to me ", day.getWordValue()));
        switch (day){
            case DAY12:
                sb.append("Twelve Drummers Drumming, ");
            case DAY11:
                sb.append("Eleven Pipers Piping, ");
            case DAY10:
                sb.append("Ten Lods a-Leaping, ");
            case DAY9:
                sb.append("Nine Ladies Dancing, ");
            case DAY8:
                sb.append("Eight Maids a-Milking, ");
            case DAY7:
                sb.append("Seven Swans a-Swimming, ");
            case DAY6:
                sb.append("Six Geese a-Laying, ");
            case DAY5:
                sb.append("Five Gold Rings, ");
            case DAY4:
                sb.append("Four Calling Birds, ");
            case DAY3:
                sb.append("Three French Hens, ");
            case DAY2:
                sb.append("Two Turtle Doves, and ");
            case DAY1:
                sb.append("a Partridge in a Pear Tree.");
        }
        
        System.out.println(sb.toString());
    }
    
    private Days getDayFromInt(int i){
        switch (i) {
            case 1:
                return Days.DAY1;
            case 2:
                return Days.DAY2;
            case 3:
                return Days.DAY3;
            case 4:
                return Days.DAY4;
            case 5:
                return Days.DAY5;
            case 6:
                return Days.DAY6;
            case 7:
                return Days.DAY7;
            case 8: 
                return Days.DAY8;
            case 9:
                return Days.DAY9;
            case 10:
                return Days.DAY10;
            case 11:
                return Days.DAY11;
            case 12:
                return Days.DAY12;
        }
        return null; // invalid input
    }
    
    private int getUserInput(){
        String inputString = S.next();
        int inputInt = 0;
        try {
            inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException ex){
            System.out.print("Invalid option choosen: "+inputString);
            System.out.println(", [Exception: "+ex+"]");
            //ex.printStackTrace();
            System.exit(0);
        }
        return inputInt;
    }
    
}
