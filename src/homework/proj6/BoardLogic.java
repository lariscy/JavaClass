package homework.proj6;

/**
 * This is a utility class to assist with player movement on special
 * board pieces.
 * 
 * @author Steven Lariscy
 */
public class BoardLogic {
    
    public static final int MAX_BOARD_NUMBER = 100;
    
    /**
     * Logic for special (chutes and ladders) game squares.
     * 
     * @param squareNum the current square after spinning
     * @return the new square after any modifications from landing on a chute
     *         or ladder
     */
    public static int getNextSqure(int squareNum){
        switch(squareNum){
            // ladders (jump ahead)
            case 1:
                return 38;
            case 4:
                return 14;
            case 9:
                return 31;
            case 21:
                return 42;
            case 28:
                return 84;
            case 36:
                return 44;
            case 51:
                return 67;
            case 71:
                return 91;
            case 80:
                return 100;
            
            // chutes (fall back)
            case 16:
                return 6;
            case 48:
                return 26;
            case 49:
                return 11;
            case 56:
                return 53;
            case 62:
                return 16;
            case 64:
                return 60;
            case 87:
                return 24;
            case 93:
                return 73;
            case 95:
                return 75;
            case 98:
                return 78;
            
            // otherwise return the same number (no changes)
            default:
                return squareNum;
        }
    } // end of getNextSqure
    
} // end of class
