package homework.proj8;

/**
 * @author Steven Lariscy
 */
public class Player {

    private final String name;
    private final Scorecard2 scorecard;

    public Player(String name) {
        this.name = name;
        this.scorecard = new Scorecard2();
    }

    public String getName() {
        return name;
    }

    public Scorecard2 getScorecard() {
        return scorecard;
    }

}
