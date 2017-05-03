package homework.proj14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class ScoreCard {
    
    // instance variables
    private final ObservableList<ScoreOption> scoreOptionsList;

    // constructor
    public ScoreCard() {
        this.scoreOptionsList = FXCollections.observableArrayList();
        this.initScoreOptions();
    } // end constructor

    private void initScoreOptions() {
        // basic section
        this.scoreOptionsList.add(new ScoreOption(1, "Aces", "1 For Each Ace"));
        this.scoreOptionsList.add(new ScoreOption(2, "Dueces", "2 For Each Duece"));
        this.scoreOptionsList.add(new ScoreOption(3, "Treys", "3 For Each Trey"));
        this.scoreOptionsList.add(new ScoreOption(4, "Fours", "4 For Each Four"));
        this.scoreOptionsList.add(new ScoreOption(5, "Fives", "5 For Each Five"));
        this.scoreOptionsList.add(new ScoreOption(6, "Sixes", "6 For Each Six"));
        this.scoreOptionsList.add(new ScoreOption(16, "Total", "Total For Above", true));
        this.scoreOptionsList.add(new ScoreOption(17, "Bonus", "If Total 63-70:  35\n"+
                "If Total 17-77:  55\n"+
                "If Total 78 or Over: 75", true));
        this.scoreOptionsList.add(new ScoreOption(18, "Total", "Basic Section Plus Bonus", true));
        
        // kismet section
        this.scoreOptionsList.add(new ScoreOption(7, "2 Pair - Same Color", "Total Of All Dice"));
        this.scoreOptionsList.add(new ScoreOption(8, "3 of a Kind", "Total Of All Dice"));
        this.scoreOptionsList.add(new ScoreOption(9, "Straight", "30"));
        this.scoreOptionsList.add(new ScoreOption(10, "Flush", "35"));
        this.scoreOptionsList.add(new ScoreOption(11, "Full House", "Total Of All Dice Plus 15"));
        this.scoreOptionsList.add(new ScoreOption(12, "Full House - Same Color", "Total Of All Dice Plus 20"));
        this.scoreOptionsList.add(new ScoreOption(13, "4 of a Kind", "Total Of All Dice Plus 25"));
        this.scoreOptionsList.add(new ScoreOption(14, "Yarborough", "Total Of All Dice"));
        this.scoreOptionsList.add(new ScoreOption(15, "Kismet", "Total Of All Dice Plus 50"));
        this.scoreOptionsList.add(new ScoreOption(19, "Total", "Kismet Section Total", true));
        this.scoreOptionsList.add(new ScoreOption(20, "Total", "Basic Section Total", true));
        this.scoreOptionsList.add(new ScoreOption(21, "Total", "Final Total", true));
    } // end initScoreOptions

    public ObservableList<ScoreOption> getScoreOptionsList() {
        return this.scoreOptionsList;
    } // end getScoreOptionsList
    
    public ScoreOption getScoreOptionById(int id){
        return this.scoreOptionsList.stream().filter((scoreOption) -> {
            return scoreOption.getId() == id;
        }).findFirst().get();
    } // end getScoreOptionById
    
} // end of class
