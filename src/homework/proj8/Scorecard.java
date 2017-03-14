package homework.proj8;

/**
 * @author Steven Lariscy
 */
public class Scorecard {

    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeOfKind;
    private int fourOfKind;
    private int fullHouse;
    private int lowStraight;
    private int highStraight;
    private int yahtzee;
    private int chance;

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public int getThrees() {
        return threes;
    }

    public void setThrees(int threes) {
        this.threes = threes;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getThreeOfKind() {
        return threeOfKind;
    }

    public void setThreeOfKind(int threeOfKind) {
        this.threeOfKind = threeOfKind;
    }

    public int getFourOfKind() {
        return fourOfKind;
    }

    public void setFourOfKind(int fourOfKind) {
        this.fourOfKind = fourOfKind;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    public int getLowStraight() {
        return lowStraight;
    }

    public void setLowStraight(int lowStraight) {
        this.lowStraight = lowStraight;
    }

    public int getHighStraight() {
        return highStraight;
    }

    public void setHighStraight(int highStraight) {
        this.highStraight = highStraight;
    }

    public int getYahtzee() {
        return yahtzee;
    }

    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
    public int getBonus(){
        int bonus = 0;
        if (this.getSubTotal() >= 63){
            bonus = 35;
        }
        return bonus;
    }
    
    public int getSubTotal(){
        return this.getOnes() + this.getTwos() + this.getThrees() + 
                this.getFours() + this.getFives() + this.getSixes();
    }
    
    public int getSubTotal1(){
        return this.getSubTotal() + this.getBonus();
    }
    
    public int getSubTotal2(){
        return this.getThreeOfKind() + this.getFourOfKind() + 
                this.getFullHouse() + this.getLowStraight() +
                this.getHighStraight() + this.getYahtzee() + this.getChance();
    }
    
    public int getGrandTotal(){
        return this.getSubTotal1() + this.getSubTotal2();
    }
    
    public boolean scoreRoll(ScoreType score, Die[] dice){
        boolean wasAccepted = false;
        
        
        
        return wasAccepted;
    }

    public void printScoreCard() {
        this.printTableRow(1+")", ScoreType.ONES.getName()+":", this.getOnes(),
                7+")", ScoreType.THREE_OF_KIND.getName()+":", this.getThreeOfKind());
        this.printTableRow(2+")", ScoreType.TWOS.getName()+":", this.getTwos(),
                8+")", ScoreType.FOUR_OF_KIND.getName()+":", this.getFourOfKind());
        this.printTableRow(3+")", ScoreType.THREES.getName()+":", this.getThrees(),
                9+")", ScoreType.FULL_HOUSE.getName()+":", this.getFullHouse());
        this.printTableRow(4+")", ScoreType.FOURS.getName()+":", this.getFours(),
                10+")", ScoreType.LOW_STRAIGHT.getName()+":", this.getLowStraight());
        this.printTableRow(5+")", ScoreType.FIVES.getName()+":", this.getFives(),
                11+")", ScoreType.HIGH_STRAIGHT.getName()+":", this.getHighStraight());
        this.printTableRow(6+")", ScoreType.SIXES.getName()+":", this.getSixes(),
                12+")", ScoreType.YAHTZEE.getName()+":", this.getYahtzee());
        this.printTableRow("", "Subtotal:", this.getSubTotal(),
                13+")", ScoreType.CHANCE.getName()+":", this.getChance());
        this.printTableRow("", "Bonus:", this.getBonus(),
                "", "SubTotal 2:", this.getSubTotal2());
        this.printTableRow("", "SubTotal 1:", this.getSubTotal1(),
                "", "SubTotal 1:", this.getSubTotal1());
        this.printTableRow("", "", "",
                "", "Grand Total:", this.getGrandTotal());
    }
    
    private void printTableRow(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6){
        System.out.format("%-3s%11s%3s%10s%-3s%15s%3s\n", arg1, arg2, arg3, "", arg4, arg5, arg6);
    }

}
