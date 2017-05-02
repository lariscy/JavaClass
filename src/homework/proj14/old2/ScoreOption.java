package homework.proj14.old2;

import javafx.scene.control.Button;

/**
 * @author Steven
 */
public class ScoreOption {
    
    private String name;
    private String howToScore;
    private final Button btnScore;

    public ScoreOption(String name, String howToScore) {
        this.name = name;
        this.howToScore = howToScore;
        btnScore = new Button("Score");
        btnScore.setOnAction((event) -> {
            System.out.println("clicked: " + this.name);
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHowToScore() {
        return howToScore;
    }

    public void setHowToScore(String howToScore) {
        this.howToScore = howToScore;
    }

    public Button getBtnScore() {
        return btnScore;
    }

}
