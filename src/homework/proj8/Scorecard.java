package homework.proj8;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 3.20.2017
 * @dueDate 3.23.2017
 * @description text based Yahtzee game
 */
public class Scorecard {
    
    // constants
    public static final int NUM_OF_OPTIONS = 14;
    public static final int SCORE_FOR_BONUS = 35;
    public static final int SCORE_FOR_FULL_HOUSE = 25;
    public static final int SCORE_FOR_LOW_STRAIGHT = 30;
    public static final int SCORE_FOR_HIGH_STRAIGHT = 40;
    public static final int SCORE_FOR_YAHTZEE = 50;
    
    // instance variables
    private final ScoreOption[] scoreOptions;

    // constructor
    public Scorecard() {
        this.scoreOptions = new ScoreOption[NUM_OF_OPTIONS];
        this.initOptions();
    } // end of constructor

    private void initOptions() {
        this.scoreOptions[0] = new ScoreOption(0, "Pass");
        this.scoreOptions[1] = new ScoreOption(1, "Ones");
        this.scoreOptions[2] = new ScoreOption(2, "Twos");
        this.scoreOptions[3] = new ScoreOption(3, "Threes");
        this.scoreOptions[4] = new ScoreOption(4, "Fours");
        this.scoreOptions[5] = new ScoreOption(5, "Fives");
        this.scoreOptions[6] = new ScoreOption(6, "Sixes");
        this.scoreOptions[7] = new ScoreOption(7, "3 of a kind");
        this.scoreOptions[8] = new ScoreOption(8, "4 of a kind");
        this.scoreOptions[9] = new ScoreOption(9, "Full House");
        this.scoreOptions[10] = new ScoreOption(10, "Low Straight");
        this.scoreOptions[11] = new ScoreOption(11, "High Straight");
        this.scoreOptions[12] = new ScoreOption(12, "Yahtzee");
        this.scoreOptions[13] = new ScoreOption(13, "Chance");
    } // end of initOptions
    
    public ScoreOption getScoreOption(int index){
        return this.scoreOptions[index];
    } // end of getScoreOption
    
    public int getBonus(){
        int bonusValue = 0;
        if (this.getSubTotal() >= 63){
            bonusValue = Scorecard.SCORE_FOR_BONUS;
        } // end if
        return bonusValue;
    } //end of getBonus
    
    public int getSubTotal(){
        int total = 0;
        for (int i = 1; i < 7; i++){
            total += this.getScoreOption(i).getScore();
        } //end for
        return total;
    } // end of getSubTotal
    
    public int getSubTotal1(){
        return this.getSubTotal() + this.getBonus();
    } // end of getSubTotal1
    
    public int getSubTotal2(){
        int total = 0;
        for (int i = 7; i < 14; i++){
            total += this.getScoreOption(i).getScore();
        } // end for
        return total;
    } // end of getSubTotal2
    
    public int getGrandTotal(){
        return this.getSubTotal1() + this.getSubTotal2();
    } // end of getGrandTotal
    
    public boolean isScoreboardComplete(){
        boolean isComplete = true;
        for (int i = 1; i < this.scoreOptions.length; i++){
            if (!this.scoreOptions[i].isPicked()){
                isComplete = false;
                break;
            } // end if
        } // end for
        return isComplete;
    } // end of isScoreboardComplete

    public void printCurrentScorecard(){
        this.printScorecardLine(
                this.scoreOptions[1].getId() + ")", this.scoreOptions[1].getName() + ":", this.scoreOptions[1].getScore(),
                this.scoreOptions[7].getId() + ")", this.scoreOptions[7].getName() + ":", this.scoreOptions[7].getScore());
        this.printScorecardLine(
                this.scoreOptions[2].getId() + ")", this.scoreOptions[2].getName() + ":", this.scoreOptions[2].getScore(),
                this.scoreOptions[8].getId() + ")", this.scoreOptions[8].getName() + ":", this.scoreOptions[8].getScore());
        this.printScorecardLine(
                this.scoreOptions[3].getId() + ")", this.scoreOptions[3].getName() + ":", this.scoreOptions[3].getScore(),
                this.scoreOptions[9].getId() + ")", this.scoreOptions[9].getName() + ":", this.scoreOptions[9].getScore());
        this.printScorecardLine(
                this.scoreOptions[4].getId() + ")", this.scoreOptions[4].getName() + ":", this.scoreOptions[4].getScore(),
                this.scoreOptions[10].getId() + ")", this.scoreOptions[10].getName() + ":", this.scoreOptions[10].getScore());
        this.printScorecardLine(
                this.scoreOptions[5].getId() + ")", this.scoreOptions[5].getName() + ":", this.scoreOptions[5].getScore(),
                this.scoreOptions[11].getId() + ")", this.scoreOptions[11].getName() + ":", this.scoreOptions[11].getScore());
        this.printScorecardLine(
                this.scoreOptions[6].getId() + ")", this.scoreOptions[6].getName() + ":", this.scoreOptions[6].getScore(),
                this.scoreOptions[12].getId() + ")", this.scoreOptions[12].getName() + ":", this.scoreOptions[12].getScore());
        this.printScorecardLine(
                "", "Subtotal:", this.getSubTotal(),
                this.scoreOptions[13].getId() + ")", this.scoreOptions[13].getName() + ":", this.scoreOptions[13].getScore());
        this.printScorecardLine(
                "", "Bonus:", this.getBonus(),
                "", "Subtotal 2:", this.getSubTotal2());
        this.printScorecardLine(
                "", "Subtotal 1:", this.getSubTotal1(),
                "", "Subtotal 1:", this.getSubTotal1());
        this.printScorecardLine(
                "", "", "",
                "", "Grand Total:", this.getGrandTotal());
    } // end of printCurrentScorecard
    
    private void printScorecardLine(Object... args){
        System.out.format("%-3s%11s%3s   ~~   %-3s%15s%3s\n", args);
    } // end of printScorecardLine
    
    public boolean isValidOption(int index){
        return !this.getScoreOption(index).isPicked();
    } // end of isValidOption

    public int getValidOptionsLeft() {
        int numOfValidOptionsLeft = 0;
        for (ScoreOption option : this.scoreOptions) {
            if (!option.isPicked()) {
                numOfValidOptionsLeft++;
            } // end if
        } // end for
        return numOfValidOptionsLeft;
    } // end of getValidOptionsLeft
    
    public void printValidOptions(){
        for (ScoreOption option : this.scoreOptions){
            if (!option.isPicked()){
                System.out.println(option.getId() + ") " + option.getName());
            } // end if
        } // end for
    } // end of printValidOptions

} // end class
