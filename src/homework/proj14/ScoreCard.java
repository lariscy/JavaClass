package homework.proj14;

/**
 * @author Steven Lariscy
 */
public class Scorecard {
    
    private final ScoreOption[] scoreOptions;

    public Scorecard() {
        this.scoreOptions = new ScoreOption[15];
        this.initScoreOptions();
    }

    private void initScoreOptions() {
        // basic section
        this.scoreOptions[0] = new ScoreOption(1, "Aces");
        this.scoreOptions[1] = new ScoreOption(2, "Dueces");
        this.scoreOptions[2] = new ScoreOption(3, "Treys");
        this.scoreOptions[3] = new ScoreOption(4, "Fours");
        this.scoreOptions[4] = new ScoreOption(5, "Fives");
        this.scoreOptions[5] = new ScoreOption(6, "Sixes");
        
        // Kismet section
        this.scoreOptions[6] = new ScoreOption(7, "2 Pair - Same Color");
        this.scoreOptions[7] = new ScoreOption(8, "3 of a Kind");
        this.scoreOptions[8] = new ScoreOption(9, "Straight");
        this.scoreOptions[9] = new ScoreOption(10, "Flush");
        this.scoreOptions[10] = new ScoreOption(11, "Full House");
        this.scoreOptions[11] = new ScoreOption(12, "Full House - Same Color");
        this.scoreOptions[12] = new ScoreOption(13, "4 of a Kind");
        this.scoreOptions[13] = new ScoreOption(14, "Yarborough");
        this.scoreOptions[14] = new ScoreOption(15, "Kismet");
    }
    
    private ScoreOption getScoreOption(int id){
        ScoreOption retScoreOption = null;
        for (ScoreOption so : this.scoreOptions){
            if (so.getId() == id){
                retScoreOption = so;
                break;
            }
        }
        return retScoreOption;
    }
    
    public int getOptionScore(int id){
        return this.getScoreOption(id).getScore();
    }
    
    public boolean isOptionPicked(int id){
        return this.getScoreOption(id).isPicked();
    }
    
    public String getOptionName(int id){
        return this.getScoreOption(id).getName();
    }
    
}
