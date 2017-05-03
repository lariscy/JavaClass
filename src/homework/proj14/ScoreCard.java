package homework.proj14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Steven Lariscy
 */
public class ScoreCard {
    
    private final ScoreOption[] scoreOptions;
    private final ObservableList<ScoreOption> scoreOptionsList;

    public ScoreCard() {
        this.scoreOptions = new ScoreOption[15];
        this.scoreOptionsList = FXCollections.observableArrayList();
        this.initScoreOptions();
    }

    private void initScoreOptions() {
        // basic section
        this.scoreOptions[0] = new ScoreOption(1, "Aces", "1 For Each Ace");
        this.scoreOptionsList.add(new ScoreOption(1, "Aces", "1 For Each Ace"));
        this.scoreOptions[1] = new ScoreOption(2, "Dueces", "2 For Each Duece");
        this.scoreOptionsList.add(new ScoreOption(2, "Dueces", "2 For Each Duece"));
        this.scoreOptions[2] = new ScoreOption(3, "Treys", "3 For Each Trey");
        this.scoreOptionsList.add(new ScoreOption(3, "Treys", "3 For Each Trey"));
        this.scoreOptions[3] = new ScoreOption(4, "Fours", "4 For Each Four");
        this.scoreOptionsList.add(new ScoreOption(4, "Fours", "4 For Each Four"));
        this.scoreOptions[4] = new ScoreOption(5, "Fives", "5 For Each Five");
        this.scoreOptionsList.add(new ScoreOption(5, "Fives", "5 For Each Five"));
        this.scoreOptions[5] = new ScoreOption(6, "Sixes", "6 For Each Six");
        this.scoreOptionsList.add(new ScoreOption(6, "Sixes", "6 For Each Six"));
        
        // Kismet section
        this.scoreOptions[6] = new ScoreOption(7, "2 Pair - Same Color", "Total Of All Dice");
        this.scoreOptionsList.add(new ScoreOption(7, "2 Pair - Same Color", "Total Of All Dice"));
        this.scoreOptions[7] = new ScoreOption(8, "3 of a Kind", "Total Of All Dice");
        this.scoreOptionsList.add(new ScoreOption(8, "3 of a Kind", "Total Of All Dice"));
        this.scoreOptions[8] = new ScoreOption(9, "Straight", "30");
        this.scoreOptionsList.add(new ScoreOption(9, "Straight", "30"));
        this.scoreOptions[9] = new ScoreOption(10, "Flush", "35");
        this.scoreOptionsList.add(new ScoreOption(10, "Flush", "35"));
        this.scoreOptions[10] = new ScoreOption(11, "Full House", "Total Of All Dice Plus 15");
        this.scoreOptionsList.add(new ScoreOption(11, "Full House", "Total Of All Dice Plus 15"));
        this.scoreOptions[11] = new ScoreOption(12, "Full House - Same Color", "Total Of All Dice Plus 20");
        this.scoreOptionsList.add(new ScoreOption(12, "Full House - Same Color", "Total Of All Dice Plus 20"));
        this.scoreOptions[12] = new ScoreOption(13, "4 of a Kind", "Total Of All Dice Plus 25");
        this.scoreOptionsList.add(new ScoreOption(13, "4 of a Kind", "Total Of All Dice Plus 25"));
        this.scoreOptions[13] = new ScoreOption(14, "Yarborough", "Total Of All Dice");
        this.scoreOptionsList.add(new ScoreOption(14, "Yarborough", "Total Of All Dice"));
        this.scoreOptions[14] = new ScoreOption(15, "Kismet", "Total Of All Dice Plus 50");
        this.scoreOptionsList.add(new ScoreOption(15, "Kismet", "Total Of All Dice Plus 50"));
    }

    public ObservableList<ScoreOption> getScoreOptionsList() {
        return this.scoreOptionsList;
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
    
} // end of class
