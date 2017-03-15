package homework.proj8;

/**
 * @author Steven
 */
public class Scorecard {
    
    public static final int NUM_OF_OPTIONS = 14;
    public static final int SCORE_FOR_BONUS = 35;
    public static final int SCORE_FOR_FULL_HOUSE = 25;
    public static final int SCORE_FOR_LOW_STRAIGHT = 30;
    public static final int SCORE_FOR_HIGH_STRAIGHT = 40;
    public static final int SCORE_FOR_YAHTZEE = 50;
    
    private final ScoreOption[] scoreOptions;

    public Scorecard() {
        scoreOptions = new ScoreOption[NUM_OF_OPTIONS];
        this.initOptions();
    }

    private void initOptions() {
        scoreOptions[0] = new ScoreOption(0, "Pass");
        scoreOptions[1] = new ScoreOption(1, "Ones");
        scoreOptions[2] = new ScoreOption(2, "Twos");
        scoreOptions[3] = new ScoreOption(3, "Threes");
        scoreOptions[4] = new ScoreOption(4, "Fours");
        scoreOptions[5] = new ScoreOption(5, "Fives");
        scoreOptions[6] = new ScoreOption(6, "Sixes");
        scoreOptions[7] = new ScoreOption(7, "3 of a kind");
        scoreOptions[8] = new ScoreOption(8, "4 of a kind");
        scoreOptions[9] = new ScoreOption(9, "Full House");
        scoreOptions[10] = new ScoreOption(10, "Low Straight");
        scoreOptions[11] = new ScoreOption(11, "High Straight");
        scoreOptions[12] = new ScoreOption(12, "Yahtzee");
        scoreOptions[13] = new ScoreOption(13, "Chance");
    }
    
    public ScoreOption getScoreOption(int index){
        return scoreOptions[index];
    }
    
    public int getBonus(){
        int bonusValue = 0;
        if (this.getSubTotal() >= 63){
            bonusValue = Scorecard.SCORE_FOR_BONUS;
        }
        return bonusValue;
    }
    
    public int getSubTotal(){
        int total = 0;
        for (int i = 1; i < 7; i++){
            total += this.getScoreOption(i).getScore();
        }
        return total;
    }
    
    public int getSubTotal1(){
        return this.getSubTotal() + this.getBonus();
    }
    
    public int getSubTotal2(){
        int total = 0;
        for (int i = 7; i < 14; i++){
            total += this.getScoreOption(i).getScore();
        }
        return total;
    }
    
    public int getGrandTotal(){
        return this.getSubTotal1() + this.getSubTotal2();
    }
    
    public boolean isScoreboardComplete(){
        boolean isComplete = true;
        for (int i = 1; i < scoreOptions.length; i++){
            if (!scoreOptions[i].isPicked()){
                isComplete = false;
                break;
            }
        }
        return isComplete;
    }

    public void printCurrentScorecard(){
        this.printScorecardLine(
                scoreOptions[1].getId() + ")", scoreOptions[1].getName() + ":", scoreOptions[1].getScore(),
                scoreOptions[7].getId() + ")", scoreOptions[7].getName() + ":", scoreOptions[7].getScore());
        this.printScorecardLine(
                scoreOptions[2].getId() + ")", scoreOptions[2].getName() + ":", scoreOptions[2].getScore(),
                scoreOptions[8].getId() + ")", scoreOptions[8].getName() + ":", scoreOptions[8].getScore());
        this.printScorecardLine(
                scoreOptions[3].getId() + ")", scoreOptions[3].getName() + ":", scoreOptions[3].getScore(),
                scoreOptions[9].getId() + ")", scoreOptions[9].getName() + ":", scoreOptions[9].getScore());
        this.printScorecardLine(
                scoreOptions[4].getId() + ")", scoreOptions[4].getName() + ":", scoreOptions[4].getScore(),
                scoreOptions[10].getId() + ")", scoreOptions[10].getName() + ":", scoreOptions[10].getScore());
        this.printScorecardLine(
                scoreOptions[5].getId() + ")", scoreOptions[5].getName() + ":", scoreOptions[5].getScore(),
                scoreOptions[11].getId() + ")", scoreOptions[11].getName() + ":", scoreOptions[11].getScore());
        this.printScorecardLine(
                scoreOptions[6].getId() + ")", scoreOptions[6].getName() + ":", scoreOptions[6].getScore(),
                scoreOptions[12].getId() + ")", scoreOptions[12].getName() + ":", scoreOptions[12].getScore());
        this.printScorecardLine(
                "", "Subtotal:", this.getSubTotal(),
                scoreOptions[13].getId() + ")", scoreOptions[13].getName() + ":", scoreOptions[13].getScore());
        this.printScorecardLine(
                "", "Bonus:", this.getBonus(),
                "", "Subtotal 2:", this.getSubTotal2());
        this.printScorecardLine(
                "", "Subtotal 1:", this.getSubTotal1(),
                "", "Subtotal 1:", this.getSubTotal1());
        this.printScorecardLine(
                "", "", "",
                "", "Grand Total:", this.getGrandTotal());
    }
    
    private void printScorecardLine(Object... args){
        System.out.format("%-3s%11s%3s   ~~   %-3s%15s%3s\n", args);
    }
    
    public boolean isValidOption(int index){
        return !this.getScoreOption(index).isPicked();
    }

    public int getValidOptionsLeft() {
        int numOfValidOptionsLeft = 0;
        for (ScoreOption option : scoreOptions) {
            if (!option.isPicked()) {
                numOfValidOptionsLeft++;
            }
        }
        return numOfValidOptionsLeft;
    }
    
    public void printValidOptions(){
        for (ScoreOption option : scoreOptions){
            if (!option.isPicked()){
                System.out.println(option.getId() + ") " + option.getName());
            }
        }
    }

}
