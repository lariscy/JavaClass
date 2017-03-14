package homework.proj8;

/**
 * @author Steven Lariscy
 */
public enum ScoreType {
    
    ONES("Ones"),
    TWOS("Twos"),
    THREES("Threes"),
    FOURS("Fours"),
    FIVES("Fives"),
    SIXES("Sixes"),
    
    THREE_OF_KIND("3 of a kind"),
    FOUR_OF_KIND("4 of a kind"),
    FULL_HOUSE("Full house"),
    LOW_STRAIGHT("Low Straight"),
    HIGH_STRAIGHT("High Straight"),
    YAHTZEE("Yahtzee"),
    CHANCE("Chance");
    
    private final String name;
    
    private ScoreType(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
}
